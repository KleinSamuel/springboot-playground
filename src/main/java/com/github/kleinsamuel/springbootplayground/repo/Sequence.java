package com.github.kleinsamuel.springbootplayground.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "sequence")
public class Sequence {

	@Id
	private String id;

	private String sequence;

	public Sequence(String sequence) {
		this.id = UUID.randomUUID().toString();

		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return String.format("Sequence[id=%s, sequence='%s']", id, sequence);
	}
}
