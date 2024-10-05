public interface Media {
    void displayDetails();
    boolean search(String query);
    boolean search(double price);
    double getPrice();
    String getTitle();
    void generateBookId();
}
