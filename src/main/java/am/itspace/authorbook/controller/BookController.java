package am.itspace.authorbook.controller;

import am.itspace.authorbook.model.Book;
import am.itspace.authorbook.reposirory.BookRepository;
import am.itspace.authorbook.service.AuthorService;
import am.itspace.authorbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String bookPage(@RequestParam(value = "message", required = false) String message, ModelMap modelMap) {
        modelMap.addAttribute("authors", authorService.findAll());
        modelMap.addAttribute("books", bookRepository.findAll());
        modelMap.addAttribute("message", message);
        return "book";
    }

    @PostMapping("/saveBook")
    public String addBook(@ModelAttribute Book book) {
        String msg = book.getId() > 0 ? "Book was updated" : "Book was added";
        bookRepository.save(book);
        return "redirect:/?msg=" + msg;
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteBookById(id);
        String message = "Book was removed";
        return "redirect:/book?message=" + message;
    }

    @GetMapping("/editBook")
    public String editBook(@RequestParam("id") int id, ModelMap modelMap) {
        Book book = bookService.getBook(id);
        modelMap.addAttribute("book", book);
        modelMap.addAttribute("authorss", authorService.findAll());
        return "editBook";
    }
}
