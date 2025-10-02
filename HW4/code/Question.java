package code;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question implements Comparable<Question>{
    public static void main(String[] args) {
        BinaryHeap<Question> heap = new BinaryHeap<>();
        Question[] questions = new Question[9];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                // questions[(i * 3) + j] = new Question(i + 2, j + 2);
                // System.out.println(questions[(i * 3) + j]);
                heap.add(new Question(i + 2, j + 2));
            }
        }
        while (true){
            System.out.println(heap);
            Question current = heap.extract();
            current.ask();
            heap.add(current);
        }
    }
    public String statement;
    public String answer;
    public long duration;
    public long missed;

    public Question(int a, int b) {
        statement = String.format("%d x %d = ?", a, b);
        answer = String.format("%d", a * b);
        duration = 0;
        missed = 5 ;
    }

    public void ask() {
        Scanner scan = new Scanner(System.in);
        long start = System.nanoTime();
        System.out.printf("%s ", statement);
        String given = scan.next().trim();
        duration += System.nanoTime() - start;
        // scan.close();
        missed += given.equals(answer) ? -1 : 1;
    }

    public int compareTo(Question other){
        return Long.compare(this.key(), other.key());
         
    }

    public String toString (){
        return String.format("%d: $s", this.key(), statement);
    }

    private long key() {
        // if (missed + duration == 0){
        //     return 5;
        // }
        return missed + duration / 1000000;
    }
}
