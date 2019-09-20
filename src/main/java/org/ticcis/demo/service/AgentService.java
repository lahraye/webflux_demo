package org.ticcis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticcis.demo.model.Agent;
import org.ticcis.demo.repository.AgentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AgentService implements IAgentService{
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public void create(Agent agent) {
		agentRepository.save(agent).subscribe();		
	}

	@Override
	public Mono<Agent> findById(Integer id) {
		return agentRepository.findById(id);
	}

	@Override
	public Flux<Agent> findByName(String name) {
		return agentRepository.findByName(name);
	}

	@Override
	public Flux<Agent> findAll() {
		return agentRepository.findAll();
	}

	@Override
	public Mono<Agent> update(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return agentRepository.deleteById(id);
	}
	
}
