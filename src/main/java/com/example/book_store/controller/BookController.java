package com.example.book_store.controller;

import com.example.book_store.dto.AuthorRequestDTO;
import com.example.book_store.dto.BookRequestDTO;
import com.example.book_store.dto.MemberRequestDTO;
import com.example.book_store.dto.RequestBorrowBookDto;
import com.example.book_store.model.Author;
import com.example.book_store.model.Member;
import com.example.book_store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/author")
    void addAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {

        bookService.saveAuthor(authorRequestDTO);
    }
    @PostMapping("/books")
    void addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        bookService.addBook(bookRequestDTO);
    }
    @PostMapping("/member")
    void addMember(@RequestBody MemberRequestDTO memberRequestDTO) {
        bookService.addMember(memberRequestDTO);
    }

    @GetMapping("/member/{id}")
    void getMember(@PathVariable Long id) {

        bookService.view(new Member());
    }
    @PostMapping(value = "/books/borrow")
    public void borrowBook(@RequestBody RequestBorrowBookDto requestBorrowBookDto) {
        bookService.borrowBook(requestBorrowBookDto);
    }

}
