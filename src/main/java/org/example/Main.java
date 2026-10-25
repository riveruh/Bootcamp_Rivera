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

            if (choice.equals("1") == false &&
                    choice.equals("2") == false &&
                    choice.equals("3") == false) {

                System.out.println("Please enter 1, 2, or 3.");
                continue;
            }

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

                boolean found = false;

                for (Book book : books) {
                    if (String.valueOf(book.getId()).equals(selectedId)) {
                        found = true;
                        if (book.isCheckedOut() == true) {
                            System.out.println("That book is already checked out. Sorry");
                            break;
                        }
                        System.out.println("You selected: " + book.getTitle());
                        System.out.println("What's your full name? First and Last.");
                        String userName = scanner.nextLine();

                        book.checkOut(userName);
                        System.out.println("You checked out: " + book.getTitle());

                    } // closes the matching-ID if
                } // closes the for loop
                if (found == false) {
                    System.out.println("No book is found with that ID. Try again");
                }
            } // closes option 1

            if (choice.equals("2")) {
                System.out.println("Checked Out Books:");
                for (Book book : books) {
                    if (book.isCheckedOut() == true) {
                        System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle() + " | " + book.getCheckedOutTo());
                    }
                }

                System.out.println("Enter C to return a book or books. Enter X to return to the main menu!");
                String checkInChoice = scanner.nextLine();
                if (checkInChoice.equalsIgnoreCase("C") == false &&
                        checkInChoice.equalsIgnoreCase("X") == false) {

                    System.out.println("Please enter C or X.");
                    continue;
                }
                if (checkInChoice.equalsIgnoreCase("X")) {
                    continue;
                }
                if (checkInChoice.equalsIgnoreCase("C")) {
                    System.out.println("Enter the ID of the book you want to return.");
                    String returnId = scanner.nextLine();
                    boolean found = false;

                    for (Book book : books) {
                        if (String.valueOf(book.getId()).equals(returnId)) {
                            found = true;
                            if (book.isCheckedOut() == false) {
                                System.out.println("That book isn't checked out. Check the book's spine for the correct ID! ");
                                break;
                            }
                            book.checkIn();
                            System.out.println("You returned: " + book.getTitle());
                        }
                    } // closes the for loop

                    if (found == false) {
                        System.out.println("No book found with that ID. Try again");
                    }
                } // closes C
            } // closes option 2

            if (choice.equals("3")) {
                System.out.println("Goodbye!");
                return;
            }
        } // closes while
    } // closes main
} // closes Main class