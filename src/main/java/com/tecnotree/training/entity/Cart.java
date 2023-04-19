package com.tecnotree.training.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    private int total;

    @Column(name = "payment_status")
    private String paymentStatus;

    public Cart() {}

    public Cart(Book book, User user, int total, String paymentStatus) {
        this.book = book;
        this.user = user;
        this.total = total;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return cart_id;
    }

    public void setId(int id) {
        this.cart_id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
