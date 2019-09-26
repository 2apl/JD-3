package by.library.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookController {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/books")
    public String showBooksPage(Model model) {
        List<String> authors = restTemplate.getForEntity("http://localhost:8080/find-all-authors", List.class).getBody();
        List<String> genres = restTemplate.getForEntity("http://localhost:8080/find-all-genres", List.class).getBody();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);

        return "books";
    }


}
