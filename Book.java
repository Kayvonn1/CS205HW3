package edu.monmouth.hw3;

import java.util.Objects;

public class Book {
    private String title;
    private String bookType;
    private int numberOfPages;
    private double price;

    public Book(String title, String bookType, int numberOfPages, double price) {
        this.title = title;
        this.bookType = bookType;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages &&
                Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                bookType.equals(book.bookType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, bookType, numberOfPages, price);
    }

}
