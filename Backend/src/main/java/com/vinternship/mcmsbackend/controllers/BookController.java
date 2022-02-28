package com.vinternship.mcmsbackend.controllers;


import com.vinternship.mcmsbackend.models.Book;
import com.vinternship.mcmsbackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {

            List<Book> books = new ArrayList<>();
            bookRepository.findAll().forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String id) {
        Optional <Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/books/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable("title") String title) {
        try {

            List<Book> books = bookRepository.findBookByTitleContaining(title);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book _book = bookRepository.save(new Book (
                    book.getId(),
                    book.getTitle(),
                    book.getPrice(),
                    book.getYear_of_publishing(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getPublisher()

            ));

            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book){
        Optional<Book> bookData = bookRepository.findById(id);

        if(bookData.isPresent()){
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setPrice(book.getPrice());
            _book.setYear_of_publishing(book.getYear_of_publishing());
            _book.setAuthor(book.getAuthor());
            _book.setGenre(book.getGenre());
            _book.setPublisher(book.getPublisher());

            return new ResponseEntity<>(bookRepository.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable("id") String id) {
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteAllBooks() {
        try {
            bookRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

















    }



//    @PostMapping("/books")
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        return ResponseEntity.ok(bookRepository.save(book));
//    }



//    @PutMapping("/books/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book book) {
//        Book bookData = bookRepository.findById(bookId).get();
//        bookData.setName(book.getName());
//        bookData.setDescription(book.getDescription());
//        bookData.setAuthor(book.getAuthor());
//        return ResponseEntity.ok(bookRepository.save(bookData));
//    }
//
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long bookId) {
//        bookRepository.deleteById(bookId);
//        return ResponseEntity.ok().build();
//    }



