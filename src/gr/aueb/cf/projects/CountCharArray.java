package gr.aueb.cf.projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Project 3
 *
 * Reads all characters from a file. Appends them in
 * an array and counts how many each character occurs.
 * Then appends every character to another array
 * and displays the number of its occurrences.
 *
 * The application is case-sensitive.
 *
 * @author I.Karadimas
 */
public class CountCharArray {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int n;
        int bufSize = 8192;
        char[] buf = new char[bufSize];
        int[] origin;
        int[] count;
        int[][] chars = new int[256][2];
        int[][] copiedArray;
        int pivot = -1;

        for (int[] row: chars) {
            Arrays.fill(row, 0);
        }

        BufferedReader bf = new BufferedReader(
                new FileReader("src/gr/aueb/cf/projects/CountCharArray.txt"));


        //reads from file until no other character is found.
        while ((n = bf.read(buf, 0, bufSize)) != -1) {
            sb.append(buf, 0, n);
        }

        //appends all characters to an array as their ordinal numbers.
        origin = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            origin[i] = sb.charAt(i);
        }

        //sorts the array of characters.
        Arrays.sort(origin);

        // counts the occurrences of each character, and appends these occurrences to a new array.
        count = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {

            count[i] = 0;
            for (int j = i; j < origin.length; j++) {

                if (origin[i] == origin[j]) {
                    count[i]++;
                } else {
                    break;
                }
            }
        }

        //finds the size of the 2d array and adds the characters and their occurrences to a 2d array.
        for (int i = 0; i < origin.length; i += count[i]) { //eliminates all duplicates.
            chars[++pivot][0] = origin[i];
            chars[pivot][1] = count[i];
        }

        //copies the 2d array.
        copiedArray = new int[pivot + 1][2];
        for (int i = 0; i <= pivot; i++) {
            copiedArray[i] = Arrays.copyOf(chars[i], 2);
        }

        //prints the final 2d array.
        for (int i = 0; i <= pivot; i++) {
            System.out.println((char) copiedArray[i][0] + ", " + copiedArray[i][1]);
        }
    }
}
