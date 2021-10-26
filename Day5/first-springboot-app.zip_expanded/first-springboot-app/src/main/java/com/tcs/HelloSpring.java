package com.tcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("welcome")
public class HelloSpring {
	@Autowired
	HelloService service;
	@GetMapping("/test")
	public String test() {
		return service.greetings();
	}

}
