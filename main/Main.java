package main;

import books.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Скільки книжок ви хочете ввести?\n");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();

        Book[] books = new Book[numberOfBooks];

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("\nВведіть інформацію про книжку #" + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Назва: ");
            String title = scanner.nextLine();

            System.out.print("Автор: ");
            String author = scanner.nextLine();

            System.out.print("Видавництво: ");
            String publisher = scanner.nextLine();

            System.out.print("Рік видання: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Кількість сторінок: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ціна: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            try {
                books[i] = new Book(id, title, author, publisher, year, pages, price);
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
                i--;
            }
        }

        System.out.print("\nВведіть автора, книги якого ви хочете знайти: ");
        String authorToFind = scanner.nextLine();
        System.out.println("\nКниги автора " + authorToFind + ":");
        printBooksByAuthor(books, authorToFind);

        System.out.print("\nВведіть видавництво, книги якого ви хочете знайти: ");
        String publisherToFind = scanner.nextLine();
        System.out.println("\nКниги видавництва " + publisherToFind + ":");
        printBooksByPublisher(books, publisherToFind);

        System.out.print("\nВведіть рік, після якого видані книги ви хочете знайти: ");
        int yearToFind = scanner.nextInt();
        System.out.println("\nКниги, видані після " + yearToFind + ":");
        printBooksAfterYear(books, yearToFind);
    }

    public static void printBooksByAuthor(Book[] books, String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksByPublisher(Book[] books, String publisher) {
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksAfterYear(Book[] books, int year) {
        for (Book book : books) {
            if (book.getPublicationYear() > year) {
                System.out.println(book);
            }
        }
    }
}