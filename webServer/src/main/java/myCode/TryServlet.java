package myCode;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "TryServlet", value = "/TryServlet")
public class TryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("We are now calling the init method...");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        super.service(request, response);
        System.out.println("We are now calling the service method...");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("We are now calling the destroy method...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // 從HttpServletResponse get一個Writer 叫做out
        out.println("<html>");
        out.println("<body>");
        out.println("<p>This paragraph if from try servlet.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}