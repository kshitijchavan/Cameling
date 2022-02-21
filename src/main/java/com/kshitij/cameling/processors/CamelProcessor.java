package com.kshitij.cameling.processors;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("camelProcessor")
public class CamelProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		File textFile = exchange.getIn().getBody(File.class);
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
		System.out.println(dateFormat.format(textFile.lastModified()));
		
		exchange.getOut().setBody(textFile);
	}
}
