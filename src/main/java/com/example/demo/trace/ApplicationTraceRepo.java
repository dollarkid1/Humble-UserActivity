package com.example.demo.trace;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationTraceRepo extends MongoRepository<ApplicationTrace, Long> {
}
