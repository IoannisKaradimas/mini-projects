package gr.aueb.cf.projects;

/**
 * Project 7
 *
 * Demonstrates the difference between a shallow copy
 * and a deep copy of a 2d array.
 *
 * @author I.Karadimas
 */
public class ShallowDeepCopy {

    public static void main(String[] args) {

        int[][] original = {{1, 2, 3},
                            {4, 5, 6}};


        System.out.println("Result of deep copying a 2d array:");
        deepCopy(original);

        System.out.println();
        System.out.println();

        System.out.println("Result of shallow copying a 2d array:");
        shallowCopy(original);
    }

    /**
     * The method shows that by shallow-copying an array,
     * if we change the first element of the copy, the first
     * element of the original array also changes.
     *
     * @param original   the 2d array we want to copy.
     */
    public static void shallowCopy(int[][] original) {

        int [][] copy;
        copy = original; //Shallow copy.

        copy[0][0] = 60; //Changing the first element of the copy.

        System.out.print("Original: ");
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                System.out.print(original[i][j] + " ");
            }
        }

        System.out.println();

        System.out.print("Copy: ");
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j] + " ");
            }
        }
    }

    /**
     * The method shows that by deep-copying,
     * if we change the first element of the
     * copy, the first element of the original
     * array stays the same.
     *
     * @param original  the 2d array we want to copy.
     */
    public static void deepCopy(int[][] original) {

        int[][] copy = new int[2][];

        //Deep copy.
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }

        copy[0][0] = 43; //Changing the first element of the copy.

        System.out.print("Original: ");
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                System.out.print(original[i][j] + " ");
            }
        }

        System.out.println();

        System.out.print("Copy: ");
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j] + " ");
            }
        }
    }
}
