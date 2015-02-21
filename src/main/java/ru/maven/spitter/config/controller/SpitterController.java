package ru.maven.spitter.config.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;

@Controller
public class SpitterController {

    @Autowired
    private UserDAO userDao;
    
    @RequestMapping(value = {"/", "/hello"})
    public String index(@RequestParam(defaultValue = "World", required = false, value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/registration")
    public String newUser(@RequestParam(value = "myParam[]") String[] myParam, Model model) throws SQLException {
        userDao.saveUser(myParam);
        return "newuser";
    }

    @RequestMapping(value = "/newuser")
    public String neUser(@RequestParam(defaultValue = "__________", required = false, value = "name") String[] myParam, Model model) {
        return "newuser";
    }

}
