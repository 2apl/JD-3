package by.library.demo.service;

import java.util.List;

import by.library.demo.dto.ResultDto;
import by.library.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<ResultDto> getResult(List<String> selectedAuthors, List<String> selectedGenres, Integer yearFrom, Integer yearTo) {
        return bookRepository.getResult(selectedAuthors, selectedGenres, yearFrom, yearTo);
    }

    public List<String> findAllAuthors() {
        return bookRepository.findAllAuthors();
    }

    public List<String> findAllGenres() {
        return bookRepository.findAllGenres();
    }

}
