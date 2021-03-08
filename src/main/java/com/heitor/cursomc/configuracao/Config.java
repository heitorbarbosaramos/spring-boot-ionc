package com.heitor.cursomc.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitor.cursomc.domain.Categoria;
import com.heitor.cursomc.domain.Cidade;
import com.heitor.cursomc.domain.Cliente;
import com.heitor.cursomc.domain.Endereco;
import com.heitor.cursomc.domain.Estado;
import com.heitor.cursomc.domain.ItemPedido;
import com.heitor.cursomc.domain.Pagamento;
import com.heitor.cursomc.domain.PagamentoComBoleto;
import com.heitor.cursomc.domain.PagamentoComCartao;
import com.heitor.cursomc.domain.Pedido;
import com.heitor.cursomc.domain.Produto;
import com.heitor.cursomc.domain.enums.EstadoPagamento;
import com.heitor.cursomc.domain.enums.TipoCliente;
import com.heitor.cursomc.repositories.CategoriaRepository;
import com.heitor.cursomc.repositories.CidadeRepository;
import com.heitor.cursomc.repositories.ClienteRepository;
import com.heitor.cursomc.repositories.EnderecoRepository;
import com.heitor.cursomc.repositories.EstadoRepository;
import com.heitor.cursomc.repositories.ItemPedidoRepository;
import com.heitor.cursomc.repositories.PagamentoRepository;
import com.heitor.cursomc.repositories.PedidoRepository;
import com.heitor.cursomc.repositories.ProdutoRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepostory;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Automotor");
		Categoria cat4 = new Categoria(null, "Motocicletas");
		Categoria cat5 = new Categoria(null, "Cama, Mesa e Banho");
		Categoria cat6 = new Categoria(null, "Informatica");
		Categoria cat7 = new Categoria(null, "Casa");
		Categoria cat8 = new Categoria(null, "Predios");
		Categoria cat9 = new Categoria(null, "Escolar");
		Categoria cat10 = new Categoria(null, "Diversos");
		Categoria cat11 = new Categoria(null, "Moda Feminina");
		Categoria cat12 = new Categoria(null, "Moda Masculina");
		Categoria cat13 = new Categoria(null, "Moda Infantil");
		Categoria cat14 = new Categoria(null, "Suprimentos");
		Categoria cat15 = new Categoria(null, "Mobilia");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12, cat13, cat14, cat15));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepostory.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "221.673.000-93", TipoCliente.PESSOA_FISICA);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "387777012", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "centro", "387777012", cli1, c2);
		
		cli1.getTelefones().add("123123123");
		cli1.getTelefones().add("312123123");
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("2017-09-30 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("2017-10-10 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("2017-10-20 00:00"), null);
		
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 200.0, 1, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, p2.getPreco());
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
