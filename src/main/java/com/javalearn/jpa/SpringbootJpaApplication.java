package com.javalearn.jpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearn.jpa.model.Book;
import com.javalearn.jpa.model.User;
import com.javalearn.jpa.repository.BookRepository;
import com.javalearn.jpa.repository.UserRepository;

@SpringBootApplication
@RestController
@ComponentScan("com.javalearn.jpa.*")
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
}
