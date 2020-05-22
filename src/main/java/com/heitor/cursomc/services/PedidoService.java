package com.heitor.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.cursomc.domain.Pedido;
import com.heitor.cursomc.repositories.PedidoRepository;
import com.heitor.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public List<Pedido> findAll() {	
		List<Pedido> obj = repo.findAll();
		return obj;
	}
	
	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado: " + id + ", tipo: " + Pedido.class.getName()));
	}
}
