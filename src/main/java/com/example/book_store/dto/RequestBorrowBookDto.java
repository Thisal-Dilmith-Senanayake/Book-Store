package com.example.book_store.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestBorrowBookDto {

    private Long bookId;
    private LocalDate borrowDate;
    private Long memberId;


}
