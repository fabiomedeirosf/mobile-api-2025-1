package br.fatec.aula_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.aula_api.model.Cliente;

@RestController
public class ClienteController {

	private List<Cliente> listaClientes = new ArrayList<Cliente>();


	@GetMapping(path = "/clientes")
	private List<Cliente> getClientes() {
		return this.listaClientes;
	}
	
	@PostMapping(path = "/clientes")
	public Cliente postCliente(@RequestBody Cliente cliente) {
		
		Integer codigo = (int) (Math.random() * 1000);
		cliente.setCodigo(codigo);
		
		//adicionar cliente lista
		this.listaClientes.add(cliente);
		return cliente;
	}
	
	
}
