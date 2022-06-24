package com.library.Library.service;

import com.library.Library.entity.Publisher;
import com.library.Library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findALlPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        return publisher;
    }

    public void deletePublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        publisherRepository.deleteById(publisher.getId());
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

}
