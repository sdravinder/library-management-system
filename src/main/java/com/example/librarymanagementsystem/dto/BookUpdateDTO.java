package com.example.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {

    private int bookId;
    private String title;

    private int author_id;
    private int publisher_id;

    public Integer getBookid() {
    }
}
