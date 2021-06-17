package com.example.demo.services;

import com.example.demo.models.Image;
import com.example.demo.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private Repository repository;

    @Override
    public List<Image> getImages() {
        return repository.getImages();
    }

    @Override
    public Image getImageById(Integer id) {
        return repository.getImageById(id);
    }

    @Override
    public void createImage(Integer id, Image image) {
        repository.createImageOrUpdate(id, image);
    }

    @Override
    public void deleteImageById(Integer id) {
        repository.deleteImageById(id);
    }

    @Override
    public void updateImage(Image image) {
        Integer id = image.getId();
        Image result = repository.getImageById(id);
        result.setUrl(image.getUrl());
        result.setImage(image.getImage());
        repository.createImageOrUpdate(id, result);
    }
}
