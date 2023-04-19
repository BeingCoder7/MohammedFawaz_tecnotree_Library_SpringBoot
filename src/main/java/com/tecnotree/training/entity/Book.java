package com.tecnotree.training.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "book_id")
private int bookId;

@Column(name = "title")
private String title;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "author_id", nullable = false)
private Author author;

@Column(name = "publisher")
private String publisher;

@Column(name = "price")
private int price;

@Column(name = "ISBN")
private String isbn;

@Column(name = "description")
private String description;

public Book() {}

public Book(String title, Author author, String publisher, int price, String isbn, String description) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.price = price;
    this.isbn = isbn;
    this.description = description;
}

// Getter and Setter methods
public int getBookId() {
    return bookId;
}

public void setBookId(int bookId) {
    this.bookId = bookId;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public Author getAuthor() {
    return author;
}

public void setAuthor(Author author) {
    this.author = author;
}

public String getPublisher() {
    return publisher;
}

public void setPublisher(String publisher) {
    this.publisher = publisher;
}

public int getPrice() {
    return price;
}

public void setPrice(int price) {
    this.price = price;
}

public String getIsbn() {
    return isbn;
}

public void setIsbn(String isbn) {
    this.isbn = isbn;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

}