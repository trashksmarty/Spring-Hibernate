package ru.maven.spitter.config.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserDAO userDao;

    
    @RequestMapping(value = "/registration")
    public String newUser(@RequestParam(value = "myParam[]") String[] myParam, Model model) throws SQLException {
        userDao.saveUser(myParam);
        return "redirect:/hello";
    }

    @RequestMapping(value = "/newuser")
    public String neUser(@RequestParam(defaultValue = "__", required = false, value = "name") String[] myParam, Model model) {
        return "user/newuser";
    }

    @RequestMapping(value = "/findallusers")
    public String allUser(Model model) {
        model.addAttribute("name", "all");
        model.addAttribute("myList", userDao.findAllUser());
        return "user/findallusers";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(value = "myParam[]") String[] myParam, Model model) {
        model.addAttribute("id", myParam[0]);
        model.addAttribute("nickname", myParam[1]);
        model.addAttribute("firstname", myParam[2]);
        model.addAttribute("lastname", myParam[3]);
        model.addAttribute("email", myParam[4]);
        model.addAttribute("urladdress", myParam[5]);
        return "user/edit";
    }

    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
    public String saveEdit(@RequestParam(value = "myParam[]") String[] myParam, Model model) {
        userDao.edit(myParam);
        model.addAttribute("urladdress", myParam[5]);
        return "user/editclose";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "myParam[]") String myParam[], Model model) {
        userDao.deleteUser(Integer.parseInt(myParam[0]));
        model.addAttribute("urladdress", myParam[1]);
        return "user/editclose";
    }

    @RequestMapping(value = "/finduser")
    public String findUser() {
        return "user/finduser";
    }

    @RequestMapping(value = "/found")
    public String findUser(@RequestParam(value = "myParam[]") String myParam[], Model model) {
        if (userDao.paramEquals(myParam)) {
            List l = userDao.findUser(myParam);
            if(l.size()<1){
                model.addAttribute("exception", "По данному запросу никого не найдено.");
                return "user/finduser";
            }
            model.addAttribute("myList", l);
            model.addAttribute("name", myParam[0]);
            return "user/found";
        }
        model.addAttribute("exception", "Заполните минимум 1 поле!");
        return "user/finduser";
    }

    @RequestMapping(value = "/editclose")
    public String editClose() {
        return "";
    }
}
