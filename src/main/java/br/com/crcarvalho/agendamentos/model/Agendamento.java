package br.com.crcarvalho.agendamentos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;
	
	private LocalTime horaInicio;
	
	private LocalTime horaFim;
	
	private String observacao;
	
	private LocalDateTime dataRegistro;
	
	@ManyToOne
	private Motivo motivo;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Usuario usuario;
	
	private boolean retirado;
	
	private boolean devolvido;
	
	public Agendamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Agendamento(Usuario usuario, Item item) {
		this.retirado = false;
		this.devolvido = false;
		this.usuario = usuario;
		this.item = item;
		this.dataRegistro = LocalDateTime.now();
	}

	public Agendamento(Item item, LocalDate data, LocalTime horaInicio, LocalTime horaFim,
			Usuario usuario, Motivo motivo, String observacao) {
		this(usuario, item);
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.motivo = motivo;
		this.observacao = observacao;
		
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public Item getItem() {
		return item;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
}
