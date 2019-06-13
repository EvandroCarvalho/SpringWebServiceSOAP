package com.springWebServiceConsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springWebServiceConsumer.client.CountryClient;
import com.springWebServiceConsumer.wsdl.GetCountryResponse;

@SpringBootApplication
public class SpringWebServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebServiceConsumerApplication.class, args);
}
	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}
}
