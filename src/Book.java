import java.util.Date;
import java.util.Random;

public class Book implements Media {
    private static int bookCount = 1;
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
        System.out.printf("Title: %s, Price: %.2f, Book ID: %04d, Added Date: %s\n", title, price, bookId, addedDate.toString());
    }
    @Override
    public boolean search(String query) {
        return title.contains(query);
    }

    @Override
    public void generateBookId() {

    }

    @Override
    public boolean search(double price) {
        return this.price == price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
