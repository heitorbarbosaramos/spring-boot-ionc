package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Categoria;
import com.heitor.cursomc.repositories.CategoriaRepository;
import com.heitor.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> findAll(){
		List<Categoria> obj = repo.findAll();
		return obj;
	}
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() ->new ObjectNotFoundException("Objeto Não Encontrado, ID: " + id + ", Tipo: "+Categoria.class.getName() ));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
}
