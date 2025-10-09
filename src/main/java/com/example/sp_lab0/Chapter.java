package src.main.java.com.example.sp_lab0;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<Chapter> subChapters = new ArrayList<Chapter>();

    public Chapter(String name) {
        this.name = name;
    }

    public Chapter() {

    }

    public String getName() {
        return name;
    }

    public void addSubChapter(Chapter sub) {
        subChapters.add(sub);
    }

    public void print() {
        System.out.println(name);
        for (Chapter sc : subChapters) {
            sc.print();
        }
    }
}
