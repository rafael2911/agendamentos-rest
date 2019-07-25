package br.com.crcarvalho.agendamentos.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.model.Item;
import br.com.crcarvalho.agendamentos.model.Usuario;
import br.com.crcarvalho.agendamentos.service.AgendamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendamentoRepositoryTest {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@Test
	public void buscandoAgendamentosComListaVazia() {
		Page<Agendamento> agendamentos = agendamentoService.findAll(PageRequest.of(0, 10));
		
		assertThat(agendamentos.getTotalElements()).isEqualByComparingTo(0L);
	}
	
	@Test
	public void cadastrandoNovoAgendamento() {
		Agendamento agendamento = new Agendamento(new Usuario(1L, "rafael", "rafael@email.com", "123456"), new Item(1L, "Carro"));
		
		agendamentoService.save(agendamento);
		
		assertThat(agendamento.getId()).isEqualByComparingTo(1L);
	}
	
}
