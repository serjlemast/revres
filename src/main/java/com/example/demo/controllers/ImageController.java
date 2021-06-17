package com.example.demo.controllers;

import com.example.demo.models.Image;
import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private Service service;

    @GetMapping("/images/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable int id) {
        if(id<0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            //todo прочитать рекоменацию...
        }
        Image image = service.getImageById(id);
        if(image == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    @GetMapping("/images")
    public List<Image> getImages() {
        return service.getImages();
    }

    @PostMapping("/images")
    public Image createNewImage(@RequestBody Image image) {
        if (image == null) {
            throw new RuntimeException("image not found in request");
        }
        if (image.getId() < 0) {
            throw new RuntimeException("wrong image id");
        }
        service.createImage(image.getId(), image);
        return image;
    }

    @PutMapping("/images")
    public Image updateImage(@RequestBody Image image) {
        service.updateImage(image);
        return image;
    }

    @DeleteMapping("/images/{id}")
    public int deleteImageById(@PathVariable Integer id) {
        service.deleteImageById(id);
        return id;
    }

}
