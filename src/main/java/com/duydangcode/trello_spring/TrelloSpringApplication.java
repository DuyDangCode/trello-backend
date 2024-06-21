package com.duydangcode.trello_spring;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrelloSpringApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(TrelloSpringApplication.class, args);
		// Arrays.stream(context.getBeanDefinitionNames()).forEach((name) ->
		// System.out.println(name));
	}

}
