package com.api.book.bootapibook.Entities;
 


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class book {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "book_id")
    private int id;
    
    private String title;

    @OneToOne(cascade=CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    public book(Author author, int id, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public book() {
    }

}
