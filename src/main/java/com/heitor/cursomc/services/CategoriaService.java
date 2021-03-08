package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		repo.delete(findById(id));
	}
	
	public Page<Categoria> findPage(Integer page, Integer pageLine, String direction, String orderBy) {
		PageRequest  pageRequest = PageRequest.of(page, pageLine, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
