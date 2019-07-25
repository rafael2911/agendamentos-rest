package br.com.crcarvalho.agendamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.model.Item;
import br.com.crcarvalho.agendamentos.model.Usuario;
import br.com.crcarvalho.agendamentos.service.AgendamentoService;

@RestController
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping
	public String home() {
		
		Agendamento agendamento = new Agendamento(new Usuario(1L, "rafael", "rafael@email.com", "123456"), new Item(1L, "Carro"));
		
		agendamentoService.save(agendamento);
		
		return "Olá, seja bem vindo ao sistema de agendamentos";
	}
	
}
