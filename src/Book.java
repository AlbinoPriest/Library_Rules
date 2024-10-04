import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class Book {
    private static int bookCount = 0;
    private static HashSet<Integer> bookIDs = new HashSet<>();
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
        this.bookId = generateBookId();
        this.addedDate = new Date();
        bookCount++;
    }

    private static int generateBookId() {
        int bookIdCandidate = new Random().nextInt(1000);
        if (bookIDs.contains(bookIdCandidate)) {
            generateBookId();
        } else {
            return bookIdCandidate;
        }
    }

    public void displayDetails() {
        System.out.printf("Title: %s, Price: %.2f, Book ID: %d, Added Date: %s\n", title, price, bookId, addedDate.toString());
    }

    public boolean search(String query) {
        return title.contains(query);
    }

    public boolean search(double price) {
        return this.price == price;
    }
}
