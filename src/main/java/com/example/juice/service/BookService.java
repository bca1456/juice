package com.example.juice.service;

import com.example.juice.domain.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    void delete(long id);
    Book getBookById(long id);
    Book editBook(Book book);
    List<Book> getAll();
}
