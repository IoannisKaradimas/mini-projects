package gr.aueb.cf.projects;


import java.util.Scanner;

/**
 * Project 10
 *
 * A theater reservation system. The user can reserve or
 * cancel seats of the theater.
 *
 * @author I. Karadimas
 */
public class TheaterReservation {

    static String[][] seats = new String[12][30];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;

        populateSeats(seats);

        do {
            showMenu();
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    printSeats(seats);
                    break;
                case "2":
                    book(seats, scanner);
                    break;
                case "3":
                    cancel(seats, scanner);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose from 1-4");
            }
        } while (!choice.equals("4"));

    }

    /**
     * Fills the 2d array. Each seat begins with the letter
     * of the row and ends with the number of the column.
     *
     * @param arr   the 2d array that represents the theater seat-map.
     */
    private static void populateSeats(String [][] arr) {

        final char ALPHA = 'A';
        String seatNumber;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                seatNumber = (String.format("%s%02d", (char) (i + ALPHA), j+1));
                arr[i][j] = seatNumber;
            }
        }
    }

    /**
     * Prints the seat-map.
     *
     * @param arr   the 2d array that represents the theater seat-map.
     */
    private static void printSeats(String[][] arr) {

        for (String[] row : arr) {
            for (String col : row) {
                System.out.printf("%s ", col);
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Books a free seat.
     *
     * @param arr       the 2d array that represents the theater seat-map.
     * @param scanner   the scanner utilized from the main method.
     */
    public static void book(String[][] arr, Scanner scanner) {

        String seatToReserve;
        boolean notFound = true;

        System.out.println("Choose a seat to book.");
        seatToReserve = scanner.nextLine();

        if ((seatToReserve != null) && (seatToReserve.matches("[A-L]{1}\\d{2}"))) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {

                    if (arr[i][j].equals(seatToReserve)) {
                        notFound = false;
                        arr[i][j] = "---";  //replaces the seat number if the seat gets reserved.
                        System.out.println("Seat successfully booked!");
                        break;
                    }

                }
            }

            if (notFound) {
                System.out.println("The seat is unavailable.");
            }

        } else {
            System.out.println("Seat does not exist!");
        }

        System.out.println();
    }

    /**
     * Cancels a reserved seat.
     *
     * @param arr       the 2d array that represents the theater seat-map.
     * @param scanner   the scanner utilized from the main method.
     */
    public static void cancel(String[][] arr, Scanner scanner) {

        final char ALPHA = 'A';
        String seatToCancel;
        String row;
        String column;

        System.out.println("Choose the seat you want to cancel.");
        seatToCancel = scanner.nextLine();

        row = seatToCancel.substring(0, 1); //Extracts the letter from the seat.
        column = seatToCancel.substring(1); //Extracts the two-digit number of the seat.

        if (seatToCancel.matches("[A-L]{1}\\d{2}")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {

                    //Checks if the seat given by user is reserved.
                    //Finds the seat in the array utilizing the substrings and replaces it with its original name.
                    if ((arr[i][j].equals("---")) && (i == row.charAt(0) - ALPHA) &&
                            (j + 1 == Integer.parseInt(column))) {
                        arr[i][j] = seatToCancel;
                        System.out.println("The cancellation of your seat was successful.");
                        break;
                    }

                    //Checks if the seat is already free.
                    if (arr[i][j].equals(seatToCancel)) {
                        System.out.println("The seat is not reserved!");
                        break;
                    }

                }
            }
        } else {
            System.out.println("Seat does not exist!");
        }

        System.out.println();
    }

    /**
     * Prints the main menu.
     */
    public static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Book a seat");
        System.out.println("3. Cancel a seat");
        System.out.println("4. Exit");
    }



}
