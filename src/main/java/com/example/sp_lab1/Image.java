package com.example.sp_lab1;

public class Image implements Element {
    private String name;
    private Section parent;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + name);
    }

    @Override
    public Section getParent() {
        return parent;
    }

    @Override
    public void setParent(Section parent) {
        this.parent = parent;
    }
}
