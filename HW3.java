package edu.monmouth.hw3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class HW3 {
    public static void main(String[] args) {
        try {

            PrintStream fileOutput = new PrintStream("HW3.txt");
            System.setOut(fileOutput);
            System.setErr(fileOutput);


            List<String> stringArrayList = new ArrayList<>();
            List<String> stringLinkedList = new LinkedList<>();


            try (BufferedReader reader = new BufferedReader(new FileReader("string.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stringArrayList.add(line);
                    stringLinkedList.add(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading string.txt: " + e.getMessage());
            }

      
            List<Book> bookArrayList = new ArrayList<>();
            List<Book> bookLinkedList = new LinkedList<>();


            try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 4) {
                        String title = parts[0];
                        String bookType = parts[1];
                        int numberOfPages = Integer.parseInt(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        bookArrayList.add(new Book(title, bookType, numberOfPages, price));
                        bookLinkedList.add(new Book(title, bookType, numberOfPages, price));
                    } else {
                        System.err.println("Invalid line in books.txt: " + line);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error reading books.txt: " + e.getMessage());
            }

            System.out.println("ArrayList Methods:");
            System.out.println("isEmpty: " + stringArrayList.isEmpty());
            stringArrayList.remove(0);
            System.out.println("Removed element at index 0");
            System.out.println("Size: " + stringArrayList.size());
            stringArrayList.add("New Element");
            System.out.println("Added 'New Element'");
            Iterator<String> stringIterator = stringArrayList.iterator();
            while (stringIterator.hasNext()) {
                System.out.println(stringIterator.next());
            }
            ListIterator<String> stringListIterator = stringArrayList.listIterator(stringArrayList.size());
            System.out.println("Iterating in reverse order:");
            while (stringListIterator.hasPrevious()) {
                System.out.println(stringListIterator.previous());
            }

            System.out.println("LinkedList Methods:");
            bookLinkedList.add(new Book("Sample Book", "HARDBACK", 200, 39.99));
            ListIterator<Book> bookListIterator = bookLinkedList.listIterator(bookLinkedList.size());
            System.out.println("Iterating in reverse order:");
            while (bookListIterator.hasPrevious()) {
                System.out.println(bookListIterator.previous());
            }
            Iterator<Book> bookIterator = bookLinkedList.iterator();
            while (bookIterator.hasNext()) {
                Book book = bookIterator.next();
                if (book.equals(new Book("The Hobbit", "HARDBACK", 212, 32.50))) {
                    System.out.println("Contains: " + book);
                }
            }
            bookLinkedList.remove(new Book("Data Structures and Algorithms", "SOFTBACK", 426, 79.99));
            System.out.println("Removed a book");
            bookIterator = bookLinkedList.iterator();
            while (bookIterator.hasNext()) {
                Book book = bookIterator.next();
                if (book.equals(new Book("The Hobbit", "HARDBACK", 212, 32.50))) {
                    System.out.println("Contains (after removal): " + book);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error opening HW3.txt: " + e.getMessage());
        }
    }
}
