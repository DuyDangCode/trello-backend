package com.duydangcode.trello_spring;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrelloSpringApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(TrelloSpringApplication.class, args);
		// System.out.println(context.getBean("encoder"));

	}

}
