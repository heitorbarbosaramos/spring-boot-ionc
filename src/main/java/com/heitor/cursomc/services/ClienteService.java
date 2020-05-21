package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Cliente;
import com.heitor.cursomc.repositories.ClienteRepository;
import com.heitor.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public List<Cliente> findAll() {	
		List<Cliente> obj = repo.findAll();
		return obj;
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado: " + id + ", tipo: " + Cliente.class.getName()));
	}
}
