package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocOpenApiconfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(
				new Info().title("Rest API - Pedidos!").description("Olá Mundo teste API para realização de Pedidos")
						.license(new License().name("asklkasl").url("dfdfdf"))
						.contact(new Contact().name("Otávio Luiz").email("teste@gmail.com")));
	}

}
