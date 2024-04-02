package com.yourcompany;

import java.util.Scanner;

public class subclass {

    private static Scanner scanner = new Scanner(System.in);
    private static ClientDAO clientDAO = new ClientDAO();
    private static ServiceDAO serviceDAO = new ServiceDAO();
    private static InvoiceDAO invoiceDAO = new InvoiceDAO();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Services");
            System.out.println("3. Manage Invoices");
            System.out.println("4. View Analytics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageClients();
                    break;
                case 2:
                    manageServices();
                    break;
                case 3:
                    manageInvoices();
                    break;
                case 4:
                    viewAnalytics();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageClients() {
        // Implement client management functionalities
    }

    private static void manageServices() {
        // Implement service management functionalities
    }

    private static void manageInvoices() {
        // Implement invoice management functionalities
    }

    private static void viewAnalytics() {
        // Implement analytics functionalities
    }
}