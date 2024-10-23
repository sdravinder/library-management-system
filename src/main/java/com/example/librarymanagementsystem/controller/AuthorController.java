package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dto.AuthorDTO;
import com.example.librarymanagementsystem.dto.AuthorSaveDTO;
import com.example.librarymanagementsystem.dto.AuthorUpdateDTO;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        String authorName =authorService.addAuthor(authorSaveDTO);
        return authorName;
    }

    @GetMapping(path = "/getAllAuthor")
    public List<AuthorDTO> getAllAuthor() {
        List<AuthorDTO> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }

    @GetMapping(path = "/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        String authorName = authorService.upadateAuther(authorUpdateDTO);
        return authorName;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id)
    {
        String authorname = authorService.deleteAuthor(id);
        return "Author deleted successfully";
    }
}
