package Library_management_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    private List<Book> books;
    private Map<String, Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void removeMember(Member member) {
        members.remove(member.getMemberId());
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }

    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        return members.get(memberId);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listMembers() {
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
}