package br.com.crcarvalho.agendamentos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {
	
	@GetMapping
	public String home() {
		return "Olá, seja bem vindo ao sistema de agendamentos";
	}
	
}
