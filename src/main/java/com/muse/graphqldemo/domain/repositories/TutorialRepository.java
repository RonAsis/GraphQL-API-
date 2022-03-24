package com.muse.graphqldemo.domain.repositories;

import com.muse.graphqldemo.domain.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
}
