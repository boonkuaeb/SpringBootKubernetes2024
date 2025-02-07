package com.bk.eazybytes.loans;

import com.bk.eazybytes.loans.dto.LoansContactInfoDto;
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
//@ComponentScans({@ComponentScan("com.bk.eazybytes.Loan.Controller")})
//@EnableJpaRepositories("com.bk.eazybytes.Loan.Repository")
//@EntityScan("com.bk.eazybytes.Loan.Entity")

@EnableConfigurationProperties(value = LoansContactInfoDto.class)

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loan Microservice REST API Documentation",
				description = "InnocentUdo's Bank Loan Microservice REST API Documentation",
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
				description = "InnocentUdo's Bank Loan Microservice REST API Documentation",
				url = "https://innocentsax.netlify.app/"
		)
)
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
