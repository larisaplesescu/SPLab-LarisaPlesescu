package src.main.java.com.example.sp_lab0;

import java.util.ArrayList;
import java.util.List;

public class SubChapter extends Chapter {
    private String name;
    private List<Object> elements = new ArrayList<>();

    public SubChapter(String name) {
        super();
        this.name = name;
    }

    public void addParagraph(Paragraph p) {
        elements.add(p);
    }

    public void addImage(Image img) {
        elements.add(img);
    }

    public void addTable(Table t) {
        elements.add(t);
    }

    public void print() {
        System.out.println(name);
        for (Object e : elements) {
            if (e instanceof Paragraph) {
                ((Paragraph) e).print();
            } else if (e instanceof Image) {
                ((Image) e).print();
            } else if (e instanceof Table) {
                ((Table) e).print();
            }
        }
    }
}
