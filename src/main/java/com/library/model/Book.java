package com.library.model;

import com.library.enums.BookStatus;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private BookStatus status;

    public Book(int bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status = BookStatus.AVAILABLE;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Publisher: " + publisher +
                ", Status: " + status;
    }
}