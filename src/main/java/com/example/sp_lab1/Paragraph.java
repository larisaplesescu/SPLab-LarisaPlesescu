package com.example.sp_lab1;

public class Paragraph implements Element {
    private String text;
    private Section parent;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
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
