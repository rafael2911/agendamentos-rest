package br.com.crcarvalho.agendamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crcarvalho.agendamentos.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
