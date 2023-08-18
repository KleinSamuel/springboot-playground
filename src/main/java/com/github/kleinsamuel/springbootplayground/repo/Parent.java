package com.github.kleinsamuel.springbootplayground.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "parent")
public class Parent {

	@Id
	private String id;

	@DBRef
	private Sequence sequence;

	@DBRef
	private List<Child> children;

	public Parent() {
		this.id = UUID.randomUUID().toString();
		this.children = new ArrayList<>();
	}

	public Parent(String sequenceString) {
		this();

		this.sequence = new Sequence(sequenceString);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return String.format("Parent[id=%s, sequence='%s', numChildren=%d]", id, sequence, children.size());
	}
}
