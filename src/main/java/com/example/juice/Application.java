package com.example.juice;

import com.example.juice.domain.Book;
import com.example.juice.repos.BookRepository;
import com.example.juice.repos.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository, CarRepository carRepository) {
        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                Book book = new Book(name);
//                bookRepository.save(book);
//            });
            bookRepository.findAll().forEach(System.out::println);
            carRepository.findAll().forEach(System.out::println);
        };
    }
}