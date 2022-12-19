package com.gabrie345.msclientes.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="cliente")
public class ClientesController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String status() {
		return "ok";
	}
	

}
