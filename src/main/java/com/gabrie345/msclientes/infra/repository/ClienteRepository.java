package com.gabrie345.msclientes.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gabrie345.msclientes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Transactional(readOnly = true)
	Optional<Cliente> findByCpf(String cpf);
	
	Optional<Cliente> findById(Long id);

}
