package com.example.sp_lab1;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();
    private Section parent; // Book nu are de fapt părinte, dar păstrăm compatibilitatea

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException("Element already belongs to another section/book!");
        }
        element.setParent(null); // Book nu e Section, părintele e null
        elements.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element element) {
        addContent(element);
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
