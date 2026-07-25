package com.library.app;

import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.LibraryRepository;
import com.library.service.IssueService;
import com.library.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibraryRepository repository = new LibraryRepository();
        LibraryService libraryService = new LibraryService(repository);
        IssueService issueService = new IssueService(repository);

        while (true) {

            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Members");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Publisher: ");
                    String publisher = scanner.nextLine();

                    Book book = new Book(bookId, title, author, publisher);

                    libraryService.addBook(book);

                    break;

                case 2:

                    System.out.print("Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    Member member = new Member(memberId, name, email, phone);

                    libraryService.registerMember(member);

                    break;

                case 3:

                    System.out.print("Book ID: ");
                    int issueBookId = scanner.nextInt();

                    System.out.print("Member ID: ");
                    int issueMemberId = scanner.nextInt();

                    issueService.issueBook(issueBookId, issueMemberId);

                    break;

                case 4:

                    System.out.print("Book ID: ");
                    int returnBookId = scanner.nextInt();

                    issueService.returnBook(returnBookId);

                    break;

                case 5:

                    libraryService.displayBooks();

                    break;

                case 6:

                    libraryService.displayMembers();

                    break;

                case 7:

                    System.out.println("Thank you for using the Library Management System.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}