package ru.maven.spitter.config.controller;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.maven.spitter.DAO.entity.Users;
import ru.maven.spitter.DAO.interfaceDAO.UserDAO;
import ru.maven.spitter.view.SpitterExcelView;
import ru.maven.spitter.view.SpitterPDFView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private SpitterExcelView excelView;

    @Autowired
    private SpitterPDFView pdfView;

    @RequestMapping(value = "newuser", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user/newuser";
        }
        userDao.saveUser(user);
        return "redirect:/hello";
    }

    @RequestMapping(value = "newuser", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "user/newuser";
    }

    @RequestMapping(value = "/findallusers", method = {RequestMethod.GET})
    public String allUser(Model model, HttpServletRequest request) {
        List<Users> lu = userDao.findAllUser();
        model.addAttribute("name", "all (" + lu.size() + ")");
        model.addAttribute("myList", lu);
        request.getSession().setAttribute("myList", lu);
        model.addAttribute("user", new Users());
        return "user/findallusers";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(String myParam, Model model, Users user) {
        model.addAttribute("urladdress", myParam);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
    public String saveEdit(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model, String myParam) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("urladdress", myParam);
            return "user/edit";
        }
        userDao.saveUser(user);
        model.addAttribute("urladdress", myParam);
        return "user/editclose";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(String myParam, Model model, Users user) {
        userDao.deleteUser(user);
        model.addAttribute("urladdress", myParam);
        return "user/editclose";
    }

    @RequestMapping(value = "/finduser", method = RequestMethod.GET)
    public String findUser(Model model) {
        model.addAttribute("user", new Users());
        return "user/finduser";
    }

    @RequestMapping(value = "/found", method = RequestMethod.POST)
    public String findUser(Users user, Model model, HttpServletRequest request) {
        if (userDao.paramEquals(user)) {
            List<Users> l = userDao.findUser(user);
            if (l.isEmpty()) {
                model.addAttribute("user", new Users());
                model.addAttribute("exception", "По данному запросу никого не найдено.");
                return "user/finduser";
            }
            model.addAttribute("myList", l);
            model.addAttribute("name", l.size());
            request.getSession().setAttribute("myList", l);
            model.addAttribute("user", new Users());
            return "user/findallusers";
        }
        model.addAttribute("user", new Users());
        model.addAttribute("exception", "Заполните минимум 1 поле!");
        return "user/finduser";
    }

    @RequestMapping(value = "/editclose")
    public String editClose() {
        return "";
    }

    @RequestMapping(value = {"/downloadExcel"}, method = RequestMethod.POST)
    public ModelAndView downloadExcel(HttpServletRequest request) throws ServletException {
        List<Users> myList = (List<Users>) request.getSession().getAttribute("myList");
        return new ModelAndView(excelView, "listUsers", myList);
    }

    @RequestMapping(value = {"/downloadPDF"}, method = RequestMethod.POST)
    public ModelAndView downloadPDF(HttpServletRequest request) throws ServletException {
        List<Users> myList = (List<Users>) request.getSession().getAttribute("myList");
        return new ModelAndView(pdfView, "listUsers", myList);
    }
}
