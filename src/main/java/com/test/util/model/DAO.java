package com.test.util.model;

import com.test.util.ItemsList;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {


    public static ArrayList<ItemsList> getItems() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //more dynamic
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //more static

            //create the db connection object
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            //create the db statement (query)

            String readCustomersCommand = "select name, description, quantity, price from items";

            Statement readCustomers = mysqlConnection.createStatement();//creates the statement

            ResultSet results = readCustomers.executeQuery(readCustomersCommand); //executes the statement &
            //puts data in results variable

            //create array list of customers

            ArrayList<ItemsList> allItems = new ArrayList<ItemsList>();

            //map from the ResultSet to the ArrayList

            while (results.next()) {
                //create Customer object (for each row) and in each object, store first and second column data for each row
                ItemsList temp = new ItemsList(results.getString(1),
                        results.getString(2), results.getInt(3), results.getFloat(4));
                allItems.add(temp);
            }

            // create new Model and View
            return allItems;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addUser(
            String firstname,
            String lastname,
            String gender,
            long phoneNumber,
            String email
    ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUserCommand = "INSERT INTO Users " +
                    "(firstName, lastName, gender, phoneNumber, email) " +
                    "VALUES ('" +
                    firstname + "', '" +
                    lastname + "', '" +
                    gender + "', '" +
                    phoneNumber + "', '" +
                    email + "')";
            System.out.println("SQL Query " + addUserCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(addUserCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }
}







