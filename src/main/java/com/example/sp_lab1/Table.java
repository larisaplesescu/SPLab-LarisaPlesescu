package com.example.sp_lab1;

public class Table implements Element {
    private String title;
    private Section parent;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
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
