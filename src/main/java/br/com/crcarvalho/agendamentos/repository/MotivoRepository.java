package br.com.crcarvalho.agendamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crcarvalho.agendamentos.model.Motivo;

public interface MotivoRepository extends JpaRepository<Motivo, Long> {

}
