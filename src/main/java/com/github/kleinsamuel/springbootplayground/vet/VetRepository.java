package com.github.kleinsamuel.springbootplayground.vet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VetRepository extends CrudRepository<Vet, UUID> {

	Vet findByFirstName(String firstName);

}
