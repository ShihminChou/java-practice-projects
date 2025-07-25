package myCode;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "PostFormServlet", value = "/PostFormServlet")
public class PostFormServlet extends HttpServlet {

    private PreparedStatement preparedStatement;
    PrintWriter out;

    @Override
    public void init()  throws ServletException {
        initializeJDBC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        storeBook(Integer.parseInt(bookId), name, Integer.parseInt(price), author);
        out =  response.getWriter();

        out.println("Book " + name + " has been posted successfully");
        out.close();
    }

    private void initializeJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaTestDB", "root", "Aa123456");
            System.out.println("Connected to database successfully");

            preparedStatement = connection.prepareStatement("insert into Book " + "(bookId, name, author, price) values (?, ?, ?, ?)");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void storeBook(int id, String name, int price, String author) {
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, author);
            preparedStatement.setInt(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
