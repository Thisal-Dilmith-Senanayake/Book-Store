package com.example.book_store.service;

import com.example.book_store.dto.AuthorRequestDTO;
import com.example.book_store.dto.BookRequestDTO;
import com.example.book_store.dto.MemberRequestDTO;
import com.example.book_store.model.Author;
import com.example.book_store.model.Book;
import com.example.book_store.model.Member;
import com.example.book_store.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface BookService {


    void saveAuthor(AuthorRequestDTO authorRequestDTO);
    void addBook(BookRequestDTO bookRequestDTO);
    void addMember(MemberRequestDTO memberRequestDTO);
    void view(Member member);
}
