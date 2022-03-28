package com.muse.graphqldemo.domain.repositories;

import com.muse.graphqldemo.domain.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Optional<Author> findByIdAndAgeAfter(String id, Integer age);
}
