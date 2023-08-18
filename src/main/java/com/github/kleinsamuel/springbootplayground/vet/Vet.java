package com.github.kleinsamuel.springbootplayground.vet;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table
public class Vet {

	@PrimaryKey
	private UUID id;

	private String firstName;
	private String lastName;

	private Set<String> specalties;

	public Vet(UUID id, String firstName, String lastName, Set<String> specalties) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specalties = specalties;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getSpecalties() {
		return specalties;
	}

	public void setSpecalties(Set<String> specalties) {
		this.specalties = specalties;
	}
}
