package com.example.sp_lab1;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements = new ArrayList<>();
    private Section parent;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException("Element already belongs to another section!");
        }
        element.setParent(this);
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
        element.setParent(null);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
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
