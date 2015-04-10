package ru.maven.spitter.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpitterController {

    @RequestMapping(value = {"/", "/hello"})
    public String index(@RequestParam(defaultValue = "World", required = false, value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
