package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:12 2019-03-11
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class HelloWorld {
    private String message;
    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
    public void destroy()
    {
        // do nothing.
    }
}
