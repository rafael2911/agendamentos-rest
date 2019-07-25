package br.com.crcarvalho.agendamentos.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.domain.Page;

import br.com.crcarvalho.agendamentos.model.Agendamento;

public class AgendamentoDto {
	
	private Long id;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private String item;
	private String motivo;
	private String usuario;
	
	public AgendamentoDto(Agendamento agendamento) {
		this.id = agendamento.getId();
		this.data = agendamento.getData();
		this.horaInicio = agendamento.getHoraInicio();
		this.horaFim = agendamento.getHoraFim();
		this.item = agendamento.getItem().getDescricao();
		this.motivo = agendamento.getMotivo().getDescricao();
		this.usuario = agendamento.getUsuario().getNome();
	}

	public Long getId() {
		return id;
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

	public String getItem() {
		return item;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public static Page<AgendamentoDto> converter(Page<Agendamento> agendamentos) {
		
		return agendamentos.map(AgendamentoDto::new);
	}
	
}
