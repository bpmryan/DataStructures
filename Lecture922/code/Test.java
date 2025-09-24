package code;

public class Test {
    public static void main(String[] args) {
        // or Structure
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i < 10; i++){
            st.push(i);
        }
        
        for(int i = 9; i >= 0; i--){
            System.out.println(st.pop());
        }
    }
}
