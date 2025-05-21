package br.fatec.aula_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aula_api.model.Produto;

@RestController
public class ProdutoController {
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	@GetMapping(path = "/produtos")
	public List<Produto> getProdutos() {
		
		Produto p = new Produto();
		p.setCodigo(9393);
		p.setDescricao("notebook");
		p.setMarca("asus");
		p.setEstoque(9);
		p.setPrecoCusto(2500.99);
		p.setPrecoVenda(3199.99);
				
		Produto p2 = new Produto();
		p2.setCodigo(333);
		p2.setDescricao("Geladeira");
		p2.setEstoque(3);
		p2.setMarca("Brastemp");
		p2.setPrecoCusto(2500.0);
		p2.setPrecoVenda(2999.99);
		
		listaProdutos.add(p2);
		listaProdutos.add(p);
		
		return this.listaProdutos;
	}

}
