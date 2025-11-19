public class Graph {
    public static void main(String[] args) {
        int[][] w = weights("../media/dijkstra1.txt");
        Vertex[] G = new Vertex[w.length];
        dijkstra(G, w, 0);

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                System.out.printf("%3d", w[i][j]);
            }
            System.out.println("something");
        }
    }

    public static void dijkstra(Vertex[] G, int[][] w, int si) {
        initializeSingleSource(G, si);
        Vertex u;
        while ((u = dequeue(G)) != null) {
            for (int j = 0; j < w[j].length; j++)
                relax(u, G[j], w);

        }
        return;
    }

    public static void relax(Vertex u, Vertex v, int[][] w) {
        if(v.d > u.d + w[u.i][v.i]){
            v.d = u.d + w[u.i][v.i];
            v.pi = u.label();
        }
        
        return;
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

    public static void initializeSingleSource(Vertex[] G, int si) {
        for (int i = 0; i < G.length; i++)
            G[i] = new Vertex(i);
        G[si].d = 0;

    }

    public static int[][] weights(String path) {
        String contents = Frequency.read(path);
        String[] rows = contents.split("/n");
        int[][] ret = new int[rows.length][rows[0].split(",").length];
        String[] row = null;
        for (int i = 0; i < ret.length; i++) {
            row = rows[i].split(",");
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = Integer.parseInt(row[j]);
            }
        }
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
}
