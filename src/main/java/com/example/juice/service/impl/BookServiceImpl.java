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
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Book book) {
        Book newBook = new Book(book.getName(), book.getId());
        this.delete(book.getId());
        return bookRepository.save(newBook);
    }

    @Override
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
