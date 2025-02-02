package com.springrest.springrest;

import com.springrest.springrest.controller.A;
import com.springrest.springrest.controller.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringrestApplication {

	public static void main(String[] args) {
//		A a = new B();
//		B b = new B();
//		System.out.println(a.getB());

//		System.out.println(b.getA());

		SpringApplication.run(SpringrestApplication.class, args);
	}

}
