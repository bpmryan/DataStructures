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
            */

            Arrays.sort(array);


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
