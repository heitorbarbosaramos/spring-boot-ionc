package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Cliente;
import com.heitor.cursomc.domain.DTO.ClienteDTO;
import com.heitor.cursomc.domain.enums.TipoCliente;
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

	public Page<Cliente> findPage(Integer page, Integer pageLine, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, pageLine, Direction.valueOf(direction), orderBy); 
		return repo.findAll(pageRequest);
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
		
	}

	public Cliente fromDto(@Valid ClienteDTO objDto) {
		Cliente obj = new Cliente(null, objDto.getNome(), objDto.getEmail(), null, TipoCliente.PESSOA_FISICA);
		return obj;
	}

	public Cliente update(ClienteDTO objDto) {
		Cliente  obj = findById(objDto.getId());
		obj.setNome(objDto.getNome());
		obj.setEmail(objDto.getEmail());
		obj = repo.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		repo.delete(findById(id));
	}
}
