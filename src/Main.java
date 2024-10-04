import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        String[] menu = {"\nLibrary Menu:\n",
                "1. Add Book\n",
                "2. Display All Books\n",
                "3. Sort Books By Price\n",
                "4. Sort Books By Title\n",
                "5. Search Book by Title\n",
                "6. Exit\n",
                "\nEnter Your Choice: "};

        Book book1 = new Book("Java Programming", 299.99);
        EBook ebook1 = new EBook("Python Programming", 199.99, 5.0);

        while (true) {
            for (String str : menu)
                System.out.print(str);
            int menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    System.out.println("1. Add Book \n2. Add eBook");
                    System.out.print("\nEnter Your Choice: ");
                    boolean doneBookType = false;
                    do {
                        int bookType = scanner.nextInt();
                        if (bookType < 1 || bookType > 2)
                            System.out.println("Invalid Book Type");
                        else {
                            if (bookType == 1)
                                library.addBook(book1);
                            else
                                library.addBook(ebook1);
                            doneBookType = true;
                        }
                    } while (!doneBookType);
                    break;
                case 2:
                    System.out.println("All books:");
                    library.displayAllBooks();
                    break;
                case 3:
                    System.out.println("\nSorting books by price:");
                    library.bubbleSortByPrice();
                    library.displayAllBooks();
                    break;
                case 4:
                    System.out.println("\nSorting books by title:");
                    library.selectionSortByTitle();
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.println("\nSearching for book with title 'Java':");
                    Book foundBook = library.linearSearch("Java");
                    if (foundBook != null)
                        foundBook.displayDetails();
                    else
                        System.out.println("\nBook not found.");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
        //System.out.println("\nTotal number of books: " + Book.getBookCount());
    }
}