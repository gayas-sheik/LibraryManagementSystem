package com.library.service;

import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.LibraryRepository;

public class LibraryService {

    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    // Add a new book
    public void addBook(Book book) {
        repository.getBooks().add(book);
        System.out.println("Book added successfully!");
    }

    // Register a new member
    public void registerMember(Member member) {
        repository.getMembers().add(member);
        System.out.println("Member registered successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (repository.getBooks().isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : repository.getBooks()) {
            System.out.println(book);
        }
    }

    // Display all members
    public void displayMembers() {
        if (repository.getMembers().isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member member : repository.getMembers()) {
            System.out.println(member);
        }
    }
}