package br.com.crcarvalho.agendamentos.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.crcarvalho.agendamentos.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
	@Query("Select a from Agendamento a where a.item.id = :idItem and a.data = :data "
			+ "and (:horaInicio between a.horaInicio and a.horaFim) or (:horaFim between a.horaInicio and a.horaFim)")
	public List<Agendamento> itemJaRegistradoParaOPeriodo(@Param("idItem") Long idItem,
				@Param("data") LocalDate data, @Param("horaInicio") LocalTime horaInicio, @Param("horaFim") LocalTime horaFim);
	
}
