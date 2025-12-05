// 837799
public class Dinh14 {
    /**
     * The following iterative sequence is defined for the set of positive integers:
     * n -> n/2 (n is even)
     * n -> 3n + 1 (n is odd)
     * 
     * Using the rule above and starting with 13, we generate the following sequence:
     * 13-->40-->20-->10-->5-->16-->8-->4-->2-->1.
     * 
     * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
     * 
     * Which starting number, under one million, produces the longest chain?
     * 
     * NOTE: Once the chain starts the terms are allowed to go above one million.
     */
    public static void main(String[] args) {
        /**
         * create a check for evens and odd numbers
         * loop through numbers under one million
         * for each number, create a sequence until it reaches 1
         * have a counter to count the number of terms in the sequence
         * track the number that produces the longest chain
         */

        long longestChainNum = 0; // number that produces the longest chain
        int longestChainLength = 0; // length of the longest chain  

        for (int i = 1; i < 1000000; i++) {
            long currentNum = i; // current number in the sequence
            int currentChainLength = 1; // length of the current chain

            // generate the sequence until it reaches 1
            // checks if number is even or odd and does the appropriate operation
            while (currentNum != 1) {
                if (currentNum % 2 == 0) {
                    currentNum = currentNum / 2; // n is even
                } else {
                    currentNum = 3 * currentNum + 1; // n is odd
                }
                currentChainLength++; // increment the chain length
            }

            // check if the current chain is the longest
            if (currentChainLength > longestChainLength) {
                longestChainLength = currentChainLength;
                longestChainNum = i;
            }
        }
        System.out.println(longestChainNum);

    }
}
