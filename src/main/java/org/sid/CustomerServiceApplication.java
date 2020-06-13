package org.sid;

import org.sid.entity.Customer;
import org.sid.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "Hassene", "Hassen@gmail.com"));
			customerRepository.save(new Customer(null, "Nour", "Nour@gmail.com"));
			customerRepository.save(new Customer(null, "Jalila", "Jalila@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
