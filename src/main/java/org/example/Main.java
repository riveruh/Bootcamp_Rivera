package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[20];
        books[0] = new Book(1, "9781681370767", "Notes of a Crocodile");
        books[1] = new Book(2, "9781590177259", "Last Words from Montmartre");
        books[2] = new Book(3, "9780393325997", "The Price of Salt");
        books[3] = new Book(4, "9781573229722", "Fingersmith");
        books[4] = new Book(5, "9781573227889", "Tipping the Velvet");
        books[5] = new Book(6, "9780349018539", "The Paying Guests");
        books[6] = new Book(7, "9780679744474", "Written on the Body");
        books[7] = new Book(8, "9780802167323", "Oranges Are Not the Only Fruit");
        books[8] = new Book(9, "9781501161933", "The Seven Husbands of Evelyn Hugo");
        books[9] = new Book(10, "9780062020567", "The Miseducation of Cameron Post");
        books[10] = new Book(11, "9780374400118", "Annie on My Mind");
        books[11] = new Book(12, "9780525555254", "Last Night at the Telegraph Club");
        books[12] = new Book(13, "9781250621818", "She Who Became the Sun");
        books[13] = new Book(14, "9780316538510", "The Jasmine Throne");
        books[14] = new Book(15, "9781534430990", "This Is How You Lose the Time War");
        books[15] = new Book(16, "9781250244499", "One Last Stop");
        books[16] = new Book(17, "9780593336403", "Delilah Green Doesn't Care");
        books[17] = new Book(18, "9781250313188", "Gideon the Ninth");
        books[18] = new Book(19, "9781250229885", "Our Wives Under the Sea");
        books[19] = new Book(20, "9780525563433", "Cantoras");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // menu and choice handling go here :D
            System.out.println("1. Show Available Books As Of Right Now");
            System.out.println("2. Show Current Checked Out Books");
            System.out.println("3. Exit");

            System.out.println("Enter your choice!");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Available Books:");

                for (Book book : books) {
                    if (book.isCheckedOut() == false) {
                        System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle());
                    }
                }

                System.out.println("Enter the ID of the book you'd like to borrow, or X to return to the main menu:");
                String selectedId = scanner.nextLine();

                if (selectedId.equalsIgnoreCase("X")) {
                    continue;
                }

                for (Book book : books) {
                    if (String.valueOf(book.getId()).equals(selectedId)) {
                        System.out.println("You selected: " + book.getTitle());
                        System.out.println("What's your name?");
                        String userName = scanner.nextLine();

                        book.checkOut(userName);
                        System.out.println("You checked out: " + book.getTitle());

                    } // closes the matching-ID if
                } // closes the for loop
            } // closes option 1

            if (choice.equals("3")) {
                System.out.println("Goodbye!");
                return;
            }
        } // closes while
    } // closes main
} // closes Main class