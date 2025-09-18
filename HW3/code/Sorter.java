import java.util.Arrays;

public class Sorter implements GodricsHat{
        public void insertion(int[] array){ 
            // Arrays.sort(array);
            int n = array.length;

            // int i = 1 since the first element 
            for (int i = 1; i < n; i++){
                int elementKey = array[i];    // index of element that is used to insert 
                int currentKey = i - 1;       // compares current elements to the pervious element after substracting the current index by 1

                // shifts any element greater than elementKey on index ahead 
                while (currentKey >= 0 && array[currentKey] > elementKey){
                array[currentKey + 1] = array[currentKey];
                currentKey--;
            }

                // sorts element to the right index
                array[currentKey + 1] = elementKey;
            }
        }

        public void merge(int[] array){
            // Arrays.sort(array);
            // divide and conquer strategy
            /*
             * split up the array as many times as possible
             * then sort/compare every element in each section and group them back together and repeat
             * do until the whole array is sorted
             */

            //base condition
            if(array.length <= 1){
                return;
            }

            int middle = array.length / 2;
            int[] left = new int[middle]; 
            int[] right = new int[array.length - left.length];
            System.arraycopy(array, 0, left, 0, left.length);         // left side
            System.arraycopy(array, left.length, right, 0, right.length);    // right side
            merge(left);
            merge(right);

            int i = 0;
            int j = 0; 
            int k = 0;

            for ( i = 0; i < array.length; i++) {
                if (j >= left.length){
                    System.arraycopy(right, k, array, i, array.length - i);
                    break;
                }
                if (k >= right.length){
                    System.arraycopy(left, j, array, i, array.length - i);
                    break;
                }
                if (left[j] < right[k]){
                    array[i] = left[j];
                    j++; 
                } else {
                    array[i] = right[k];
                    k++; 
                }
            }
        }
        
        public void quick(int[] array, int p, int r){
            /*  
             * put all the elements less than the middle on the left
             * put all the elements greater than the middle on the right
             * aka divide and conquer strategy
             * 
             * p is the start of the array
             * r is the end of the array 
            */

            // recursive function
             if (p < r) { // base case for recursion

                    // Partitions array and gets the index that's being pivoted (reorganizes it)
                    // Part that the elements less than the pivot to the left and the greatest on the right
                    // calls partition method
                    int pivotIndex = partition(array, p, r);

                    // Part that actually recursivly sorts the left and right subarrays 
                    quick(array, p, pivotIndex - 1); // low
                    quick(array, pivotIndex + 1, r); // high
                }
            }

            // method that partitions the indexes into the right position
            // part that recognizes where each index goes 
            private static int partition(int[] array, int p, int r){

                // pivot is the last element 
                int pivot = array[r];
                // traces the boundary elements <= pivot
                int i = p - 1;

                // loops through the array from p to r-1
                // j is the current index that is being compared to 
                for (int j = p; j < r; j++){
                    if (array[j] <= pivot){
                        i++;

                        // part that swtiches the two elements around if the are false
                        int temp = array[i];
                        array[i] = array [j];
                        array[j] = temp;
                    }
                }

                // pivot temp and r
                int temp = array[i + 1];
                array[i + 1] = array[r];
                array[r] = temp;

                // returns the pivot index
                return i + 1;
            }
        
       


        public void quickLoopy(int[] array){
            Arrays.sort(array);
        }

        public void counting(int[] array){
            // copied from HW2 Q4
            int i = 0, j = 0, k = 0, max = Integer . MIN_VALUE; 
            for (i = 0; i < array.length ; i ++)
                max = array [i] > max ? array [i] : max;
            int [] counts = new int [ max + 1];

            for (i = 0; i < array.length ; i ++)
                counts [ array [i ]]++;

            for (i = 0; i < counts.length ; i ++)
                for (j = 0; j < counts [i ]; j ++)
                    array[k ++] = i;
        }
}
