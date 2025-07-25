package myCode;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "GetFormServlet", value = "/GetFormServlet")
public class GetFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get parameters from get request
        String bookName = request.getParameter("name");
        String bookPrice = request.getParameter("price");
        String bookAuthor = request.getParameter("author");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3> Name: " + bookName + "</h3>");
        out.println("<h3> Price: " + bookPrice + "</h3>");
        out.println("<h3> Author: " + bookAuthor + "</h3>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
