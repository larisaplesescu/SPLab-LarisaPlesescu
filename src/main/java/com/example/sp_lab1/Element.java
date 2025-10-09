package com.example.sp_lab1;

public interface Element {
    void print();

    default void add(Element element) {
        throw new UnsupportedOperationException("Cannot add child to this element");
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove child from this element");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("Leaf element has no children");
    }

    Section getParent();
    void setParent(Section parent);
}
