public interface Media {
    void displayDetails();
    boolean search(String query);
    boolean search(double price);
    void generateBookId();
}
