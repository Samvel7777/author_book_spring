package am.itspace.authorbook.controller;

import am.itspace.authorbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final AuthorService authorService;

    @GetMapping("/")
    public String homePage(@RequestParam(value = "msg", required = false) String msg, ModelMap modelMap) {
        modelMap.addAttribute("authors", authorService.findAll());
        modelMap.addAttribute("msg", msg);
        return "home";
    }
}
