package lt.viko.eif.pvaiciulis.StoreSystemSoapClient;

import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoggingInterceptor implements ClientInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        try {
            logToFile("request.xml", messageContext.getRequest().getPayloadSource());
            return true;
        } catch(IOException exception) {
            System.out.println("Exception occured: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        try {
            logToFile("response.xml", messageContext.getResponse().getPayloadSource());
            return true;
        } catch(IOException exception) {
            System.out.println("Exception occured: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean handleFault(MessageContext messageContext) {
        try {
            logToFile("fault.xml", messageContext.getResponse().getPayloadSource());
            return true;
        } catch(IOException exception) {
            System.out.println("Exception occured: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) {
        try {
            if (ex instanceof SoapFaultClientException) {
                logToFile("fault.xml", messageContext.getResponse().getPayloadSource());
            }
        } catch(IOException exception) {
            System.out.println("Exception occured: " + exception.getMessage());
        }
    }

    private void logToFile(String fileName, Source source) throws IOException {
        File file = new File("" + fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            StreamResult result = new StreamResult(fos);
            TransformerFactory.newInstance().newTransformer().transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
