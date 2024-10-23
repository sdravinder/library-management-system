package com.example.librarymanagementsystem.service.IMPL;

import com.example.librarymanagementsystem.dto.AuthorDTO;
import com.example.librarymanagementsystem.dto.AuthorSaveDTO;
import com.example.librarymanagementsystem.dto.AuthorUpdateDTO;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(authorSaveDTO.getName());
        authorRepository.save(author);
        return "Added Successfully";
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {

        List<Author> getAllAuthors = authorRepository.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : getAllAuthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                author.getAuthorId(),
                author.getName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String upadateAuther(AuthorUpdateDTO authorUpdateDTO) {

        if(authorRepository.existsById(authorUpdateDTO.getAuthorId())) {
            Author author = authorRepository.getById(authorUpdateDTO.getAuthorId());
            author.setName(authorUpdateDTO.getName());
            authorRepository.save(author);
            return author.getName();
        }
        else
            System.out.println("Author Id Not Exists!!!!!!!");
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }
        else
            System.out.println("Id Not Found!!!!!!!");
        return null;
    }

}
