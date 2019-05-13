package com.javalearn.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalearn.jpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
