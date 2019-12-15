package br.com.topicos.consulta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConsultaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// return super.configure(builder);
		return builder.sources(ConsultaApplication.class);
	}

}
