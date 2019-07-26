package br.com.crcarvalho.agendamentos.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	@Before
	public void inicio() {
		Agendamento agendamento = new Agendamento(new Usuario(1L, "rafael", "rafael@email.com", "123456"), new Item(1L, "Carro"));
		agendamento.setData(LocalDate.now());
		agendamento.setHoraInicio(LocalTime.of(10, 00));
		agendamento.setHoraFim(LocalTime.of(11, 59));
		
		agendamentoService.save(agendamento);
	}
	
	@Test
	public void buscandoItemJaRegistradoParaOPeriodo() {
		Agendamento agendamento = new Agendamento(new Usuario(1L, "rafael", "rafael@email.com", "123456"), new Item(1L, "Carro"));
		agendamento.setData(LocalDate.now());
		agendamento.setHoraInicio(LocalTime.of(8, 00));
		agendamento.setHoraFim(LocalTime.of(9, 00));
		
		agendamentoService.save(agendamento);
		
		List<Agendamento> itemJaRegistradoParaOPeriodo = agendamentoService.itemJaRegistradoParaOPeriodo(agendamento.getItem().getId(), agendamento.getData(),
				LocalTime.of(7, 00), LocalTime.of(8, 30));
		
		assertThat(itemJaRegistradoParaOPeriodo).isNotNull();
		
	}
	
}
