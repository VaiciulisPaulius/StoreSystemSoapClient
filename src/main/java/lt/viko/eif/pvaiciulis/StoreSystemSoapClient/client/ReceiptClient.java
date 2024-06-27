package lt.viko.eif.pvaiciulis.StoreSystemSoapClient.client;

import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.LoggingInterceptor;
import lt.viko.eif.pvaiciulis.springsoap.gen.Receipt.wsdl.GetReceiptRequest;
import lt.viko.eif.pvaiciulis.springsoap.gen.Receipt.wsdl.GetReceiptResponse;
import lt.viko.eif.pvaiciulis.StoreSystemSoapClient.config.APIEndpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class ReceiptClient  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ReceiptClient.class);

    public GetReceiptResponse getReceipt(int id) {

        GetReceiptRequest request = new GetReceiptRequest();
        request.setId(id);

        log.info("Requesting location for receipt #" + id);

        GetReceiptResponse response = (GetReceiptResponse) getWebServiceTemplate()
                .marshalSendAndReceive(APIEndpoints.API_ROOT, request,
                        new SoapActionCallback(
                                "http://eif.viko.lt/pvaiciulis/springsoap/gen/getReceiptRequest"));

        return response;
    }

}
