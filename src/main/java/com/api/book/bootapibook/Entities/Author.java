package com.api.book.bootapibook.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
 public class Author {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    @Column(name = "first_name")
    private String firstname;

    private String lastname;

    private String language;
    
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private book book;

    public int getId() {
        return authorId;
    }
    public void setId(int id) {
        this.authorId = authorId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public book getBook() {
        return book;
    }

    public void setBook(book book) {
        this.book = book;
    }
}
