package com.example.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowUpdateDTO {

    private int id;
    private int bookId;
    private int userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
