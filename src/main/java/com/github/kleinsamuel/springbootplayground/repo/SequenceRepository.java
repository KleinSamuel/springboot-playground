package com.github.kleinsamuel.springbootplayground.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequenceRepository extends MongoRepository<Sequence, String> {

}
