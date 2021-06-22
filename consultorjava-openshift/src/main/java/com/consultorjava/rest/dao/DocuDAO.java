package com.consultorjava.rest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class DocuDAO {
	
public String docuJson() {
		
		
		
		final String uri = "http://api-seguridad-eh.docublock.pe/api/login/docublock";
		

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    System.out.println(result);
	    
		return result;
		
		
	}

}
