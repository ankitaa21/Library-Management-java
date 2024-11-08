package Library_management_java;

public class Librarian extends Member {

    public Librarian(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
        System.out.println("Book removed successfully.");
    }

    public void modifyBook(Book book, String title, String author) {
        book.setTitle(title);
        book.setAuthor(author);
        System.out.println("Book modified successfully.");
    }

    public void registerMember(Library library, Member member) {
        library.addMember(member);
        System.out.println("Member registered successfully.");
    }

    public void cancelMembership(Library library, Member member) {
        library.removeMember(member);
        System.out.println("Membership canceled successfully.");
    }

    public void issueBook(Library library, Book book, Member member) {
        member.borrowBook(book);
        System.out.println("Book issued successfully.");
    }

    public void returnBook(Library library, Book book, Member member) {
        member.returnBook(book);
        System.out.println("Book returned successfully.");
    }
}
