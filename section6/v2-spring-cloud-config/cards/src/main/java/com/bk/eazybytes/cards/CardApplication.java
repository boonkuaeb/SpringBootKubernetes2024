package com.bk.eazybytes.cards;

import com.bk.eazybytes.cards.dto.CardContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@ComponentScans({@ComponentScan("com.bk.eazybytes.Card.Controller")})
//@EnableJpaRepositories("com.bk.eazybytes.Card.Repository")
//@EntityScan("com.bk.eazybytes.Card.Entity")
@EnableConfigurationProperties(value = CardContactInfoDto.class)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Card Microservice REST API Documentation",
				description = "InnocentUdo's Bank Card Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Innocent Udo",
						email = "innocentcharlesudo@gmail.com",
						url = "https://innocentsax.netlify.app/"
				),
				license = @License(
						name = "MIT/Apache 2.0",
						url = "https://innocentsax.netlify.app/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "InnocentUdo's Bank Card Microservice REST API Documentation",
				url = "https://innocentsax.netlify.app/"
		)
)
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
