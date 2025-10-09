package src.main.java.com.example.sp_lab0;

public class TableOfContents {
    private String content = "Table of Contents placeholder";

    public void generate(Book book) {
        StringBuilder sb = new StringBuilder("Table of Contents:\n");
        int index = 1;
        for (Chapter ch : book.getChapters()) {
            sb.append(index++).append(". ").append(ch.getName()).append("\n");
        }
        this.content = sb.toString();
    }

    public void print() {
        System.out.println(content);
    }
}
