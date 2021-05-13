package com.example.demo.models;

public class NewModel {
    private Integer id;
    private String text;

    public Integer getId() {
        if (id==null) {
            return -1;
        }
        return id;
    }

    @Override
    public String toString() {
        return "id= "+id+", text= "+ text;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
