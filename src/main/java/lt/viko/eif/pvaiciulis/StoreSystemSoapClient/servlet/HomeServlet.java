package lt.viko.eif.pvaiciulis.StoreSystemSoapClient.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.viko.eif.pvaiciulis.springsoap.gen.Receipt.wsdl.GetReceiptResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/home"}, loadOnStartup=1)
public class HomeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set up the content type of web page
        response.setContentType("text/html");

        // Writing the message on the web page
        PrintWriter out = response.getWriter();
        out.println("<h1>Menu:</h1>");
        out.println("<p><a href=\"./receipt\">Get Receipt</a></p>");
    }
}
