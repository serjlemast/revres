package com.example.demo.repositories;

import com.example.demo.models.Image;

import java.util.List;

public interface Repository {
    List<Image> getImages();
    Image getImageById(Integer id);
    void createImageOrUpdate(Integer id,Image image);
    void deleteImageById(Integer id);
}
