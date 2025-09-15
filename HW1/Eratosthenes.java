public class Eratosthenes {
    public static void main(String[] args) {
        // 1 should already be crossed out by definition
        // cross out the values divisable by 2, then 3, then 5,

        /*
         * create an array
         * method that finds number that can be divided by 2 evenly (%)
         * do the same for the other numbers divisable by 3 and 5
         * 
         */

        double startTime = System.nanoTime(); // time in nanoseconds

        if (args.length < 1) {
            // user prompt to continue program
            System.out.println("Please provide n. ");
            // int n = scan.nextInt();
            return;
        }
        int n = Integer.parseInt(args[0]);
        boolean[] places = new boolean[n];

        // sqrt so that the loop doesn't run through the whole array, but rather the
        // sqrt of n
        for (int i = 2; i < Math.sqrt(places.length); i++) {

            // this one will still run through all of the numbers in the list
            // j += i skips every 2 numbers to run through the program faster
            for (int j = i + i; j < places.length; j += i) {
                if (j % i == 0){
                     places[j] = true;
                }
            }
        }

        for (int i = 2; i < places.length; i++) {
            if (!places[i])
                System.out.printf("%d ", i);
        }
        double duration = System.nanoTime() - startTime; // calculates the time it takes for the program to run in nanoseconds
        duration = duration / Math.pow(10, 9); // converts to actual seconds
        System.out.println("Run time: " + duration + " seconds");
    }
}
