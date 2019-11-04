package com.example.juice.controller;

import com.example.juice.domain.Book;
import com.example.juice.repos.BookRepository;
import com.example.juice.service.BookService;
import com.example.juice.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handle(Exception ex,
//                                         HttpServletRequest request, HttpServletResponse response) {
//        if (ex instanceof NullPointerException) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }
//    @GetMapping("/")
//    public String greeting(Map<String, Object> model) {
//        return "greeting";
//    }

    @GetMapping("/books")
    public @ResponseBody List<Book> allBooks() {
        return bookService.getAll();
    }

    @PostMapping("/books")
    public @ResponseBody void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/books/{book_id}")
    public @ResponseBody Book getBookById(@PathVariable("book_id") long book_id, Book book){
        return bookService.getBookById(book_id);
    }

    @DeleteMapping("/book/del-book/{book_id}")
    public void deleteBook(@PathVariable("book_id") long book_id, Book book){
        bookService.delete(book_id);
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
