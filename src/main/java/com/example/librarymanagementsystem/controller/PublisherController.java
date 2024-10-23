package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.dto.PublisherDTO;
import com.example.librarymanagementsystem.dto.PublisherSaveDTO;
import com.example.librarymanagementsystem.dto.PublisherUpdateDTO;
import com.example.librarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO)
    {
        String publisherName = publisherService.addPublisher(publisherSaveDTO);
        return  "Added Successfully";
    }

    @GetMapping(path = "/getAllPublisher")
    public List<PublisherDTO> getAllAuthor()
    {
        List<PublisherDTO> allPublishers = publisherService.getAllPublisher();
        return allPublishers;
    }

    @PutMapping(path = "/update")
    public String updatePublisher(@RequestBody PublisherUpdateDTO publisherUpdateDTO)
    {
        String publisherName = publisherService.updatePublisher(publisherUpdateDTO);
        return  publisherName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deletePublisher(@PathVariable(value = "id")int id)
    {
        String publisherName = publisherService.deletePublisher(id);
        return  "Publisher Deleted Successfully";
    }


}