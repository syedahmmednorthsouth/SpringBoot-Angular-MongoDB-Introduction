package com.vinternship.mcmsbackend.controllers;



import com.vinternship.mcmsbackend.models.BookShop;
import com.vinternship.mcmsbackend.repositories.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookShopController {

    @Autowired
    BookShopRepository bookShopRepostiory;

    @PostMapping("/bookshops")
    public ResponseEntity<BookShop> createBookShop(@RequestBody BookShop bookShop) {
        try{
            BookShop _bookShop = bookShopRepostiory.save(new BookShop(
                    bookShop.getId(),
                   bookShop.getTitle(),
                   bookShop.getShop_name(),
                    bookShop.getShop_number(),
                    bookShop.getLocation(),
                    bookShop.getBooks(),
                    bookShop.getContact_no(),
                    bookShop.getEmail()
                    ));

            return new ResponseEntity<>(_bookShop, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/bookshops")
    public ResponseEntity<List<BookShop>> getAllBookShops(){
        try{
            List<BookShop> bookShops = bookShopRepostiory.findAll();
            return new ResponseEntity<>(bookShops, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bookshops/{id}")
    public ResponseEntity<BookShop> getBookShopById(@PathVariable("id") String id){
        Optional<BookShop> bookShopData = bookShopRepostiory.findById(id);

        if(bookShopData.isPresent()){
            return new ResponseEntity<>(bookShopData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/bookshops/title/{title}")
    public ResponseEntity<List<BookShop>> getBookShopByTitle(@PathVariable("title") String title){
        try{
            List<BookShop> bookShops = bookShopRepostiory.findByTitleContaining(title);
            if (bookShops.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookShops, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/bookshops/{id}")
    public ResponseEntity<BookShop> updateBookShop(@PathVariable("id") String id, @RequestBody BookShop bookShop){
        Optional<BookShop> bookShopData = bookShopRepostiory.findById(id);

        if(bookShopData.isPresent()){
            BookShop _bookShop = bookShopData.get();
            _bookShop.setTitle(bookShop.getTitle());
            _bookShop.setShop_name(bookShop.getShop_name());
            _bookShop.setShop_number(bookShop.getShop_number());
            _bookShop.setLocation(bookShop.getLocation());
            _bookShop.setBooks(bookShop.getBooks());
            _bookShop.setContact_no(bookShop.getContact_no());
            _bookShop.setEmail(bookShop.getEmail());

            return new ResponseEntity<>(bookShopRepostiory.save(_bookShop), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bookshops/{id}")
    public ResponseEntity<HttpStatus> deleteBookShopById(@PathVariable("id") String id){
        try{
            bookShopRepostiory.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bookshops")
    public ResponseEntity<HttpStatus> deleteAllBookShops(){
        try{
            bookShopRepostiory.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
