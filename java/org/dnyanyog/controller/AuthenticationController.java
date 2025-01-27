package org.dnyanyog.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	    @GetMapping("/data")
	    public String data() throws SQLException {
	        String url = "jdbc:mysql://127.0.0.1:3306/javafx_ecommerce_maven";
	        String username = "root";
	        String pass = "12345";

	        Connection connection = DriverManager.getConnection(url, username, pass);

	        Statement statement = connection.createStatement();

	        String query = ("select * from javafx_ecommerce_maven.Users");
	        ResultSet result = statement.executeQuery(query);
	        String name = "";
	        while(result.next()) {
	            System.out.println("User ID: " + result.getString(1));
	            name = result.getString(2);
	            System.out.println("Gmail: " + result.getString(3));
	            System.out.println("Password: " + result.getString(4));

	        }

	        return name;
	    }
	}



