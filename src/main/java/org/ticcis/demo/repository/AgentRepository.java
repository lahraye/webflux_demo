package org.ticcis.demo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.ticcis.demo.model.Agent;

import reactor.core.publisher.Flux;

@Repository
public interface AgentRepository extends ReactiveMongoRepository<Agent, Integer>{
	@Query("{'name': ?0 }")
	Flux<Agent> findByName(final String name);
}
