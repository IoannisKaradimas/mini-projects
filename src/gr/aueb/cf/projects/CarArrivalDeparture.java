package gr.aueb.cf.projects;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project 4
 *
 *  Checks the arrival and departure time of each car and
 *  calculates the maximum number of cars, parked at the same time.
 *
 * @author I. Karadimas
 */
public class CarArrivalDeparture {

    public static int globalMax = 0;

    public static void main(String[] args) {

        int localMax = 0;
        int pivot = -1;

        int[][] cars = new int[6][2];

        int[][] arrivalDep = {{1012, 1136},
                              {1317, 1417},
                              {1015, 1020}};

        //Copies the elements of each array to a new 2d array.
        for (int i = 0; i < arrivalDep.length; i++) {
            for (int j = 0; j < arrivalDep[i].length; j++) {
                cars[++pivot][0] = arrivalDep[i][j];
            }
        }

        //Fills the 2nd position of each array with 0 and 1.
        for (int i = 0; i < cars.length; i++) {
            if (i % 2 == 0) {
                cars[i][1] = 1; //1 = arrival
            } else {
                cars[i][1] = 0; //0 = departure
            }
        }

        //Sorts the new 2d array, based on the elements at the first position of each array.
        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));

        //Counts the maximum number of cars that were present in the parking-lot at the same time.
        for (int i = 0; i < cars.length; i++) {

            localMax += cars[i][1];

            if (globalMax < localMax) {
                globalMax = localMax;
                localMax = 0;
            }

        }

        System.out.println("Maximum number of cars, parked at the same time was: " + globalMax);
    }
}
