package br.com.crcarvalho.agendamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crcarvalho.agendamentos.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
