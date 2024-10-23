package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.PublisherDTO;
import com.example.librarymanagementsystem.dto.PublisherSaveDTO;
import com.example.librarymanagementsystem.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {

    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublisher();

    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);

    String deletePublisher(int id);
}
