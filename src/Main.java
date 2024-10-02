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