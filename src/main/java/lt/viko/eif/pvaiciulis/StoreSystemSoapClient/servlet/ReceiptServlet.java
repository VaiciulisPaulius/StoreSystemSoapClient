package lt.viko.eif.pvaiciulis.StoreSystemSoapClient.servlet;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.client.ReceiptClient;
import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.converter.Converter;
import lt.viko.eif.pvaiciulis.springsoap.gen.Receipt.wsdl.GetReceiptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.*;

@WebServlet(urlPatterns = {"/receipt"}, loadOnStartup=1)
public class ReceiptServlet extends HttpServlet {
    @Autowired
    private ReceiptClient receiptClient;
    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Converter.toHtml();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/index.html"));

             PrintWriter out = response.getWriter()) {

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("<html><body><h1>404 Not Found</h1></body></html>");
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("<html><body><h1>500 Internal Server Error</h1></body></html>");
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
