package gr.aueb.cf.projects;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Project 8
 *
 * A tic-tac-toe game where the user plays against the computer.
 * For simplicity's sake, the 9 cells are represented with numbers from 1 to 9.
 *
 * E.g. 1 | 2 | 3
 *      4 | 5 | 6
 *      7 | 8 | 9
 *
 * @author I. Karadimas
 */
public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);

        try (Scanner scanner = new Scanner(System.in)) {

            while (true){

                try {
                    playerTurn(board, scanner);
                    if (isGameOver(board)) break;

                    printBoard(board);

                    computerTurn(board);
                    if (isGameOver(board)) break;

                    printBoard(board);
                } catch (InputMismatchException e1) {
                    System.out.println("Letters are not allowed. Please choose from 1 - 9.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }

    /**
     * Prompts the user to choose the cell to put 'X'.
     * It then checks if the cell is empty. If the cell is not empty,
     * it displays an appropriate message and prompts the user to
     * choose a new cell. If the cell is empty, it puts an 'X' in that
     * cell.
     *
     * @param board     the 2d array that represents the board.
     * @param scanner   the scanner utilized from main method.
     * @throws InputMismatchException   rethrows the exception which is handled in main.
     */
    private static void playerTurn(char[][] board, Scanner scanner) throws InputMismatchException {
        int userMove;

        try {
            while (true) {
                System.out.println("Choose a position to play from 1-9");
                userMove = scanner.nextInt();

                if (!isValidMove(board, userMove)) {
                    break;
                } else {
                    System.out.println(userMove + " is not a valid move!");
                }
            }

            playerMove(board, userMove);

        } catch (InputMismatchException e1) {
            scanner.nextLine();
            throw e1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /**
     * Fills the cell that the user selected.
     *
     * @param board     the 2d array that represents the board.
     * @param userMove  the cell that user selected.
     */
    private static void playerMove(char[][] board, int userMove) {

        switch (userMove) {
            case 1:
                board[0][0] = 'X';
                break;
            case 2:
                board[0][1] = 'X';
                break;
            case 3:
                board[0][2] = 'X';
                break;
            case 4:
                board[1][0] = 'X';
                break;
            case 5:
                board[1][1] = 'X';
                break;
            case 6:
                board[1][2] = 'X';
                break;
            case 7:
                board[2][0] = 'X';
                break;
            case 8:
                board[2][1] = 'X';
                break;
            case 9:
                board[2][2] = 'X';
                break;
            default:
                System.out.println("You can only choose the cells from 1 to 9");
                break;
        }
    }

    /**
     * The program fills a cell with an 'O' randomly.
     * Checks if the cell is empty. If not, it tries again
     * randomly. If it is, fills the cell and displays a message.
     *
     * @param board     the 2d array that represents the board.
     */
    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerPosition = 0;

        while(isValidMove(board, computerPosition)) {
            computerPosition = random.nextInt(9) + 1;
        }
        System.out.println("Computer played: " + computerPosition);
        computerMove(board, computerPosition);
    }

    /**
     * Fills the appropriate cell depending on the result
     * of the random generator from the method computerTurn().
     *
     * @param board     the 2d array that represents the board.
     * @param computerPosition  the random generated cell.
     */
    public static void computerMove(char[][] board, int computerPosition) {

        try {
            switch (computerPosition) {
                case 1:
                    board[0][0] = 'O';
                    break;
                case 2:
                    board[0][1] = 'O';
                    break;
                case 3:
                    board[0][2] = 'O';
                    break;
                case 4:
                    board[1][0] = 'O';
                    break;
                case 5:
                    board[1][1] = 'O';
                    break;
                case 6:
                    board[1][2] = 'O';
                    break;
                case 7:
                    board[2][0] = 'O';
                    break;
                case 8:
                    board[2][1] = 'O';
                    break;
                case 9:
                    board[2][2] = 'O';
                    break;
                default:
                    System.out.println("Something went wrong!");
                    break;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Checks if the selected cell from the user or the computer
     * is empty or not.
     *
     * @param board     the 2d array that represents the board.
     * @param position  the user input or the random generated number of the computer.
     * @return          true if the cell is empty or false if it's already taken.
     */
    public static boolean isValidMove(char[][] board, int position) {

        switch (position) {
            case 1:
                return (board[0][0] != ' ');
            case 2:
                return (board[0][1] != ' ');
            case 3:
                return (board[0][2] != ' ');
            case 4:
                return (board[1][0] != ' ');
            case 5:
                return (board[1][1] != ' ');
            case 6:
                return (board[1][2] != ' ');
            case 7:
                return (board[2][0] != ' ');
            case 8:
                return (board[2][1] != ' ');
            case 9:
                return (board[2][2] != ' ');
            default:
                return true;
        }
    }

    /**
     * Checks if the player or the computer have filled three consecutive cells
     * horizontally, vertically or diagonally and displays a message about the winner.
     * Otherwise, checks if the board is full and displays that the game is a tie.
     *
     * @param board     the 2d array that represents the board.
     * @return          true if the game is over or false if none of the criteria are met.
     */
    public static boolean isGameOver(char[][] board) {

        if (hasPlayerWon(board)) {
            printBoard(board);
            System.out.println("You Win!");
            return true;
        }

        if (hasComputerWon(board)) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }

        for (char[] row : board) {
            for (char column : row) {
                if (column == ' ') return false;
            }
        }

        printBoard(board);
        System.out.println("The game is a tie!");
        return true;
    }

    /**
     * Checks if the user filled three consecutive cells successfully.
     *
     * @param board     the 2d array that represents the board.
     * @return          true if player has won.
     */
    private static boolean hasPlayerWon(char[][] board) {

        return  (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X');
    }

    /**
     * Checks if the computer filled three consecutive cells successfully.
     *
     * @param board     the 2d array that represents the board.
     * @return          true if computer has won.
     */
    private static boolean hasComputerWon(char[][] board) {

        return  (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O');
    }

    /**
     * Prints the board.
     *
     * @param board     the 2d array that represents the board.
     */
    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}
