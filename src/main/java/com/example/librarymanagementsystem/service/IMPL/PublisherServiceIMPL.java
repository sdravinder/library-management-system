package com.example.librarymanagementsystem.service.IMPL;

import com.example.librarymanagementsystem.dto.PublisherDTO;
import com.example.librarymanagementsystem.dto.PublisherSaveDTO;
import com.example.librarymanagementsystem.dto.PublisherUpdateDTO;
import com.example.librarymanagementsystem.entity.Publisher;
import com.example.librarymanagementsystem.repository.PublisherRepository;
import com.example.librarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepo;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );
        publisherRepository.save(publisher);
        return publisher.getName();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();
        for(Publisher publisher : getPublishers)
        {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherId(),
                    publisher.getName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if (publisherRepository.existsById(publisherUpdateDTO.getPublisherId()))
        {
            Publisher publisher  = publisherRepository.getById(publisherUpdateDTO.getPublisherId());
            publisher.setName(publisherUpdateDTO.getName());
            publisherRepository.save(publisher);
            return publisher.getName();
        } else {
            System.out.println("Publisher ID Not Exist!!!!!!!!");
        }
        return null;
    }

    @Override
    public String deletePublisher(int id) {
        if(publisherRepository.existsById(id))
        {
            publisherRepository.deleteById(id);
        }
        else
        {
            System.out.println("ID Not Found");
        }
        return null;
    }
}