package com.example.librarymanagementsystem.dto;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowDTO {

    private int id;
    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
