package lt.viko.eif.pvaiciulis.StoreSystemSoapClient.converter;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Converter {
    public static boolean toHtml() {
        try {
            File xslFile = new File("src/main/resources/htmlReceipts.xsl");
            StreamSource xmlSource = new StreamSource(new File("src/main/resources/response.xml"));

            TransformerFactory fac = TransformerFactory.newInstance();
            Transformer transformer = fac.newTransformer(new StreamSource(xslFile));

            OutputStream out = new FileOutputStream("src/main/resources/index.html");
            try {
                Result result = new StreamResult(out);
                transformer.transform(xmlSource, result);
                return true;
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch(TransformerConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
