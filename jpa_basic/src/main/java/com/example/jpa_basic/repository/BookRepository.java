package com.example.jpa_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_basic.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByAuthor(String author);
	List<Book> findByPriceLessThanEqual(int price);
	List<Book> findByPriceLessThan(int price);
	List<Book> findByPriceBetween(int from, int to);
	List<Book> findByTitleLike(String str);
}
