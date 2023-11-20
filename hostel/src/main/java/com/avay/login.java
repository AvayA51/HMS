package com.avay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {

    public static boolean validate(String email, String password) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://your_database_url:3306/signup", "root", "7722qwe");

            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from Signup where email = ? and password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}