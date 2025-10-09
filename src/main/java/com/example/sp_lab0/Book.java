package src.main.java.com.example.sp_lab0;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Chapter> chapters = new ArrayList<>();
    private TableOfContents toc;

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setTableOfContents(TableOfContents toc) {
        this.toc = toc;
        this.toc.generate(this);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        if (toc != null) {
            toc.print();
        }
        for (Chapter c : chapters) {
            c.print();
        }
    }
}

