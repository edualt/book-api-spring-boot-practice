package com.example.obrestjpa;

import com.example.obrestjpa.entities.Book;
import com.example.obrestjpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ObRestJpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        //CRUD
        //Create book
        Book book = new Book(null, "Homo deus", "Yuval Noah", 450, 29.99, LocalDate.of(2022, 1, 1), true);
        Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 400, 19.99, LocalDate.of(2021, 1, 1), true);

        //Save book
        System.out.println("Books in database: " + repository.findAll().size());

        repository.save(book);
        repository.save(book2);

        //Get all books
        System.out.println("Books in database: " + repository.findAll().size());

        //Delete book
        //repository.deleteById(1L);
        //System.out.println("Books in database: " + repository.findAll().size());

    }

}
