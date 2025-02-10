package com.api.book.dao;
import org.springframework.data.repository.CrudRepository;
import com.api.book.bootapibook.Entities.book;

public interface bookrepository extends CrudRepository<book, Integer> {  
    public book findById(int id);
}
