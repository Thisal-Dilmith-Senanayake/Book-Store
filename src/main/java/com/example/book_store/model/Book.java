package com.example.book_store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;


    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
}
