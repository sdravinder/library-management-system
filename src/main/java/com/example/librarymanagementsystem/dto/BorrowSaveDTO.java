package com.example.librarymanagementsystem.dto;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowSaveDTO {

    private int book_id;
    private int user_id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
