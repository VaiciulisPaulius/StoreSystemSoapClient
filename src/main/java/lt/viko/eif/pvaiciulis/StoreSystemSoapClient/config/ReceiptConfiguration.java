package lt.viko.eif.pvaiciulis.StoreSystemSoapClient.config;

import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.client.ReceiptClient;
import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.config.APIEndpoints;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ReceiptConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("lt.viko.eif.pvaiciulis.springsoap.gen.Receipt.wsdl");
        return marshaller;
    }

    @Bean
    public ReceiptClient studentClient(Jaxb2Marshaller marshaller) {
        ReceiptClient client = new ReceiptClient();
        client.setDefaultUri(APIEndpoints.API_ROOT);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
