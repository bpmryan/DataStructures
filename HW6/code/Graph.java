import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Graph {
    public static void main(String[] args) {
        // int[][] w = weights("../media/dijkstra1.txt");
        // Vertex[] G = new Vertex[w.length];
        // dijkstra(G, w, 0);

        // for (int i = 0; i < w.length; i++) {
        //     for (int j = 0; j < w[i].length; j++) {
        //         System.out.printf("%3d", w[i][j]);
        //     }
        //     System.out.println("something");
        // }

        // run Dijkstra
        runDijkstra("../media/dijkstra1.txt");
        runDijkstra("../media/dijkstra2.txt");

        // run Bellman
        runBellmanFord("../media/bellmanFord1.txt");
        runBellmanFord("../media/bellmanFord2.txt");
    }

    public static void runDijkstra(String path) {
        System.out.println("Dijkstra results:");
        int[][] w = weights(path);
        Vertex[] G = new Vertex[w.length];
        dijkstra(G,w,0);

        for (Vertex v : G) {
            System.out.println(v.label() + ": " + v.d + " via " + v.pi);
        }
    }

    public static void runBellmanFord(String path){
        System.out.println("Bellman Ford results:");
        int[][] w2 = weights(path);
        Vertex[] G2 = new Vertex[w2.length];
        boolean ok = bellmanFord(G2, w2, 0);
        if(!ok) {
            System.out.println("Negative weight detected");
        }
        for (Vertex v : G2) {
            System.out.println(v.label() + ": " + v.d + " via " + v.pi);
        }
    }

    public static void dijkstra(Vertex[] G, int[][] w, int si) {
        initializeSingleSource(G, si);
        Vertex u;
        while ((u = dequeue(G)) != null) {
            for (int v = 0; v < w[u.i].length; v++) {
                // relax if the edge is positive
                if (w[u.i][v] > 0) {
                    relax(u, G[v], w);
                }
            }
        }
    }

    // last thing needed to implement 
    public static void relax(Vertex u, Vertex v, int[][] w) {
        if(v.d > u.d + w[u.i][v.i]){
            v.d = u.d + w[u.i][v.i];
            v.pi = u.label();
        }
    }

    // implemented the same way as dijkstra 
    public static boolean bellmanFord(Vertex[] G, int[][] w, int si) {
        initializeSingleSource(G, si);
        int V = G.length;

        // Relaxes edges 
        for (int k = 0; k < V - 1; k++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (w[u][v] != 0) {   // there is an edge u -> v
                        relax(G[u], G[v], w);
                    }
                }
            }
        }

        // Check negative-weights 
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if(w[u][v] != 0 && G[v].d > G[u].d + w[u][v]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] weights(String path) {
        String contents = read(path);

        String[] rows = contents.split("\n");
        int[][] ret = new int[rows.length][rows[0].split(",").length];

        String[] row = null;
        for (int i = 0; i < rows.length; i++) {
            row = rows[i].split(",");
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = Integer.parseInt(row[j]);
            }
        }
        return ret;
    }

    public static void initializeSingleSource(Vertex[] G, int si) {
        for (int i = 0; i < G.length; i++)
            G[i] = new Vertex(i);
        G[si].d = 0;
    }

    public static Vertex dequeue(Vertex[] G) {
        // Java's priority queues are not dynamic
        Vertex ret = null;
        for (Vertex v : G)
            if (v.visited)
                continue;
            else if (ret == null || ret.d > v.d)
                ret = v;
        if (ret != null)
            ret.visited = true;
        return ret;
    }

    static class Vertex implements Comparable<Vertex> {
        public boolean visited = false;
        public int i = -1;
        public double d = Double.POSITIVE_INFINITY; // every other vertex is set to infinity
        public char pi = 0; // last vertex before that makes it the most relaxed

        public Vertex(int i) {
            this.i = i;
            this.pi = this.label();
        }

        public int compareTo(Vertex other) {
            return Double.compare(this.d, other.d);
        }

        public char label() {
            return (char) (this.i + 'a');
        }
    }

    // function to read file instead of calling it from Frequency.java
    public static String read(String path) {
        byte[] ret = null;
        try {
            ret = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(ret);
    }
}
