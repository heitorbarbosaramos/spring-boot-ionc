package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Cidade;
import com.heitor.cursomc.domain.Cliente;
import com.heitor.cursomc.domain.Endereco;
import com.heitor.cursomc.domain.DTO.ClienteDTO;
import com.heitor.cursomc.domain.DTO.ClienteNewDTO;
import com.heitor.cursomc.domain.enums.TipoCliente;
import com.heitor.cursomc.repositories.CidadeRepository;
import com.heitor.cursomc.repositories.ClienteRepository;
import com.heitor.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	@Autowired
	CidadeRepository repoCidade;
	
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
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		
		obj = repo.save(obj);
		return obj;
		
	}

	public Cliente fromDto(@Valid ClienteDTO objDto) {
		Cliente obj = new Cliente(null, objDto.getNome(), objDto.getEmail(), null, TipoCliente.PESSOA_FISICA);
		objDto.getEnderecos().forEach(l->{
			obj.setEnderecos(l);
		});
		objDto.getTelefones().forEach(l->{
			obj.setTelefones(l);
		});		
		return obj;
	}

	public Cliente fromNewDto(@Valid ClienteNewDTO objDto) {
		Cliente obj = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipoCliente()));
		Cidade cidade = repoCidade.findById(objDto.getCidadeId()).orElse(null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), obj, cidade);
		obj.setEnderecos(end);
		if(!objDto.getTelefone1().isEmpty()) {
			obj.setTelefones(objDto.getTelefone1());
		}
		if(!objDto.getTelefone2().isEmpty()) {
			obj.setTelefones(objDto.getTelefone2());
		}
		if(!objDto.getTelefone3().isEmpty()) {
			obj.setTelefones(objDto.getTelefone3());
		}
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
