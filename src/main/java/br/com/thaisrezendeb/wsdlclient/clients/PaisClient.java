package br.com.thaisrezendeb.wsdlclient.clients;

import br.com.thaisrezendeb.wsdlclient.wsdl.GetPaisRequest;
import br.com.thaisrezendeb.wsdlclient.wsdl.GetPaisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PaisClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PaisClient.class);

    public GetPaisResponse getPais(String pais) {
        GetPaisRequest request = new GetPaisRequest();
        request.setNome(pais);

        log.info("Obtendo dados sobre {}", pais);

        GetPaisResponse resposne = (GetPaisResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/paises",
                        request,
                        new SoapActionCallback("http://thaisrezendeb.com.br/wsdlserver/assets/GetPaisRequest"));
        return resposne;
    }
}
