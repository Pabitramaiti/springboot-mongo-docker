package com.javatechie.docker.compose.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.docker.compose.dao.BookRepository;
import com.javatechie.docker.compose.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public Book saveBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
		repository.deleteById(id);
       
        return "Deleted Successfully";
    }
}
