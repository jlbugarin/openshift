package com.consultorjava.rest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class NasaDAO {

	public String nasaImageJson() {
		
		
		//llamada spring web service
		
		//http://dummy.restapiexample.com/api/v1/employees
		final String uri="https://api.nasa.gov/planetary/apod?api_key=BNnOMpUYGOuT2y8VzMDYzeuqD7ZDmMlZclTCGO7T";
		//final String uri = "http://api-seguridad-eh.docublock.pe/api/login/docublock";
		//http://api-seguridad-eh.docublock.pe/api/login/docublock

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    System.out.println(result);
	    
		return result;
		
		
	}
	
}
