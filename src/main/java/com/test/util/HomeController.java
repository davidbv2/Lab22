package com.test.util;

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

    @RequestMapping("/")
    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("welcome","message","Hello World");
    }

    @RequestMapping("/userform")
    public ModelAndView userform(){

       return new ModelAndView("registerpage","inst","Please enter your information below.");

    }

    @RequestMapping("/formhandler")
    public ModelAndView formhandler (
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("num") long phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("favcoffee") String favcoffee
    )
    //server side validation
    {
        ModelAndView mv = new ModelAndView("summarypage");
        mv.addObject("firstname",firstname);
        mv.addObject("lastname", lastname);
        mv.addObject("num",phoneNumber);
        mv.addObject("email",email);
        mv.addObject("favcoffee",favcoffee);
        return mv;
    }

    @RequestMapping (value ="getAllCustomers")
    public ModelAndView getAllCustomers(){
        //define the data for the connection
        String dbAddress = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "LetMeIn";
        //load driver
        try {
            Class.forName("com.mysql.jdbc.Driver"); //more dynamic
           //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //more static

            //create the db connection object
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(dbAddress,username,password);

            //create the db statement (query)

            String readCustomersCommand = "select customerid, companyname from customers";

            Statement readCustomers = mysqlConnection.createStatement();//creates the statement

            ResultSet results = readCustomers.executeQuery(readCustomersCommand); //executes the statement &
            //puts data in results variable

            //create array list of customers

            ArrayList<Customer> customerList = new ArrayList<Customer>();

            //map from the ResultSet to the ArrayList

            while (results.next())
            {
                //create Customer object (for each row) and in each object, store first and second column data for each row
                Customer temp = new Customer(results.getString(1),
                        results.getString(2));
                customerList.add(temp);

            }

            // create new Model and View
            return new ModelAndView("customerView","cList",customerList);

        } catch (Exception e) {

        }

        //proper way is to create view with custom error messages and instructions for the user
        return null;
    }

}