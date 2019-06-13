package com.springWebServiceConsumer.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.springWebServiceConsumer.wsdl.GetCountryRequest;
import com.springWebServiceConsumer.wsdl.GetCountryResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {
	
	public GetCountryResponse getCountry(String country) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);
		log.info("Requesting location from "+ country);
		
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;
	}

}
