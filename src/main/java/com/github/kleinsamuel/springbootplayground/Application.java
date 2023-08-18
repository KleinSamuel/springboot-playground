package com.github.kleinsamuel.springbootplayground;

import com.github.kleinsamuel.springbootplayground.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final ParentRepository parentRepository;
	private final ChildRepository childRepository;
	private final SequenceRepository sequenceRepository;

	public Application(ParentRepository parentRepository,
					   ChildRepository childRepository,
					   SequenceRepository sequenceRepository) {
		this.parentRepository = parentRepository;
		this.childRepository = childRepository;
		this.sequenceRepository = sequenceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void insertDocument() {

		System.out.println("inserting document");

		Parent p = new Parent("abc");
		this.sequenceRepository.save(p.getSequence());

		Child c1 = new Child();
		c1.setSequence("c_a");
		this.childRepository.save(c1);

		p.getChildren().add(c1);

		Child c2 = new Child();
		c2.setSequence("c_b");
		this.childRepository.save(c2);

		p.getChildren().add(c2);

		this.parentRepository.save(p);

		System.out.println("inserted document");

		this.parentRepository.findAll().forEach(System.out::println);
	}

	public void findParentBySequence() {

		Parent p = this.parentRepository.findAll().get(0);

		if (p == null) {
			System.out.println("parent not found");
			return;
		}

		System.out.println(p);
		for (Child c : p.getChildren()) {
			System.out.println(c);
		}

	}

	@Override
	public void run(String... args) throws Exception {

//		this.insertDocument();

		this.findParentBySequence();
	}
}
