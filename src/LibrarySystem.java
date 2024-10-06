import java.util.ArrayList;
import java.util.Collections;

public class LibrarySystem {
    private ArrayList<Media> books = new ArrayList<>();

    private static int bookCount = 0;
    public static int getBookCount() {
        return bookCount;
    }    

    public void addBook(Media book) {
        books.add(book);
        System.out.println("Media added: " + book.getTitle());
        bookCount++;
    }

    public void displayAllBooks() {
        for (Media book : books) {
            book.displayDetails();
        }
    }

    public Media linearSearch(String title) {
        for (Media book : books) {
            if (book.search(book.getTitle())) {
                return book;
            }
        }
        return null;
    }

    public Media linearSearch(double price) {
        for (Media book : books) {
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
                if ( Double.compare(books.get(j).getPrice() , books.get(j + 1).getPrice()) > 0) {
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
                String currentTitle = books.get(j).getTitle() != null ? books.get(j).getTitle().toLowerCase() : "";
                String minTitle = books.get(minIndex).getTitle() != null ? books.get(minIndex).getTitle().toLowerCase() : "";
                if (currentTitle.compareTo(minTitle) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(books, i, minIndex);
        }
    }
}
