package br.com.crcarvalho.agendamentos.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
		
		if(agendamentoDuplicado(agendamento)) {
			throw new DuplicateKeyException("Item " + agendamento.getItem().getDescricao() + " já agendado para este período!");
		}
		
		agendamentoRepository.save(agendamento);
	}
	
	public Optional<Agendamento> itemJaRegistradoParaOPeriodo(Long idItem, LocalDate data, LocalTime horaInicio, LocalTime horaFim){
		return agendamentoRepository.itemJaRegistradoParaOPeriodo(idItem, data, horaInicio, horaFim);
	}
	
	public boolean agendamentoDuplicado(Agendamento agendamento) {
		
		Optional<Agendamento> itemJaRegistradoParaOPeriodo = agendamentoRepository.itemJaRegistradoParaOPeriodo(agendamento.getItem().getId(), agendamento.getData(),
				agendamento.getHoraInicio(), agendamento.getHoraFim());
	
		return itemJaRegistradoParaOPeriodo.isPresent() ? true : false; 
		
	}

	public Optional<Agendamento> findById(Long id) {
		
		return agendamentoRepository.findById(id);
	}

}
