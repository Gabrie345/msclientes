package com.gabrie345.msclientes.application;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabrie345.msclientes.application.dto.ClienteSaveRequestDto;
import com.gabrie345.msclientes.domain.Cliente;

import lombok.extern.slf4j.Slf4j;

	

@RestController
@RequestMapping(value="cliente")
@Slf4j
public class ClientesController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	  private static Logger logger = LoggerFactory.getLogger(Slf4j.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String status() {
        logger.info("Info log message");
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody ClienteSaveRequestDto payload) {
		Cliente clienteDto = payload.toModel();
		
		Cliente response = service.saved(clienteDto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Cliente> dadosCliente(@PathVariable Long id) {
		Optional<Cliente> response = service.findById(id);
		
		if(response.isEmpty()) 
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<>(response.get(), HttpStatus.OK);
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<Cliente> dadosClientecomCpf(@RequestParam("cpf") String cpf) {
		Optional<Cliente> response = service.buscarPorCpf(cpf);
		
		if(response.isEmpty()) 
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<>(response.get(), HttpStatus.OK);
	}
	
	

}
