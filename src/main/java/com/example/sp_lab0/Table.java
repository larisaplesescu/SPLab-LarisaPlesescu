package src.main.java.com.example.sp_lab0;

public class Table {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Table: " + title);
    }
}
