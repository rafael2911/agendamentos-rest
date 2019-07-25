package br.com.crcarvalho.agendamentos.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.model.Item;
import br.com.crcarvalho.agendamentos.model.Motivo;
import br.com.crcarvalho.agendamentos.model.Usuario;
import br.com.crcarvalho.agendamentos.repository.ItemRepository;
import br.com.crcarvalho.agendamentos.repository.MotivoRepository;

public class AgendamentoForm {

	private Long idItem;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Long idMotivo;
	private String observacao;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

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

	public Long getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "AgendamentoForm [idItem=" + idItem + ", data=" + data + ", horaInicio=" + horaInicio + ", horaFim="
				+ horaFim + ", idMotivo=" + idMotivo + ", observacao=" + observacao + "]";
	}

	public Agendamento converter(ItemRepository itemRepository, MotivoRepository motivoRepository) {
		Item item = itemRepository.findById(this.idItem).get();
		Motivo motivo = motivoRepository.findById(idMotivo).get();
		Usuario usuario = new Usuario(1L, "Rafael", "rafael@email.com", "123456");
		
		return new Agendamento(item, data, horaInicio, horaFim, usuario, motivo, observacao);
	}

}
