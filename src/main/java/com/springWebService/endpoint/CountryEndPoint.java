package com.springWebService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springWebService.repository.CountryRepository;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndPoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	
	private CountryRepository countryRepository;
	
	@Autowired
	public CountryEndPoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request ) {
		GetCountryResponse response = new GetCountryResponse();
		try {
			response.setCountry(countryRepository.findCountry(request.getName()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
