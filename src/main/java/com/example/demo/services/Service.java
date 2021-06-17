package com.example.demo.services;

import com.example.demo.models.Image;

import java.util.List;

public interface Service {
    List<Image> getImages();
    Image getImageById(Integer id);
    void createImage(Integer id,Image image);
    void deleteImageById(Integer id);
    void updateImage(Image image);
}
