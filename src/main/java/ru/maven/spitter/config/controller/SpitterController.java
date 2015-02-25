package ru.maven.spitter.config.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return "hello";
    }

    @RequestMapping(value = "/newuser")
    public String neUser(@RequestParam(defaultValue = "__", required = false, value = "name") String[] myParam, Model model) {
        return "newuser";
    }
    
    @RequestMapping(value = "/finduser")
    public String allUser(Model model){
        model.addAttribute("name", "all");
        model.addAttribute("myList", userDao.findAllUser());
        return "finduser";
    }
    
    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(value = "myParam[]") String[] myParam, Model model){
        model.addAttribute("id", myParam[0]);
        model.addAttribute("nickname", myParam[1]);
        model.addAttribute("firstname", myParam[2]);
        model.addAttribute("lastname", myParam[3]);
        model.addAttribute("email", myParam[4]);
        return "edit";
    }
    
    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
    public String saveEdit(@RequestParam(value = "myParam[]") String[] myParam){
        userDao.edit(myParam);
        return "editclose";
    }
    
    @RequestMapping(value = "/editclose")
    public String editClose(){
        return "finduser";
    }
}
