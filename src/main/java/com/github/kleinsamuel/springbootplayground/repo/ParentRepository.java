package com.github.kleinsamuel.springbootplayground.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {

}
