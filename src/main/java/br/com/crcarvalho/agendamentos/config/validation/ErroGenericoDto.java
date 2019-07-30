package br.com.crcarvalho.agendamentos.config.validation;

public class ErroGenericoDto {

	private String erro;
	private String mensagem;

	public ErroGenericoDto(String erro, String mensagem) {
		this.erro = erro;
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public String getMensagem() {
		return mensagem;
	}

}
