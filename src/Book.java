import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Book {
    private static int bookCount = 0;
    public static int getBookCount() {
        return bookCount;
    }

    protected String title;
    protected double price;
    protected int bookId;
    protected Date addedDate;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.bookId = new Random().nextInt(1000);
        this.addedDate = new Date();
        bookCount++;
    }

    public void displayDetails() {
        SimpleDateFormat simpleAddedDate = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleAddedDate.format(addedDate);

        System.out.printf("Title: %s, Price: %.2f, Book ID: %d, Added Date: %s\n", title, price, bookId, formattedDate);
    }

    public boolean search(String query) {
        return title.contains(query);
    }

    public boolean search(double price) {
        return this.price == price;
    }
}
