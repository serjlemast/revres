package com.example.demo.controllers;

import com.example.demo.models.NewModel;
import com.example.demo.views.NewView;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExampleContriller {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hellos %s!", name);
    }

    @GetMapping("/imagesh")
    public String getImages(@RequestParam(value = "data") String data, @RequestParam(value = "text") String text) {
        return "Image , data : " + data + ", text: " + text;
    }

    @GetMapping("/sds")
    public String getsds(@RequestParam(value = "sdsc", required = false) String data) {
        return "Image , data : " + data;
    }

    @PostMapping("/imagesh")
    public String createImage() {
        return "image";
    }

    @DeleteMapping("/imagesh")
    public String deleteImage() {
        return "deleted";
    }

    @PostMapping("/test")
    public NewView test(@RequestBody NewModel model) {

        System.out.println("model = " + model);
        NewView v = new NewView();
        if (model.getId() == -1) {
            v.setStatus("error");
        }
        if (model.getId() > 0) {
            v.setStatus("ok!");
        }
        return v;
    }

    @GetMapping(value = {"/api/employees/", "/api/employees/{id}"})
    @ResponseBody
    public String getEmployeesByIdWithRequiredFalse(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    @GetMapping(value = {"/api/employeeswithmap/{id}", "/api/employeeswithmap"})
    @ResponseBody
    public String getDefaultEmployeesByIdWithOptional(@PathVariable Optional<List<String>> id) {
        if (id.isPresent()) {
            return "ID: " + id.get();
        } else {
            return "ID: missing";
        }
    }

    @GetMapping(value = {"/api/foos/{id}", "/api/foos"})
    @ResponseBody
    public String getFoos(@RequestParam Optional<List<String>> id) {
        if (id.isPresent()) {
            return "ID: " + id.get();
        } else {
            return "ID: missing";
        }
    }
}
