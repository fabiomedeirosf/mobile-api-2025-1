package br.fatec.aula_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aula_api.model.Produto;

/**
 * Criar o endpoint para o cadastro de Cliente
 *  Path: /clientes
 *  Operações: post e get
 *  
 *  Dados do cliente: codigo, nome, idade, cpf, email
 * @author fabio
 */

@RestController
public class ProdutoController {
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	@GetMapping(path = "/produtos")
	public List<Produto> getProdutos() {
		
		return this.listaProdutos;
	}
	
	@GetMapping(path = "/produtos/{codigo}")
	public Produto getProdutoPorId(@PathVariable(name = "codigo") Integer codigo) {
		
//		for(Produto p : this.listaProdutos) {
//			if(p.getCodigo().equals(codigo)) {
//				return p;
//			}
//		}
		
		Produto resultado = this.listaProdutos
				.stream()
				.findFirst()
				.filter(p -> p.getCodigo().equals(codigo))
				.orElse(null);;
		return resultado;
	}
	
	@PostMapping(path = "/produtos")
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		
		//gera o código aleatório para o produto a ser cadastrado
		Integer codigo = (int) (Math.random() * 1000);
		produto.setCodigo(codigo);
		
		this.listaProdutos.add(produto);
		
		return produto;
	}

}
