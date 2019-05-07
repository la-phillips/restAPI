package com.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping (path="/hello-world")
	public String helloWorld() {
		return "Hello world" ; 
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello mofo");
	}
	
	
}
