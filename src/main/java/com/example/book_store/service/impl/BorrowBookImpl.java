package com.example.book_store.service.impl;

import com.example.book_store.dto.AuthorRequestDTO;
import com.example.book_store.dto.BookRequestDTO;
import com.example.book_store.dto.MemberRequestDTO;
import com.example.book_store.dto.RequestBorrowBookDto;
import com.example.book_store.model.Author;
import com.example.book_store.model.Book;
import com.example.book_store.model.BorrowedBook;
import com.example.book_store.model.Member;
import com.example.book_store.repository.AuthorRepository;
import com.example.book_store.repository.BookRepository;
import com.example.book_store.repository.BorrowBookRepository;
import com.example.book_store.repository.MemberRepository;
import com.example.book_store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class BorrowBookImpl implements BookService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BorrowBookRepository borrowBookRepository;

//    @Transactional(readOnly = true)
    @Override
    public void view(Member member) {

        Member m=memberRepository.findById(201L).orElse(null);
        System.out.println(m.getName());
        System.out.println(m.getBorrowedBooks().size());
        System.out.println(m.getBorrowedBooks());
    }

    @Override
    public void saveAuthor(AuthorRequestDTO authorRequestDTO) {

        Author author1=new Author();

        author1.setName(authorRequestDTO.getName());
        authorRepository.save(author1);
    }

    @Override
    public void addBook(BookRequestDTO bookRequestDTO) {

        Author author=authorRepository.findById(bookRequestDTO.getId()).orElse(null);
        Book book=new Book();
        book.setAuthor(author);
        book.setTitle(bookRequestDTO.getTitle());
        bookRepository.save(book);
    }

    @Override
    public void addMember(MemberRequestDTO memberRequestDTO) {

        Member member1=new Member();
        member1.setName(memberRequestDTO.getName());
        memberRepository.save(member1);
    }

    @Override
    public void borrowBook(RequestBorrowBookDto requestBorrowBookDto) {

        Member member1=memberRepository.findById(requestBorrowBookDto.getMemberId()).orElse(null);
        Book book1=bookRepository.findById(requestBorrowBookDto.getBookId()).orElse(null);

        BorrowedBook borrowbook=new BorrowedBook();
        borrowbook.setBook(book1);
        borrowbook.setMember(member1);
        borrowbook.setBorrowDate(requestBorrowBookDto.getBorrowDate());
        borrowBookRepository.save(borrowbook);
    }
}
