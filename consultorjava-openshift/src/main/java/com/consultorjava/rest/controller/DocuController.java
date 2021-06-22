package com.consultorjava.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorjava.rest.dao.DocuDAO;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(path = "/docu")
public class DocuController {
	
	@Autowired
	private DocuDAO docuDao;
	
	@GetMapping(path = "/", produces = "application/json")
	public String nasaImagenData () {
		return docuDao.docuJson();
	}
	

}
