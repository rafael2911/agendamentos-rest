package br.com.crcarvalho.agendamentos.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.crcarvalho.agendamentos.controller.form.AtualizacaoAgendamentoForm;
import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.repository.AgendamentoRepository;
import br.com.crcarvalho.agendamentos.repository.MotivoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private MotivoRepository motivoRepository;
	
	public Page<Agendamento> findAll(Pageable paginacao){	
		return agendamentoRepository.findAll(paginacao);
	}

	public void save(Agendamento agendamento) {
		if(agendamentoDuplicado(agendamento)) {
			throw new DuplicateKeyException("Item " + agendamento.getItem().getDescricao() + " já agendado para este período!");
		}
		
		agendamentoRepository.save(agendamento);
	}
	
	public Agendamento atualizar(Long id, AtualizacaoAgendamentoForm form) {
		Agendamento agendamento = agendamentoRepository.getOne(id);
		
		// verifica se o esse item já está cadastrado para o mesmo período
		List<Agendamento> itemJaRegistradoParaOPeriodo = agendamentoRepository.itemJaRegistradoParaOPeriodo(agendamento.getItem().getId(), form.getData(), form.getHoraInicio(), form.getHoraFim());
		
		// identifica se o item cadastrado é o mesmo a ser atualizado
		if(itemJaRegistradoParaOPeriodo.isEmpty() || (itemJaRegistradoParaOPeriodo.size()==1 && itemJaRegistradoParaOPeriodo.get(0).getId() == agendamento.getId())) {
			agendamento.setData(form.getData());
			agendamento.setHoraInicio(form.getHoraInicio());
			agendamento.setHoraFim(form.getHoraFim());
			agendamento.setMotivo(motivoRepository.findById(form.getMotivo()).get());
			agendamento.setObservacao(form.getObservacao());
			
			return agendamento;
		}
		
		// caso não seja o mesmo, lança uma exceção de item já cadastrado por outro usuário
		throw new DuplicateKeyException("Item " + agendamento.getItem().getDescricao() + " com outro agendamento para este período!");
	
	}
	
	public List<Agendamento> itemJaRegistradoParaOPeriodo(Long idItem, LocalDate data, LocalTime horaInicio, LocalTime horaFim){
		return agendamentoRepository.itemJaRegistradoParaOPeriodo(idItem, data, horaInicio, horaFim);
	}
	
	public Optional<Agendamento> findById(Long id) {
		return agendamentoRepository.findById(id);
	}
	
	private boolean agendamentoDuplicado(Agendamento agendamento) {
		List<Agendamento> itemJaRegistradoParaOPeriodo = agendamentoRepository.itemJaRegistradoParaOPeriodo(agendamento.getItem().getId(), agendamento.getData(),
				agendamento.getHoraInicio(), agendamento.getHoraFim());
	
		return itemJaRegistradoParaOPeriodo.isEmpty() ? false : true; 	
	}

}
