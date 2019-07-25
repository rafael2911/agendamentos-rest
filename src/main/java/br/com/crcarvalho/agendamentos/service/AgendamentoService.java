package br.com.crcarvalho.agendamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public Page<Agendamento> findAll(Pageable paginacao){
		
		return agendamentoRepository.findAll(paginacao);
	}

	public void save(Agendamento agendamento) {
		
		agendamentoRepository.save(agendamento);
	}

}
