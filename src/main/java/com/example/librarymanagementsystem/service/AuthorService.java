package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.AuthorDTO;
import com.example.librarymanagementsystem.dto.AuthorSaveDTO;
import com.example.librarymanagementsystem.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {

    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthor();

    String upadateAuther(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
