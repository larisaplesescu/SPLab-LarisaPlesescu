package ro.uvt.books;


public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;

    public Book() {}

    public Book(Long id, String title, String author, String isbn) {
        this.id = id; this.title = title; this.author = author; this.isbn = isbn;
    }

    // getters / setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getTitle(){ return title; }
    public void setTitle(String t){ this.title = t; }
    public String getAuthor(){ return author; }
    public void setAuthor(String a){ this.author = a; }
    public String getIsbn(){ return isbn; }
    public void setIsbn(String i){ this.isbn = i; }
}
