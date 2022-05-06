package gr.aueb.cf.projects;

import java.util.Arrays;

/**
 * Project 6
 *
 * Finds the continuous sub-array from an array of integers with
 * the highest sum. It utilizes the Kadane's algorithm. This algorithm
 * takes as a fact that at least one element is positive. So in case
 * that all elements are negative, we print just the largest
 * negative integer, as this element is the maximum sum sub-array.
 *
 * @author I. Karadimas
 */
public class MaxSumOfSubArray {

    public static int globalMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        if (areAllNegative(arr)) {
            System.out.println(Arrays.stream(arr).max().getAsInt()); //prints the max integer if all elements are negative
        } else {
            System.out.println(Arrays.toString(maxSubArray(arr)));
        }

    }

    /**
     * Loops through the elements of the array only once.
     * Finds and stores the global maximum. It then finds
     * the elements of the sub-array that have sum equal to
     * the global maximum.
     *
     * @param arr   the given array.
     * @return      the sub-array with the largest sum.
     */
    public static int[] maxSubArray (int[] arr) {
        int localMax = 0;
        int start = 0;
        int end = 0;
        int size = 0;

        for (int i =0; i < arr.length; i++) {
            localMax += arr[i];

            if (globalMax < localMax) {
                globalMax = localMax;
                start = size;
                end = i;
            }

            if (localMax < 0) {
                localMax = 0;
                size = i + 1;
            }

        }
        System.out.println("Maximum sum is " + globalMax);

        return Arrays.copyOfRange(arr, start, end + 1);
    }

    /**
     * Checks if all elements of the array are negative.
     *
     * @param arr   the given array of integers.
     * @return      true if all elements are negative.
     */
    public static boolean areAllNegative(int[] arr) {

        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
