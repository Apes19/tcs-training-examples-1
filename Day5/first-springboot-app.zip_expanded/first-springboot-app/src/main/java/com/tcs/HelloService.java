package com.tcs;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String greetings() {
		return "Welcome to the application";
	}

}
