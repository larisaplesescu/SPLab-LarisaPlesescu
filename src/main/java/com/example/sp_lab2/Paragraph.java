package com.example.sp_lab2;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy = null;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void print() {
        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(this, System.out);
        }
    }

    @Override
    public void add(Element element) { }

    @Override
    public void remove(Element element) { }

    @Override
    public Element get(int index) { return null; }

    public String getText() {
        return text;
    }
}

