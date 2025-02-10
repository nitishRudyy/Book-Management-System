package com.api.book.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootapibook.Entities.book;
import com.api.book.dao.bookrepository;

@Component
public class BookServices {

  @Autowired
  private bookrepository bookrepository;

    // private  List<book> list= new ArrayList<>();
    
    // {
    //     list.add(new book("ABC",123, "java complete refrences"));
    //     list.add(new book("MNO",36, "THINK JAVA"));
    //     list.add(new book("PQR",23, "HEAD FIRST TO JAVA"));

    // }
    //get all books
     public List<book> getAllBooks(){
      List<book> list = (List<book>)this.bookrepository.findAll();
        return list;
    }

    //get single book by id 
   public book getbookbyid(int id){

     book book = null;
     try{
      
    // book= list.stream().filter(e->e.getId()==id).findFirst().get(); 
      book = this.bookrepository.findById(id);

     }catch(Exception e)
     {
          e.printStackTrace();
     }
     return book;
   }

   //adding 
   public book addBook(book b)
   {
        //  list.add(b);
        book result=bookrepository.save(b);
          return result;
   }

   //delete book
   public void deletebook(int bid)
   {
       // list = list.stream().filter(book-> book.getId()!= bid).
        //collect(Collectors.toList());  
        bookrepository.deleteById(bid);    
   }

   //update the book
    
   public void updatebook(book book, int bookId) {
    //  list = list.stream().map(b -> {
    //     if (b.getId() == bookId)
    //     {
    //         b.setTitle(book.getTitle());
    //         b.setAuthor(book.getAuthor());
    //     }
    //     return b;
    // }).collect(Collectors.toList());
    book.setId(bookId);
    bookrepository.save(book);
  }

    
  
}