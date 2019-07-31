package br.com.crcarvalho.agendamentos.config.swagger;

import org.springframework.context.annotation.Configuration;

import br.com.crcarvalho.agendamentos.model.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	public Docket agendamentosAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.crcarvalho.agendamentos"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Usuario.class);
	}
	
}
