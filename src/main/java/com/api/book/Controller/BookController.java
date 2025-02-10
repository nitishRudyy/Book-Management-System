package com.api.book.Controller;

 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.Services.BookServices;
import com.api.book.bootapibook.Entities.book;

@RestController
public class BookController {
    
    @Autowired
    private BookServices bookServices;

    //get all books handler
   @GetMapping("/books")
    public ResponseEntity <List<book>> getbooks(){
        
       List<book> lists= this.bookServices.getAllBooks();
       if(lists.size()<=0)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(lists);
    }

    //get single book handler
    @GetMapping("/books/{id}")
    public ResponseEntity<book> getBook(@PathVariable("id") int id){
       book Book = bookServices.getbookbyid(id);
       if(Book==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        return ResponseEntity.of(Optional.of(Book ));
    }

    //new book handler
    @PostMapping("/books")
    public ResponseEntity<book> addBook( @RequestBody book book){
        book b= null;
        try {
            b=this.bookServices.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.
         INTERNAL_SERVER_ERROR).build();
        }   
    }

    //delete book handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deletebook(@PathVariable("bookId") int bookId)
    {
       try {
        this.bookServices.deletebook(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
       }
    }

     //update book handler
    @PutMapping("/books/{bookId}")
    public ResponseEntity<book> updateBook(@RequestBody book book, @PathVariable("bookId") int bookId) {
        
        try {
              this.bookServices.updatebook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.
            INTERNAL_SERVER_ERROR).build();
        }
     
}
}
