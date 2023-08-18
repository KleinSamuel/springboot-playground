package com.github.kleinsamuel.springbootplayground;

import com.github.kleinsamuel.springbootplayground.repo.Parent;
import com.github.kleinsamuel.springbootplayground.repo.ParentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final ParentRepository parentRepository;

	public Application(ParentRepository parentRepository) {
		this.parentRepository = parentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void insertDocument() {

		System.out.println("inserting document");

		Parent p = new Parent("abc");
		this.parentRepository.save(p);

		System.out.println("inserted document");

		this.parentRepository.findAll().forEach(System.out::println);
	}

	@Override
	public void run(String... args) throws Exception {

		this.insertDocument();

	}
}
