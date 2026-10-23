package org.example;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
    }
}
