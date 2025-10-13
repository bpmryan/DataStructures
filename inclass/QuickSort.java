package inclass;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 3, 1, 2, 4, 5, 8, 9, 5, 7 };
        System.out.println(Arrays.toString(array));
        quick(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quick(int[] array, int lo, int hi, String level) {
        if (lo >= hi)
            return;
        // Start of visualization code
        for (int k = lo; k < hi; k++) {
            System.out.println(array[k] + ", ");
        }
        System.out.printf("(%d)]%n", array[hi]);
        // visualization code above
        int j = lo, i = lo - 1;
        do {
            if (array[j] <= array[hi]) {
                int temp = array[++i];
                array[i] = array[j];
                array[j] = temp;
            }
        } while (j++ < hi);
        {

            // // Start of visualization code
            // System.out.println(level + "[");
            // for (int k = lo; k < hi; k++) {
            //     if (k == i) {
            //         System.out.printf("(%d)]%n", array[k]);
            //     } else if (k == hi){
            //         System.out.print(array[k] + "}\n");            
            //     } else {
            //         System.out.println(array[k] + ", ");
            //     }
            //     System.out.println(array[k] + ", ");
            // System.out.printf("(%d)]%n", array[i]);
            // // visualization code above

            quick(array, lo, i - 1, level, "  ");
            quick(array, i + 1, hi, level, "  ");
        }
    }
}