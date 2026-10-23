package org.example;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";

        }
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }
}



