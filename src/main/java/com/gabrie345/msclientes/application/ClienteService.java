package com.gabrie345.msclientes.application;

import javax.transaction.Transactional;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.gabrie345.msclientes.domain.Cliente;
import com.gabrie345.msclientes.infra.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository= repository;
		
	}
	
	@Transactional
	public Cliente saved(Cliente cliente) {
		return repository.save(cliente);
		
	}
	
	public Optional<Cliente> buscarPorCpf(String cpf) {
		Optional<Cliente> response = repository.findByCpf(cpf);
		return response;
		
	}
	

}
