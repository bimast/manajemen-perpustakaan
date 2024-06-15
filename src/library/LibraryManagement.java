package library;

import javax.swing.SwingUtilities;

public class LibraryManagement {
    public static void main(String[] args) {
        // Create sample objects
        Book book1 = new Book("The Great Gatsby", "B001", "F. Scott Fitzgerald", 180);
        Member member1 = new Member("Alice Johnson", "M001");
        Librarian librarian1 = new Librarian("Bob Smith", "L001");

        // Display information
        book1.displayInfo();
        System.out.println();
        librarian1.displayStaffInfo();
        System.out.println();
        librarian1.manageBook(book1);

        // Launch the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryGUI();
            }
        });
    }
}
