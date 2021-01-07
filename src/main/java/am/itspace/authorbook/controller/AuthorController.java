package am.itspace.authorbook.controller;

import am.itspace.authorbook.model.Author;
import am.itspace.authorbook.reposirory.AuthorRepository;
import am.itspace.authorbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author")
    public String authorPage(@RequestParam(value = "message", required = false) String message, ModelMap modelMap) {
        modelMap.addAttribute("authors", authorService.findAll());
        modelMap.addAttribute("message", message);
        return "author";
    }

    @PostMapping("/saveAuthor")
    public String addAuthor(@ModelAttribute Author author) {
        String msg = author.getId() > 0 ? "Author was updated" : "Author was added";
        authorService.save(author);
        return "redirect:/?msg=" + msg;
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorService.deleteAuthorById(id);
        String message = "Author was removed";
        return "redirect:/author?message=" + message;
    }

    @GetMapping("/editAuthor")
    public String editAuthor(@RequestParam("id") int id, ModelMap modelMap) {
        Author author = authorService.getAuthor(id);
        modelMap.addAttribute("author", author);
        return "editAuthor";
    }
}
