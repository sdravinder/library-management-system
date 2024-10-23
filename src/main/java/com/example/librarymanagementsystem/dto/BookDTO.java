package com.example.librarymanagementsystem.dto;

import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int bookId;
    private String title;

    private Author author;
    private Publisher publisher;
}
