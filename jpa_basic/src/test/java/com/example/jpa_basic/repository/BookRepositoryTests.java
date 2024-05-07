package com.example.jpa_basic.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_basic.entity.Book;

@SpringBootTest
public class BookRepositoryTests {

	@Autowired
	BookRepository bookRepository;
	
	//@Test
	public void test1() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			Book book = Book.builder()
					.title("Java " + i)
					.author("aaa")
					.publisher("green")
					.price(5000)
					.build();
			bookRepository.save(book);
		});
	}
	
	//@Test
	public void test2() {
		List<Book> list = bookRepository.findByAuthor("bbb");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	//@Test
	public void test3() {
		List<Book> list = bookRepository.findByPriceLessThanEqual(8000);
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	//@Test
	public void test4() {
		List<Book> list = bookRepository.findByPriceLessThan(8000);
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	//@Test
	public void test5() {
		List<Book> list = bookRepository.findByTitleLike("%Java%");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test6() {
		List<Book> list = bookRepository.findByPriceBetween(10000, 20000);
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	
	
}
