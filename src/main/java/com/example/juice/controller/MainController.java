package com.example.juice.controller;

import com.example.juice.domain.Book;
import com.example.juice.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/books")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @PostMapping("/books")
    void addUser(@RequestBody Book book) {
        bookRepository.save(book);
    }

//    @PostMapping("idFilter")
//    public String idFilter(@RequestParam Integer bookID, Map<String, Object> model){
//        Iterable<Book> books;
//        if (bookID == null){
//            books = bookRepository.findAll(); //чекнули все из репы
//        } else {
//            books = bookRepository.findAllById(Collections.singleton(bookID));
//        }
//
////        Iterable<User> q = Collections.singletonList(new User("da", 1));
//        model.put("books", books);
//        return "main";
//    }
}
