package br.com.crcarvalho.agendamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crcarvalho.agendamentos.controller.dto.AgendamentoDto;
import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.service.AgendamentoService;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping
	public Page<AgendamentoDto> listar(@PageableDefault(page = 0, size = 10) Pageable paginacao){
		
		Page<Agendamento> agendamentos = agendamentoService.findAll(paginacao);
		
		return AgendamentoDto.converter(agendamentos);
	}
	
}
