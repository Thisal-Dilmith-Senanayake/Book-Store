package com.example.book_store.repository;

import com.example.book_store.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowedBook,Long> {
}
