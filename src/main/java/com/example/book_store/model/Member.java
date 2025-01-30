package com.example.book_store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;


    @OneToMany(mappedBy = "member")
    List<BorrowedBook> borrowedBooks;
}
