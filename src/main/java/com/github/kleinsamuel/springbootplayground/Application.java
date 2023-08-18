package com.github.kleinsamuel.springbootplayground;

import com.github.kleinsamuel.springbootplayground.vet.Vet;
import com.github.kleinsamuel.springbootplayground.vet.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final VetRepository vetRepository;

	public Application(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		vetRepository.deleteAll();

		Vet john = new Vet(UUID.randomUUID(), "John", "Doe", Set.of("Dentist", "Surgeon"));
		Vet jane = new Vet(UUID.randomUUID(), "Jane", "Doe", Set.of("Radiology", "Surgeon"));

		Vet savedJohn = vetRepository.save(john);
		Vet savedJane = vetRepository.save(jane);

		vetRepository.findAll().forEach(v -> System.out.println(v.getFirstName()));

		vetRepository.findById(savedJohn.getId()).ifPresent(v -> System.out.println(v.getFirstName()));

	}
}
