package br.fatec.aula_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping(path = "/teste")
	public String getHello() {
		
		return "Olá mundo! =)";
	}
}
