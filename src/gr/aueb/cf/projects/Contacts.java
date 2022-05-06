package gr.aueb.cf.projects;

import java.util.Scanner;

/**
 * Project 2
 *
 * A catalogue application with 500 entries and 3
 * fields each. The application interacts with the
 * user via a menu. The user can apply the basic
 * CRUD operations on the catalogue.
 *
 * @author I. Karadimas
 */
public class Contacts {

    static String[][] contacts = new String[500][3];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            showMenu();
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact(contacts, scanner);
                    break;
                case "2":
                    searchContact(contacts, scanner);
                    break;
                case "3":
                    updateContact(contacts, scanner);
                    break;
                case "4":
                    deleteContact(contacts, scanner);
                    break;
                case "5":
                    printContacts(contacts);
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5");
                    break;
            }

        } while (!choice.equals("6"));

    }

    /**
     * Inserts a new contact to the catalogue. If the phone
     * number already exists, a message is printed and the
     * contact is not inserted. The phone number must consist
     * of 10 digits.
     *
     * @param arr       the 2d array that represents a catalogue.
     * @param scanner   the scanner utilized from main method.
     */
    public static void addContact(String[][] arr, Scanner scanner) {

        System.out.println("Insert surname.");
        String surname = scanner.nextLine();

        System.out.println("Insert first name.");
        String firstname = scanner.nextLine();

        System.out.println("Insert phone number.");
        String phoneNumber = scanner.nextLine();

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i][0] != null)) {
                if (arr[i][2].equals(phoneNumber)) {
                    System.out.println("Contact already exists.");
                    break;
                } else {
                    continue;
                }
            }

            if ((arr[i][0] == null) && (phoneNumber.matches("\\d{10}"))) {

                arr[i][0] = surname;
                arr[i][1] = firstname;
                arr[i][2] = phoneNumber;

                System.out.println("Contact successfully saved.");
            } else {
                System.out.println("Error: Non valid phone number.");
            }
            break;

        }
        System.out.println();
    }

    /**
     * Prints the catalogue. If the catalogue is empty, a message
     * is printed. Otherwise, it prints up to the row that there
     * are entries.
     *
     * @param arr   the 2d array that represents a catalogue.
     */
    public static void printContacts(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[0][0] == null) {
                System.out.println("Catalogue is empty!");
                break;
            }

            //Prints the ordinal number of the entry.
            if (arr[i][0] != null) {
                System.out.printf("%d\t", i + 1);
            } else {
                break;
            }

            //Prints the contents of each entry.
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][0] != null) {
                    System.out.printf("%s\t", arr[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Searches for a specific contact based on the
     * phone number, and prints this contact.
     *
     * @param arr       the 2d array that represents a catalogue.
     * @param scanner   the scanner utilized from main method.
     */
    public static void searchContact(String[][] arr, Scanner scanner) {

        System.out.println("Insert contact's number.");
        String phoneNumber = scanner.nextLine();

        for (int i = 0; i < arr.length; i++) {

            if (arr[0][0] == null) {
                System.out.println("Catalogue is empty!");
                break;
            }

            if (!arr[i][2].equals(phoneNumber)) {
                continue;
            }

            if ((arr[i][0] != null) && (arr[i][2].equals(phoneNumber))) {
                System.out.printf("Contact found: %s %s %s\n", arr[i][0], arr[i][1], arr[i][2]);
                break;
            } else {
                System.out.println("Contact not found");
            }
        }
        System.out.println();
    }

    /**
     * Deletes a specific contact based on the ordinal number
     * of the contact. Then it copies the contents of the catalogue
     * in a new 2d array. The new 2d array, then, replaces the old one.
     *
     * @param arr       the 2d array that represents a catalogue.
     * @param scanner   the scanner utilized from main method.
     */
    public static void deleteContact(String[][] arr, Scanner scanner) {

        String[][] newCatalogue = new String[arr.length - 1][];

        System.out.println("Enter the ordinal number of the contact you want to delete.");
        int contactNum = Integer.parseInt(scanner.nextLine()) - 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[contactNum][0] != null) {

                //Every contact before the chosen one is copied to the new 2d array.
                System.arraycopy(arr, 0, newCatalogue, 0, contactNum);

                //Every other contact after the chosen one moves one position up and is copied to the new array.
                System.arraycopy(arr, contactNum + 1, newCatalogue, contactNum, arr.length - contactNum - 1);

                System.out.println("Contact successfully deleted.");

                contacts = newCatalogue; //the new array replaces the old one.

            } else {
                System.out.println("Contact not found");
            }
            break;

        }

        System.out.println();
    }

    /**
     * Updates an existing contact.
     *
     * @param arr       the 2d array that represents a catalogue.
     * @param scanner   the scanner utilized from main method.
     */
    public static void updateContact(String[][] arr, Scanner scanner) {

        String surname;
        String firstname;
        String phoneNumber;

        System.out.println("Insert contact's ordinal number that you want to update.");
        int contactNum = Integer.parseInt(scanner.nextLine()) - 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[contactNum][0] != null) {

                System.out.println("Insert new surname.");
                surname = scanner.nextLine();

                System.out.println("Insert new firstname.");
                firstname = scanner.nextLine();

                System.out.println("Insert new phone number.");
                phoneNumber = scanner.nextLine();

                if (phoneNumber.matches("\\d{10}")) {
                    arr[contactNum][0] = surname;
                    arr[contactNum][1] = firstname;
                    arr[contactNum][2] = phoneNumber;

                    System.out.println("Contact successfully updated.");
                } else {
                    System.out.println("Error: Non valid phone number.");
                }
            } else {
                System.out.println("Contact not found.");
            }
            break;
        }

        System.out.println();

    }

    /**
     * Prints the main menu.
     */
    public static void showMenu() {

        System.out.println("1. Insert new contact.");
        System.out.println("2. Search contact.");
        System.out.println("3. Update contact.");
        System.out.println("4. Delete contact");
        System.out.println("5. Print catalogue");
        System.out.println("6. Exit.");
    }


}
