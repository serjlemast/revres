package com.example.demo.repositories;

import com.example.demo.models.Image;

import java.util.*;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {
    public static Map<Integer, Image> storage = new HashMap<>();

    @Override
    public List<Image> getImages() {
        Collection<Image> values = storage.values();
        return new ArrayList<>(values);
    }

    @Override
    public Image getImageById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void createImageOrUpdate(Integer id, Image image) {
        storage.put(id, image);
    }

    @Override
    public void deleteImageById(Integer id) {
        storage.remove(id);
    }
}
