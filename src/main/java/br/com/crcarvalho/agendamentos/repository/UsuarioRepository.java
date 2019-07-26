package br.com.crcarvalho.agendamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crcarvalho.agendamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
