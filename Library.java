import java.time.LocalDate;
import java.util.ArrayList;

// Abstract parent class
abstract class Item {

    protected String title;
    protected String author;

    public Item(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract void displayInfo();
}


// Interface for items that can be borrowed
interface Borrowable {

    void borrow(String borrower);

    void returnItem();

    boolean isOverdue();
}


// Normal book
class Book extends Item implements Borrowable {

    private boolean borrowed;
    private String borrower;
    private LocalDate dueDate;

    public Book(String title, String author) {
        super(title, author);
        borrowed = false;
    }

    @Override
    public void borrow(String borrower) {

        if (borrowed) {
            System.out.println("Book is already borrowed.");
            return;
        }

        this.borrower = borrower;
        this.borrowed = true;

        // Book is due 14 days after borrowing
        this.dueDate = LocalDate.now().plusDays(14);

        System.out.println(title + " has been borrowed by " + borrower);
        System.out.println("Due date: " + dueDate);
    }

    @Override
    public void returnItem() {

        if (!borrowed) {
            System.out.println("This book is not currently borrowed.");
            return;
        }

        borrowed = false;
        borrower = null;
        dueDate = null;

        System.out.println(title + " has been returned.");
    }

    @Override
    public boolean isOverdue() {

        if (!borrowed) {
            return false;
        }

        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public void displayInfo() {

        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        if (borrowed) {
            System.out.println("Status: Borrowed");
            System.out.println("Borrower: " + borrower);
            System.out.println("Due Date: " + dueDate);
        } else {
            System.out.println("Status: Available");
        }
    }
}


// Reference book
class ReferenceBook extends Item {

    public ReferenceBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {

        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Type: Reference Book");
        System.out.println("Status: For library use only");
    }
}


// Library class
class Library {

    private ArrayList<Item> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayAllItems() {

        for (Item item : items) {
            item.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void listOverdueItems() {

        System.out.println("OVERDUE BOOKS:");

        boolean found = false;

        for (Item item : items) {

            if (item instanceof Book) {

                Book book = (Book) item;

                if (book.isOverdue()) {
                    System.out.println(book.getTitle());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No overdue books.");
        }
    }
}


// Main class
public class LibraryDemo {

    public static void main(String[] args) {

        // Create library
        Library library = new Library();

        // Create normal books
        Book book1 = new Book(
                "Java Programming",
                "James Gosling"
        );

        Book book2 = new Book(
                "Database Systems",
                "Thomas Connolly"
        );

        // Create reference book
        ReferenceBook referenceBook = new ReferenceBook(
                "Encyclopedia of Computing",
                "John Smith"
        );

        // Add books to library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(referenceBook);


        // Display all books
        System.out.println("===== ALL LIBRARY ITEMS =====");

        library.displayAllItems();


        // Borrow a book
        System.out.println("===== BORROWING BOOK =====");

        book1.borrow("Mpho");

        System.out.println();


        // Try borrowing the same book again
        System.out.println("===== TRYING TO BORROW AGAIN =====");

        book1.borrow("Thabo");

        System.out.println();


        // Display book information
        System.out.println("***** BOOK INFORMATION ******");

        book1.displayInfo();

        System.out.println();


        // Return the book
        System.out.println("***** RETURNING BOOK *****");

        book1.returnItem();

        System.out.println();


        // Check overdue books
        System.out.println("************ OVERDUE BOOKS *****");

        library.listOverdueItems();
    }
}
