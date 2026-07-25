package com.library.repository;

import com.library.model.Book;
import com.library.model.Member;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    private final List<Book> books;
    private final List<Member> members;

    public LibraryRepository() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}