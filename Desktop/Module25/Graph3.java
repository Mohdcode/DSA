import java.util.*;

public class Graph3 {

    public class Graph {
        public static class Edge {
            int source;
            int weight;
            int destination;

            public Edge(int source, int weight, int destination) {
                this.source = source;
                this.weight = weight;
                this.destination = destination;
            }
        }
//kahn's algorithm
        public static List<Integer> topologicalSort(ArrayList<Edge>[] graph) {//BFS
            int n = graph.length;
            int[] inDegree = new int[n];

            // Calculate in-degree of each vertex
            for (ArrayList<Edge> edges : graph) {
                for (Edge e : edges) {
                    inDegree[e.destination]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            // Enqueue vertices with in-degree 0
            for (int u = 0; u < n; u++) {//only put in queue if there is in degree is 0
                if (inDegree[u] == 0) {
                    queue.add(u);
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int u = queue.poll();//poll fun is good exception handling for null pointer
                result.add(u);
                // Decrement in-degree of u's neighbors
                for (Edge e : graph[u]) {
                    inDegree[e.destination]--;
                    // Enqueue vertices with in-degree 0
                    if (inDegree[e.destination] == 0) {
                        queue.add(e.destination);
                    }
                }
            }

            if (result.size() != n) {//topological doesn't run for cyclic graph
                // Graph has a cycle
                return null;
            }

            return result;
        }

        class Pair implements Comparable<Pair> {
            int index;
            int distance;

            public Pair(int index, int distance) {
                this.index = index;
                this.distance = distance;
            }

            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.distance, other.distance);
            }
        }


        public void dijkstra(List<Edge>[] graph, int source) {//BFS
            boolean[] vis =new boolean[graph.length];

            int n = graph.length;
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);//filling all distance s infinity
            dist[source] = 0;

            PriorityQueue<Pair> minHeap = new PriorityQueue<>();//Pair class is just to compare
            minHeap.add(new Pair(source,0));

            while (!minHeap.isEmpty()) {
                Pair curr = minHeap.remove();

                if (!vis[curr.index]){
                    vis[curr.index]=true;

                for (Edge edge : graph[curr.index]) {
                    int u=edge.source;
                    int v = edge.destination;
                    int weight = edge.weight;
                    //comparison part
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        minHeap.add(new Pair(v,dist[v]));
                    }
                }
            }}

            // Print the shortest distances from source to all vertices
            for (int i = 0; i < n; i++) {
                System.out.println("Shortest distance from " + source + " to " + i + " is " + dist[i]);
            }
        }

        public static void main(String[] args) {

        }
    }
}