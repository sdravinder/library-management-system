package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.BookDTO;
import com.example.librarymanagementsystem.dto.BookSaveDTO;
import com.example.librarymanagementsystem.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);
    List<BookDTO> getAllBook();
    String updateBook(BookUpdateDTO bookUpdateDTO);
    String deleteBook(int id);
}
