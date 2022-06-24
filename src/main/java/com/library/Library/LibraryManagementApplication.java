package com.library.Library;

import com.library.Library.entity.Author;
import com.library.Library.entity.Book;
import com.library.Library.entity.Category;
import com.library.Library.entity.Publisher;
import com.library.Library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) -> {
			Book book1 = new Book("ABC","Book_name","My first Book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

//			Book book2 = new Book("ABC","Book_name","My second Book");
//			Author author2 = new Author("Test name2", "Test description");
//			Category category2 = new Category("Business books");
//			Publisher publisher2 = new Publisher("Second Publisher");
//			book1.addAuthor(author2);
//			book1.addCategory(category2);
//			book1.addPublisher(publisher2);
//			bookService.createBook(book2);
//
//			Book book3 = new Book("ABC","Book_name","My third Book");
//			Author author3 = new Author("Test name3", "Test description");
//			Category category3 = new Category("Business books");
//			Publisher publisher3 = new Publisher("Third Publisher");
//			book1.addAuthor(author3);
//			book1.addCategory(category3);
//			book1.addPublisher(publisher3);
//			bookService.createBook(book3);

		};
	}

}
