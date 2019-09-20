package org.ticcis.demo.service;

import org.ticcis.demo.model.Agent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAgentService {

	void create(Agent agent);
	Mono<Agent> findById(Integer id);
	Flux<Agent> findByName(String name);
	Flux<Agent> findAll();
	Mono<Agent> update(Agent agent);
	Mono<Void> delete(Integer id);
}
