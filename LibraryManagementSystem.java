package Library_management_java;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian("1", "Admin");
        library.addMember(librarian);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Edit Book");
            System.out.println("4. Search Catalog");
            System.out.println("5. Register Member");
            System.out.println("6. Cancel Membership");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. List Books");
            System.out.println("10. List Members");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    librarian.addBook(library, new Book(bookId, title, author));
                    break;

                case 2:
                    System.out.print("Enter book ID to remove: ");
                    bookId = scanner.nextLine();
                    Book bookToRemove = library.findBookById(bookId);
                    if (bookToRemove != null) {
                        librarian.removeBook(library, bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID to edit: ");
                    bookId = scanner.nextLine();
                    Book bookToEdit = library.findBookById(bookId);
                    if (bookToEdit != null) {
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        librarian.modifyBook(bookToEdit, newTitle, newAuthor);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    librarian.searchCatalog(library, query);
                    break;

                case 5:
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    librarian.registerMember(library, new Member(memberId, name));
                    break;

                case 6:
                    System.out.print("Enter member ID to cancel membership: ");
                    memberId = scanner.nextLine();
                    Member memberToCancel = library.findMemberById(memberId);
                    if (memberToCancel != null) {
                        librarian.cancelMembership(library, memberToCancel);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter book ID to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter member ID to issue to: ");
                    String issueMemberId = scanner.nextLine();
                    Book bookToIssue = library.findBookById(issueBookId);
                    Member memberToIssue = library.findMemberById(issueMemberId);
                    if (bookToIssue != null && memberToIssue != null) {
                        librarian.issueBook(library, bookToIssue, memberToIssue);
                    } else {
                        System.out.println("Book or Member not found.");
                    }
                    break;

                case 8:
                    System.out.print("Enter book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    System.out.print("Enter member ID returning the book: ");
                    String returnMemberId = scanner.nextLine();
                    Book bookToReturn = library.findBookById(returnBookId);
                    Member memberToReturn = library.findMemberById(returnMemberId);
                    if (bookToReturn != null && memberToReturn != null) {
                        librarian.returnBook(library, bookToReturn, memberToReturn);
                    } else {
                        System.out.println("Book or Member not found.");
                    }
                    break;

                case 9:
                    System.out.println("Listing all books:");
                    library.listBooks();
                    break;

                case 10:
                    System.out.println("Listing all members:");
                    library.listMembers();
                    break;

                case 11:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}