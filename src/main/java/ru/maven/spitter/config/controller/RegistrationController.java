package ru.maven.spitter.config.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.maven.spitter.DAO.entity.User;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;

@Controller
public class RegistrationController {
    
    @Autowired
    private UserDAO userDao;
    
    @PreAuthorize("!isAuthenticated()")
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    
    @PreAuthorize("!isAuthenticated()")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "registration";
        }
        if(userDao.volInsertUser(user)){
            model.addAttribute("user", new User());
            model.addAttribute("error", "Такой пользователь уже есть.");
            return "registration";
        }
        model.addAttribute("name", "Регистрация завершина");
        userDao.insertUser(user);
        return "redirect:/hello";
    }
}
