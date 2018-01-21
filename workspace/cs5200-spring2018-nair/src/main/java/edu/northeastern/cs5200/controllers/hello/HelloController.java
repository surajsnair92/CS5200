package edu.northeastern.cs5200.controllers.hello;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.Cs5200Spring2018NairApplication;

@RestController
public class HelloController {
	@RequestMapping("/api/hello/string")
	public String sayHello() {
		System.out.println("Inside sayHello");
		return "Hello Suraj Nair!";
	}

	@RequestMapping("/api/hello/object")
	public HelloObject sayHelloObject() {
		HelloObject obj = new HelloObject("Hello Suraj Nair!");
		return obj;
	}
}