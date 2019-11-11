package com.example.juice.service;

import com.example.juice.domain.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void delete(int id);
    Book getBookById(int id);
    Book editBook(Book book);
    List<Book> getAll();
}
