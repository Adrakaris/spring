package hu.yijun.springtutorial1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController annotation is in itself annotated with @Controller, which is annotated with @Component
// which is the annotation needed to be added to the spring network:
// Inversion of control - use an annotation to tell spring "this class needs to be run" and it does it for us

@RestController
public class HelloController {

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String helloWorld() {
		return "Welcome to the website, hi.";
	}
}
