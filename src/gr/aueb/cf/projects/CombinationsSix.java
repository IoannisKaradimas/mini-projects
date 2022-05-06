package gr.aueb.cf.projects;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Project 1
 *
 * Reads from a text file and prints all possible combinations
 * of 6 numbers after applying some filters.
 *
 * @author I.Karadimas
 */
public class CombinationsSix {

    public static void main(String[] args) throws IOException {

        File numbersFile = new File(
                "src/gr/aueb/cf/projects/CombinationsSix.txt");


        Scanner scanner = new Scanner(numbersFile);

        int n = 6;
        int[] row = new int[6];

        ArrayList<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        Collections.sort(numbers);

        for (int i = 0; i <= numbers.size() - n; i++) {
            for (int j = i + 1; j <= numbers.size() - n + 1; j++) {
                for (int k = j + 1; k <= numbers.size() - n + 2; k++) {
                    for (int m = k + 1; m <= numbers.size() - n + 3; m++) {
                        for (int o = m + 1; o <= numbers.size() - n + 4; o++) {
                            for (int p = o + 1; p < numbers.size(); p++) {

                                row[0] = numbers.get(i);
                                row[1] = numbers.get(j);
                                row[2] = numbers.get(k);
                                row[3] = numbers.get(m);
                                row[4] = numbers.get(o);
                                row[5] = numbers.get(p);

                                if ((!isEven(row)) &&
                                        (!isOdd(row)) &&
                                        (!isContiguous(row)) &&
                                        (!isSameEnding(row)) &&
                                        (!isSameTen(row))) {
                                    System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n",
                                            numbers.get(i), numbers.get(j),
                                            numbers.get(k), numbers.get(m),
                                            numbers.get(o), numbers.get(p));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isEven(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) count++;
        }

        return (count > 4);
    }

    public static boolean isOdd(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) count++;
        }

        return (count > 4);
    }

    public static boolean isContiguous(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) == 1) count++;
        }

        return (count > 1);
    }

    public static boolean isSameEnding(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) count++;
        }

        return (count > 2);
    }

    public static boolean isSameTen(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] / 10) == (arr[i + 1] / 10)) count++;
        }

        return (count > 4);
    }
}