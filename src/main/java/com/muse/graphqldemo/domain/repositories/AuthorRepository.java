package com.muse.graphqldemo.domain.repositories;

import com.muse.graphqldemo.domain.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
