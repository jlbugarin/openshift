package com.consultorjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.consultorjava.rest.dao.ProspectoDAO;
import com.consultorjava.rest.model.Prospecto;
import com.consultorjava.rest.model.Prospectos;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(path = "/prospectos")
public class ProspectoController {

	@Autowired
	private ProspectoDAO prospectoDao;
	public static int inum=0;

	@GetMapping(path = "/", produces = "application/json")
	public Prospectos getProspectos() {
		
		System.out.println(""+inum++);
		return prospectoDao.getAllProspectos();
	}
	
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addProspecto(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ILU") String headerLocation,
                        @RequestBody Prospecto prospecto) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = prospectoDao.getAllProspectos().getProspectoLista().size() + 1;
        prospecto.setId(id);
        
        //add resource
        prospectoDao.addProspecto(prospecto);
        
        //Create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(prospecto.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }

}
