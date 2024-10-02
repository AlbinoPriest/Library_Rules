import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("Java Programming", 299.99);
        EBook ebook1 = new EBook("Python Programming", 199.99, 5.0);

        library.addBook(book1);
        library.addBook(ebook1);

        System.out.println("All books:");
        library.displayAllBooks();

        System.out.println("\nSorting books by price:");
        library.bubbleSortByPrice();
        library.displayAllBooks();

        System.out.println("\nSorting books by title:");
        library.selectionSortByTitle();
        library.displayAllBooks();

        System.out.println("\nSearching for book with title 'Java':");
        Book foundBook = library.linearSearch("Java");
        if (foundBook != null) {
            foundBook.displayDetails();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nTotal number of books: " + Book.getBookCount());
    }
}

interface BookOperations {
    void displayDetails();
}

class Book implements BookOperations {
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

    @Override
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

class EBook extends Book {
    private double fileSize;

    public EBook(String title, double price, double fileSize) {
        super(title, price);
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("File Size: %.2f MB\n", fileSize);
    }
}

