package br.com.crcarvalho.agendamentos.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.crcarvalho.agendamentos.controller.dto.AgendamentoDto;
import br.com.crcarvalho.agendamentos.controller.dto.DetalhesDoAgendamentoDto;
import br.com.crcarvalho.agendamentos.controller.form.AgendamentoForm;
import br.com.crcarvalho.agendamentos.controller.form.AtualizacaoAgendamentoForm;
import br.com.crcarvalho.agendamentos.model.Agendamento;
import br.com.crcarvalho.agendamentos.repository.ItemRepository;
import br.com.crcarvalho.agendamentos.repository.MotivoRepository;
import br.com.crcarvalho.agendamentos.repository.UsuarioRepository;
import br.com.crcarvalho.agendamentos.service.AgendamentoService;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private MotivoRepository motivoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public Page<AgendamentoDto> listar(@PageableDefault(page = 0, size = 10) Pageable paginacao){
		
		Page<Agendamento> agendamentos = agendamentoService.findAll(paginacao);
		
		return AgendamentoDto.converter(agendamentos);
	}
	
	@PostMapping
	public ResponseEntity<AgendamentoDto> cadastrar(@RequestBody @Valid AgendamentoForm form, UriComponentsBuilder uriBuilder){
		Agendamento agendamento = form.converter(itemRepository, motivoRepository, usuarioRepository);
		agendamentoService.save(agendamento);		
		
		URI location = uriBuilder.path("/agendamentos/{id}")
				.buildAndExpand(agendamento.getId())
				.toUri();
		
		return ResponseEntity.created(location)
				.body(new AgendamentoDto(agendamento));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DetalhesDoAgendamentoDto> detalhar(@PathVariable Long id) {
		
		Optional<Agendamento> optional = agendamentoService.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok().body(new DetalhesDoAgendamentoDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<AgendamentoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAgendamentoForm form){
		Optional<Agendamento> optional = agendamentoService.findById(id);
		
		if(optional.isPresent()) {
			Agendamento agendamento = form.atualizar(id, agendamentoService);
			return ResponseEntity.ok().body(new AgendamentoDto(agendamento));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		Optional<Agendamento> optional = agendamentoService.findById(id);
		
		if(optional.isPresent()) {
			agendamentoService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
