package code;
import java.util.Random;
import java.util.Stack;

public class balance {
    public static void main(String[] args) {
       double n = 10000;
       double balanced = 0;

       for(int i = 0; i <= n; i++){
            if (isBalanced(genString())){
                balanced++;

            }
       }
        
       System.out.println(balanced/n);
    }

    public static String genString(){
        
        Random random = new Random();
        String str = "";
        int min = 0;
        int max = 2;

        /*
         * generate and pushing strings to stack via for loop
         * Prints 6 ()'s randomly 
         * If randomNum == 1, then print "(", otherwise print ")"
         */
        for (int i = 0; i < 6; i++){
            int randomNum = random.nextInt(2);
            if(randomNum == 1){
                String generateString = "(";
                str += generateString;
                
            } else {
                String generateString = ")";
                str += generateString; 
                
            }
        }
        return str;
    }

    // check for which () is balanced 
    public static boolean isBalanced(String parath){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parath.length(); i++ ){
            if(!stack.isEmpty() && parath.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            } else {
                stack.push(parath.charAt(i));
            }
        }

        return stack.empty();
    }
}
