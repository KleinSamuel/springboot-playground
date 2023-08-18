package com.github.kleinsamuel.springbootplayground.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "parent")
public class Parent {

	@Id
	private String id;

	private String sequence;

	public Parent(String sequence) {
		this.id = UUID.randomUUID().toString();

		this.sequence = sequence;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return String.format("Parent[id=%s, sequence='%s']", id, sequence);
	}
}
