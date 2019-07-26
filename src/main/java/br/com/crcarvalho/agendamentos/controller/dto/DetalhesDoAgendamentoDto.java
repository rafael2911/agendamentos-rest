package br.com.crcarvalho.agendamentos.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.crcarvalho.agendamentos.model.Agendamento;

public class DetalhesDoAgendamentoDto {
	
	private String item;
	private String grupo;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private String motivo;
	private String observacao;
	private String usuario;
	private LocalDateTime dataRegistro;
	private boolean retirado;
	private boolean devolvido;
	
	public DetalhesDoAgendamentoDto(Agendamento agendamento) {
		this.item = agendamento.getItem().getDescricao();
		this.grupo = agendamento.getItem().getGrupo().getDescricao();
		this.data = agendamento.getData();
		this.horaInicio = agendamento.getHoraInicio();
		this.horaFim = agendamento.getHoraFim();
		this.motivo = agendamento.getMotivo().getDescricao();
		this.observacao = agendamento.getObservacao();
		this.usuario = agendamento.getUsuario().getNome();
		this.dataRegistro = agendamento.getDataRegistro();
		this.retirado = agendamento.isRetirado();
		this.devolvido = agendamento.isDevolvido();
	}

	public String getItem() {
		return item;
	}
	
	public String getGrupo() {
		return grupo;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public boolean isDevolvido() {
		return devolvido;
	}
	
}
