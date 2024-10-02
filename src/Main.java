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

public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.search(title)) {
                return book;
            }
        }
        return null;
    }

    public void bubbleSortByPrice() {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books.get(j).price > books.get(j + 1).price) {
                    Collections.swap(books, j, j + 1);
                }
            }
        }
    }

    public void selectionSortByTitle() {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (books.get(j).title.compareTo(books.get(minIndex).title) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(books, i, minIndex);
        }
    }
}
