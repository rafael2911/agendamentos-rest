package br.com.crcarvalho.agendamentos.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.service.AgendamentoService;

public class AtualizacaoAgendamentoForm {

	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Long motivo;
	private String observacao;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public Long getMotivo() {
		return motivo;
	}

	public void setMotivo(Long motivo) {
		this.motivo = motivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Agendamento atualizar(Long id, AgendamentoService agendamentoService) {
		
		return agendamentoService.atualizar(id, this);
		
	}

}
