package com.example.juice.controller;

import com.example.juice.domain.Book;
import com.example.juice.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class MainController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Book> books = bookRepository.findAll();  // получаем список всех книг
        model.put("books", books); //добавляем в модель
        return "main";
    }

    @PostMapping("/main")
    public String addNewBook(@RequestParam String name, Map<String, Object> model){
        Book book = new Book(name);
        System.out.println("/////////////////////////////////////////////////////////////////////");
        bookRepository.save(book); //сохраняем пользователя

        Iterable<Book> books = bookRepository.findAll(); //опять чекнули все из репы
        model.put("books", books); //положили обновленную репу в модель

        return "main";
    }

    @PostMapping("idFilter")
    public String idFilter(@RequestParam Integer bookID, Map<String, Object> model){
        Iterable<Book> books;
        if (bookID == null){
            books = bookRepository.findAll(); //чекнули все из репы
        } else {
            books = bookRepository.findAllById(Collections.singleton(bookID));
        }

//        Iterable<User> q = Collections.singletonList(new User("da", 1));
        model.put("books", books);
        return "main";
    }
}
