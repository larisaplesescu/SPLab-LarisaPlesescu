package src.main.java.com.example.sp_lab0;

public class SPLab0Application {


        public static void main(String[] args) {
            Book noapteBuna = new Book("Noapte buna, copii!");
            Author rpGheo = new Author("Radu Pavel Gheo");
            noapteBuna.addAuthor(rpGheo);

            Chapter cap1 = new Chapter("Capitolul 1");
            Chapter cap11 = new Chapter("Capitolul 1.1");
            Chapter cap111 = new Chapter("Capitolul 1.1.1");
            SubChapter cap1111 = new SubChapter("Subchapter 1.1.1.1");

            noapteBuna.addChapter(cap1);
            cap1.addSubChapter(new SubChapter("Intro capitol 1"));
            cap1.addSubChapter(cap11);

            cap11.addSubChapter(cap111);

            SubChapter sc111 = new SubChapter("Text from subchapter 1.1.1");
            sc111.addParagraph(new Paragraph("Paragraf in subcapitol 1.1.1"));
            cap111.addSubChapter(sc111);

            cap1111.addParagraph(new Paragraph("Multumesc celor care ..."));
            cap1111.addImage(new Image("Image subchapter 1.1.1.1"));

            cap111.addSubChapter(cap1111);

            TableOfContents toc = new TableOfContents();
            noapteBuna.setTableOfContents(toc);

            noapteBuna.print();
        }



}
