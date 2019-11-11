package com.example.juice.repos;

import com.example.juice.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query("select b from Book b where b.id = :id")
    Book findById(@Param("id") int id);
}
