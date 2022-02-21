package com.kshitij.cameling.routes;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder extends RouteBuilder {

	@Value("${file.Read.Path}")
	String readPath;

	@Value("${file.Write.Path}")
	String writePath;

	@Autowired
	@Qualifier("camelProcessor")
	Processor camelProcessor;

	@Override
	public void configure() throws Exception {

		from(readPath).process(camelProcessor).to(writePath);

	}

}
