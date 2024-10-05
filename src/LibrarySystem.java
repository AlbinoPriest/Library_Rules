import java.util.ArrayList;
import java.util.Collections;

public class LibrarySystem {
    private ArrayList<Media> books = new ArrayList<>();

    public void addBook(Media book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void displayAllBooks() {
        for (Media book : books) {
            book.displayDetails();
        }
    }

    public Media linearSearch(String title) {
        for (Media book : books) {
            if (book.search(title)) {
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
                if (books.get(j).getPrice() > books.get(j + 1).getPrice()) {
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
                if (books.get(j).getTitle().compareTo(books.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(books, i, minIndex);
        }
    }
}
