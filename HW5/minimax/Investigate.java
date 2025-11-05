public class Investigate {
    public static void main(String[] args) {
        Minimax model = new Minimax(3);
        System.out.println(model.root);

        
        int draws = DFS(model.root, 0);
        int maxWins = DFS(model.root, 1);
        int minWins = DFS(model.root, -1);
        System.out.println("draw: " + draws);
        System.out.println("max: " + maxWins);
        System.out.println("min: " + minWins);
    }

    public static int DFS(Vertex root, int player) {
        if (root.children.size() <= 0)
            return root.utility == player ? 1 : 0;
        int count = 0;
        for (Vertex child : root.children)
            count += DFS(child, player);
        return count;
    }
}
