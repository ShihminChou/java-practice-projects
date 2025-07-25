package com.example;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static Connection connection;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        initializeDB();

        String name = JOptionPane.showInputDialog("Find a video by name.");
        String sql_statement = "SELECT * FROM video WHERE videoName = ? ;";
        PreparedStatement pps = connection.prepareStatement(sql_statement); // 避免SQL Injection
        pps.setString(1, name);
        ResultSet rs = pps.executeQuery();
        if (rs.next()) {
            int title = Integer.parseInt(rs.getString("videoId"));
            String vName = rs.getString("videoName");
            int price = Integer.parseInt(rs.getString("price"));
            JOptionPane.showMessageDialog(null, new Video(title, vName, price) );
        } else {
            JOptionPane.showMessageDialog(null, "Video not found..." );
        }

        closeDB();
    }

    private static void initializeDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaTestDB", "root", "Aa123456");
        if (connection != null) {
            System.out.println("Connected to database successfully");
        } else {
            System.out.println("Can't connect to database");
        }
    }

    private static void closeDB() throws SQLException {
        connection.close(); // 把Connection關起來，不然會佔電腦太多資源
    }
}