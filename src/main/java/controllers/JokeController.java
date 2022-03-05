package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.JokeService;

@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired // Em injecção via construtor, a anotação @Autowired é opcional
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""}) // aceita requests com '/' e sem barra
    public String getJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
