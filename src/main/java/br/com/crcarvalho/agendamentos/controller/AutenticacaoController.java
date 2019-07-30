package br.com.crcarvalho.agendamentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crcarvalho.agendamentos.config.security.TokenService;
import br.com.crcarvalho.agendamentos.controller.form.LoginForm;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<Void> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			// Autntica o usuario
			Authentication authentication = authManager.authenticate(dadosLogin);
			
			// armazena o token
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			
			// retorna resposta ao cliente
			return ResponseEntity.ok().build();
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	
}
