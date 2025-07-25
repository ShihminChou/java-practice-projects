package myCode;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Obj.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    private PreparedStatement preparedStatement;

    @Override
    public void init()  throws ServletException {
        initializeJDBC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String bookId = request.getParameter("bookId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        Book book = new Book();
        book.setBookId(Integer.parseInt(bookId));
        book.setName(name);
        book.setPrice(Integer.parseInt(price));
        book.setAuthor(author);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("book", book);


        PrintWriter out = response.getWriter();
        out.println("You entered the following data:");
        out.println("<p>Book Id: " + bookId + "</p>");
        out.println("<br />");
        out.println("<p>Book Name: " + name + "</p>");
        out.println("<br />");
        out.println("<p>Book Author: " + author + "</p>");
        out.println("<br />");

        out.println("<form method=\"post\" action=\"/sessionRegis\">");
        out.println("<input type=\"submit\" value=\"Confirm\">");
        out.println("</form>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Book book = (Book) httpSession.getAttribute("book");

        try {
            storeBook(book.getBookId(), book.getName(), book.getPrice(), book.getAuthor());
            PrintWriter out = response.getWriter();
            out.println("Book " + book.getName() + " has been posted successfully");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
