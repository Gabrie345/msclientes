package com.gabrie345.msclientes.application;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrie345.msclientes.domain.Cliente;
import com.gabrie345.msclientes.infra.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository= repository;
		
	}
	
	@Transactional
	public Cliente saved(Cliente cliente) {
		return repository.save(cliente);
		
	}
	
	@Transactional
	public Optional<Cliente> buscarPorCpf(String cpf) {
		Optional<Cliente> response = repository.findByCpf(cpf);
		return response;
		
	}
	
	@Transactional
	Optional<Cliente> findById(Long id){
		Optional<Cliente> response = repository.findById(id);
		return response;
		
	}
	

}
