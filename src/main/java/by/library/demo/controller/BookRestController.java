package by.library.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import by.library.demo.dto.ResultDto;
import by.library.demo.service.BookService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find-all-authors")
    public List<String> findAllAuthors() {
        return bookService.findAllAuthors();
    }

    @GetMapping("/find-all-genres")
    public List<String> findAllGenres() {
        return bookService.findAllGenres();
    }

    @PostMapping("/books")
    public void getResult(
            @RequestParam(value = "selectedAuthors", required = false)String[] selectedAuthors,
            @RequestParam(value = "selectedGenres", required = false) String[] selectedGenres,
            @RequestParam(value = "yearFrom", required = false) Integer yearFrom,
            @RequestParam(value = "yearTo", required = false) Integer yearTo,
            HttpServletResponse response) {

        List<String> authorsList;
        List<String> genresList;
        if (selectedAuthors == null) {
            authorsList = bookService.findAllAuthors();
        } else {
            authorsList = Arrays.asList(selectedAuthors);
        }
        if (selectedGenres == null) {
            genresList = bookService.findAllGenres();
        } else {
            genresList = Arrays.asList(selectedGenres);
        }
        if (yearFrom == null) {
            yearFrom = 0;
        }
        if (yearTo == null) {
            yearTo = LocalDate.now().getYear();
        }

        List<ResultDto> result = bookService.getResult(authorsList, genresList, yearFrom, yearTo);
        printToCSV(response, result);

    }

    private void printToCSV(HttpServletResponse response, List<ResultDto> result) {
        String[] headers = {"name", "create year", "genre", "author"};
        response.setContentType("application/csv");
        try (CSVPrinter printer = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT.withHeader(headers))) {
            for (ResultDto resultDto : result) {
                printer.printRecord(resultDto.getBookName(), resultDto.getCreationYear(), resultDto.getGenreName(), resultDto.getAuthorName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
