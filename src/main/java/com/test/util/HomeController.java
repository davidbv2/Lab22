package com.test.util;

import com.test.util.model.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
public class HomeController {

//    @RequestMapping("/")
//    public ModelAndView helloWorld() {
//        return new
//                ModelAndView("welcome", "message", "Hello World");
//    }

    @RequestMapping("/")
    public ModelAndView getAllItems() {
        ArrayList<ItemsList> ItemsMenu = DAO.getItems();

        if (ItemsMenu == null) {
            return new ModelAndView("error", "errmsg", "Customer list is null");
        }
        return new ModelAndView("welcome", "itList", ItemsMenu);
    }

    @RequestMapping("/userform")
    public ModelAndView userform() {

        return new ModelAndView("registerpage", "inst", "Please enter your information below.");

    }

    @RequestMapping("/formhandler")
    public ModelAndView formhandler(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("gender") String gender,
            @RequestParam("num") long phoneNumber,
            @RequestParam("email") String email
    ) {
        //add the info to DB through DAO
        boolean result = DAO.addUser(firstname,lastname,gender,phoneNumber,email);
        //best to check the result
        if (result == false) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "user add failed");
        }

        {
            ModelAndView mv = new ModelAndView("summarypage");
            mv.addObject("firstname", firstname);
            mv.addObject("lastname", lastname);
            mv.addObject("gender", gender);
            mv.addObject("num", phoneNumber);
            mv.addObject("email", email);
            return mv;
        }

    }
}
