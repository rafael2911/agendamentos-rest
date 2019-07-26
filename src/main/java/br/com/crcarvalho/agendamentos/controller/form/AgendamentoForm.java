package br.com.crcarvalho.agendamentos.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.model.Item;
import br.com.crcarvalho.agendamentos.model.Motivo;
import br.com.crcarvalho.agendamentos.model.Usuario;
import br.com.crcarvalho.agendamentos.repository.ItemRepository;
import br.com.crcarvalho.agendamentos.repository.MotivoRepository;
import br.com.crcarvalho.agendamentos.repository.UsuarioRepository;

public class AgendamentoForm {
	
	@NotNull @Min(1)
	private Long idItem;
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	private LocalTime horaInicio;
	
	@NotNull
	private LocalTime horaFim;
	
	@NotNull @Min(1)
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

	public Agendamento converter(ItemRepository itemRepository, MotivoRepository motivoRepository, UsuarioRepository usuarioRepository) {
		Item item = itemRepository.findById(this.idItem).get();
		Motivo motivo = motivoRepository.findById(idMotivo).get();
		Usuario usuario;
		if(observacao.equals("teste update")) {
			usuario = usuarioRepository.findById(2L).get();
		}else {
			usuario = usuarioRepository.findById(1L).get();
		}
		
		return new Agendamento(item, data, horaInicio, horaFim, usuario, motivo, observacao);
	}

}
