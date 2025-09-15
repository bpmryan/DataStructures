public class Fibonacci {
    public static void main(String[] args) {
            // user inputs an "n" integer value
            int n = 10;
            if (args.length>0)
                n = Integer.parseInt(args[0]);
            
            // creates an array to store computed fib values
            int[] fib = new int[n];

            // calls recursive method at line 30
            fib(n - 1, fib, "");

            // prints the desired fib numbers 
            for(int i = 0; i < fib.length; i++){
            System.out.println(fib[i]);
            }

        
    
        // int[] fib = new int[n];
        // fib[0] = 0;
        // fib[1] = 1;

    }

    public static int fib ( int i , int[] arr, String level) {
        // level adds spaces between each element

        // prints fib() before computed numbers
        // System.out.println(level + "fib(" + i + ")");
        if (i < 2)
            // base case for fib(0) and fib(1)
            // return 0 or 1 if i < 2
            return arr [i] = i;

            // general case after fib(1)
            return arr [i] = fib (i - 1, arr, level + " " ) + fib (i - 2, arr, level + " " );
    }
}
