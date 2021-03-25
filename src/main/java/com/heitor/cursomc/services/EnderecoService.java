package com.heitor.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Endereco;
import com.heitor.cursomc.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;
	
	public Endereco save (Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
}
