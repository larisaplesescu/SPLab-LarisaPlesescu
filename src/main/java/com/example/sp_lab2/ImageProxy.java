package com.example.sp_lab2;

public class ImageProxy implements Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null)
            realImage = new Image(url);
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override public void add(Element e) {}
    @Override public void remove(Element e) {}
    @Override public Element get(int i) { return null; }
}
