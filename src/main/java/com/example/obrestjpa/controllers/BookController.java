package com.example.obrestjpa.controllers;

import com.example.obrestjpa.entities.Book;
import com.example.obrestjpa.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //atributes
    private BookRepository bookRepository;

    //constructor

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //Book CRUD

    //Get all books
    @GetMapping("/api/books")
    public List<Book> findAll(){
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }

    //Get book by id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }else{
            return  ResponseEntity.notFound().build();
        }

    }

    //Create book into db
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

    //Update book by id

    //Delete book by id

}
