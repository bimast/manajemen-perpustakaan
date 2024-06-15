package library;

class Book extends LibraryItem {
    private String author;
    private int numberOfPages;

    public Book(String title, String itemId, String author, int numberOfPages) {
        super(title, itemId);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + numberOfPages);
        System.out.println("ID: " + itemId);
    }
}
