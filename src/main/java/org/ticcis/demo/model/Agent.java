package org.ticcis.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@Document
public class Agent {

	@Id
	int id;
	String name;
	long charges;
}
