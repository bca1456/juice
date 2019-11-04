package com.example.juice.service.impl;

import com.example.juice.domain.Book;
import com.example.juice.repos.BookRepository;
import com.example.juice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        bookRepository.deleteById((int) id);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
