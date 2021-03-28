
package com.heitor.cursomc.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.heitor.cursomc.domain.Cliente;
import com.heitor.cursomc.domain.Endereco;
import com.heitor.cursomc.domain.DTO.ClienteDTO;
import com.heitor.cursomc.domain.DTO.ClienteNewDTO;
import com.heitor.cursomc.services.ClienteService;
import com.heitor.cursomc.services.EnderecoService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

	@Autowired
	ClienteService service;
	@Autowired
	EnderecoService serviceEndereco;
	
	private Logger LOG = LoggerFactory.getLogger(ClienteResources.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	

	@RequestMapping(value= "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0" ) Integer page, 
			@RequestParam(value = "pageLine", defaultValue = "24" ) Integer pageLine, 
			@RequestParam(value = "direction", defaultValue = "ASC" ) String direction, 
			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy
			){
		Page<Cliente> list = service.findPage(page, pageLine, direction, orderBy);
		Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody ClienteNewDTO objDto){
		Cliente obj = service.fromNewDto(objDto);
		obj = service.insert(obj);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), obj, null);
		serviceEndereco.save(end);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody ClienteDTO objDto, @PathVariable Integer id){
		objDto.setId(id);
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
