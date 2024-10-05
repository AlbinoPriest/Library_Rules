import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Book implements Media {
    private static int bookCount = 1;
    private static Set<Integer> bookIds = new HashSet<>();

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

    public void displayDetails() {
        System.out.printf("Title: %s, Price: %.2f, Book ID: %04d, Added Date: %s\n", title, price, bookId, addedDate.toString());
    }
    @Override
    public boolean search(String query) {
        return title.contains(query);
    }

    @Override
    public int generateBookId() {
        int bookIdCandidate;
        do {
            bookIdCandidate = new Random().nextInt(4000);
        } while (bookIds.contains(bookIdCandidate));
        return bookIdCandidate;
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
