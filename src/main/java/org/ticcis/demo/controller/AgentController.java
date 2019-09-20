package org.ticcis.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.ticcis.demo.model.Agent;
import org.ticcis.demo.service.AgentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AgentController {

	@Autowired
	private AgentService agentService;
	
	@PostMapping(value = {"create", "/"})
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createAgent(@RequestBody Agent agent) {
		agentService.create(agent);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Mono<Agent>> findById(@PathVariable("id") Integer id) throws IOException{
		Mono<Agent> agent = agentService.findById(id);
		HttpStatus status = agent != null? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Agent>>(agent, status);
	}
	
	@GetMapping("/name/{name}")
	@ResponseBody
	public Flux<Agent> findByName(@PathVariable("name") String name){
		return agentService.findByName(name);
	}
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Agent> findAll(){
		return agentService.findAll();
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Agent> update(@RequestBody Agent agent){
		return agentService.update(agent);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Integer id) {
		agentService.delete(id);
	}
}
