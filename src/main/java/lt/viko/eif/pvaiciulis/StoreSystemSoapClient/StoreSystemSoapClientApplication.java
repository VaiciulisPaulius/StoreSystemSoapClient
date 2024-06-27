package lt.viko.eif.pvaiciulis.StoreSystemSoapClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StoreSystemSoapClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreSystemSoapClientApplication.class, args);
    }
}