package library;

abstract class LibraryItem {
    protected String title;
    protected String itemId;

    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getItemId() {
        return itemId;
    }

    public abstract void displayInfo();
}
