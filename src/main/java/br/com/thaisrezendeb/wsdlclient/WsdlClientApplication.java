package br.com.thaisrezendeb.wsdlclient;

import br.com.thaisrezendeb.wsdlclient.clients.PaisClient;
import br.com.thaisrezendeb.wsdlclient.wsdl.GetPaisResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(PaisClient quoteClient) {
		return args -> {
			String pais = "Brasil";

			if(args.length > 0)
				pais = args[0];

			GetPaisResponse response = quoteClient.getPais(pais);
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());

			response = quoteClient.getPais("Reino Unido");
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());
		};
	}
}
