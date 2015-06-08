package ru.maven.spitter.config.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpitterController {

    @RequestMapping(value = {"/", "/hello"})
    public String index(@RequestParam(defaultValue = "Hello World",
            required = false, value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PreAuthorize("!isAuthenticated() or (isAuthenticated() and hasRole('ROLE_ADMIN'))")
    @RequestMapping("/login")
    public String login(Model model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }
}
