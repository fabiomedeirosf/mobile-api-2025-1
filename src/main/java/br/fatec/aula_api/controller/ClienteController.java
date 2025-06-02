package br.fatec.aula_api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aula_api.model.Cliente;

@RestController
public class ClienteController {

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	
	@GetMapping(path = "/clientes")
	public List<Cliente> getClientes(
			@RequestParam(name="nome", required = false) String nome,
			@RequestParam(name="idade", required = false) Integer idade) {
		
		
		if(nome == null && idade == null) {
			return this.listaClientes;
		}
		
		List<Cliente> resultadoBusca = new ArrayList<Cliente>();

		//se nao tem o parametro retorna toda a lista
		if( (nome != null && !nome.isEmpty())) {
			for(Cliente c : this.listaClientes) {
				
				if(c.getNome().toUpperCase().startsWith(nome.toUpperCase())) {
					resultadoBusca.add(c);
				}
			}
		}
		
		if(idade != null) {
			for(Cliente c : this.listaClientes) {
				if(c.getIdade().equals(idade)) {
					resultadoBusca.add(c);
				}
			}
		}
	
		return resultadoBusca;
	}
	
	@PostMapping(path = "/clientes")
	public Cliente postCliente(@RequestBody Cliente cliente) {
		
		Integer codigo = (int) (Math.random() * 1000);
		cliente.setCodigo(codigo);
		
		//adicionar cliente lista
		this.listaClientes.add(cliente);
		return cliente;
	}
	
	@GetMapping(path = "/clientes/{codigo}")
	public Cliente getClientePorCodigo(
			@PathVariable(name = "codigo") Integer codigo) {
		
		for(Cliente c : this.listaClientes) {
			
			if(codigo.equals(c.getCodigo())) {
				return c;
			}
		}
		return null;
	}
	
	
}
