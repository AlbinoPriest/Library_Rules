import java.util.ArrayList;
import java.util.Collections;

public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();

    private static int bookCount = 0;
    public static int getBookCount() {
        return bookCount;
    }    

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
        bookCount++;
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

    public Book linearSearch(double price) {
        for (Book book : books) {
            if (book.search(price)) {
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
