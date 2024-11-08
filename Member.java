package Library_management_java;

import java.util.ArrayList;
import java.util.List;

public class Member {
    protected String memberId;
    protected String name;
    protected List<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
        } else {
            System.out.println("This book was not borrowed by this member.");
        }
    }

    public void searchCatalog(Library library, String query) {
        List<Book> results = library.searchBooks(query);
        System.out.println("Search results:");
        for (Book book : results) {
            System.out.println(book);
        }
    }

    public void reserveBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book is reserved.");
        } else {
            System.out.println("Book is available and cannot be reserved.");
        }
    }

    public void renewBook(Book book) {
        if (borrowedBooks.contains(book)) {
            System.out.println("Book has been renewed.");
        } else {
            System.out.println("This book was not borrowed by this member.");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
