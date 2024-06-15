package library;

class Librarian extends Staff {
    public Librarian(String name, String staffId) {
        super(name, staffId);
    }

    @Override
    public void displayStaffInfo() {
        System.out.println("Librarian Name: " + name);
        System.out.println("Librarian ID: " + staffId);
    }

    public void manageBook(Book book) {
        System.out.println(name + " is managing the book: " + book.getTitle());
    }
}
