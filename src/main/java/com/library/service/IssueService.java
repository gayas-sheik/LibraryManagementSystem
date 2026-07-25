package com.library.service;

import com.library.enums.BookStatus;
import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.LibraryRepository;

public class IssueService {

    private final LibraryRepository repository;

    public IssueService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void issueBook(int bookId, int memberId) {

        Book selectedBook = null;
        Member selectedMember = null;

        for (Book book : repository.getBooks()) {
            if (book.getBookId() == bookId) {
                selectedBook = book;
                break;
            }
        }

        for (Member member : repository.getMembers()) {
            if (member.getMemberId() == memberId) {
                selectedMember = member;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found.");
            return;
        }

        if (selectedMember == null) {
            System.out.println("Member not found.");
            return;
        }

        if (selectedBook.getStatus() == BookStatus.ISSUED) {
            System.out.println("Book is already issued.");
            return;
        }

        selectedBook.setStatus(BookStatus.ISSUED);

        System.out.println("Book issued successfully to " + selectedMember.getName());
    }

    public void returnBook(int bookId) {

        for (Book book : repository.getBooks()) {

            if (book.getBookId() == bookId) {

                if (book.getStatus() == BookStatus.AVAILABLE) {
                    System.out.println("Book is already available.");
                    return;
                }

                book.setStatus(BookStatus.AVAILABLE);

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
}