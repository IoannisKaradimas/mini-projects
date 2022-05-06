package gr.aueb.cf.projects;

import java.util.Arrays;

/**
 * Project 5
 *
 * Finds the starting and the last index of a specific
 * number inside a given array.
 *
 * @author I.Karadimas
 */
public class HighAndLowIndexOfNum {

    public static void main(String[] args) {

        int[] numbers = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};

        System.out.println(Arrays.toString(getLowAndHighIndexOf(numbers, 8)));
    }

    /**
     * Finds the index where the given number is first encountered, and the
     * last index where it is encountered.
     *
     * @param arr       the given array.
     * @param key       the number to find its indexes.
     * @return          a new array with the starting and the last index.
     */
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int low = 0;
        int high = 0;
        int[] indexes = new int[2];

        //Finds the index where the given number is encountered first time.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                low = i;
                break;
            }
        }

        //Starting from the starting index, finds where the given number is encountered one last time.
        for (int i = low; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                high = i + 1;
            }
        }

        indexes[0] = low;
        indexes[1] = high;

        return indexes;

    }
}
