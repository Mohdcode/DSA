import java.util.*;

public class Graph4 {
    public static int primMST(ArrayList<Graph.Edge>[] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n]; // to store the distance of each vertex from the MST
        boolean[] vis = new boolean[n]; // to mark which vertices have been added to the MST
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Graph.Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
        pq.offer(new Graph.Edge(start, -1, 0)); // add the starting vertex with distance 0

        int totalWeight = 0;
        while (!pq.isEmpty()) {
            Graph.Edge currEdge = pq.remove();
            if (vis[currEdge.des]) continue; // if this vertex is already in the MST, ignore it
            vis[currEdge.des] = true; // mark the vertex as added to the MST
            totalWeight += currEdge.wt; // add the edge weight to the total MST weight
            for (Graph.Edge neighbor : graph[currEdge.des]) {
                if (!vis[neighbor.des] && neighbor.wt < dist[neighbor.des]) {
                    // if the neighbor is not yet in the MST and this edge has a shorter distance than previously recorded
                    dist[neighbor.des] = neighbor.wt; // update the distance to the neighbor
                    pq.add(new Graph.Edge(neighbor.des, currEdge.des, neighbor.wt)); // add the neighbor to the queue
                }
            }
        }
        return totalWeight;
    }

    public static int[] bellmanFord(ArrayList<Graph.Edge>[] graph, int numVertices, int source) {//dijaktra's alternate
        // Use in negative weighted graph

        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Relax edges numVertices - 1 times
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k=0;k<graph[j].size();k++) {
                   Graph. Edge edge=graph[j].get(k);
                   int u= edge.src;
                    int v = edge.des;
                    int weight = edge.wt;
                    if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                    }
                }
            }
        }



        return distances;
        //use this one for just only edges

//    int[] distances = new int[numVertices];
//    Arrays.fill(distances, Integer.MAX_VALUE);
//    distances[source] = 0;
//
//    // Relax edges numVertices - 1 times
//    for (int i = 0; i < numVertices - 1; i++) {
//        for (Edge edge : edges) {
//            int u = edge.source;
//            int v = edge.destination;
//            int weight = edge.weight;
//            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
//                distances[v] = distances[u] + weight;
//            }
//        }
//    }

    }




    public static List<Graph.Edge> kruskalMST(List<Graph.Edge> edges, int numVertices) {
        // Sort edges by weight to get minimum
        edges.sort(Comparator.comparingInt(e -> e.wt));

        // Initialize disjoint set and MST
        DisjointSet ds = new DisjointSet(numVertices);
        List<Graph.Edge> mst = new ArrayList<>();

        // Add edges to MST until all vertices are connected
        for (Graph.Edge edge : edges) {
            int u = edge.src;
            int v = edge.des;

            if (ds.find(u) != ds.find(v)) {//if not connected then connect
                mst.add(edge);
                ds.union(u, v);
            }

            if (mst.size() == numVertices - 1) {//if size of over flow stop
                break;
            }
        }

        return mst;
    }











    static class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int numVertices) {
            parent = new int[numVertices];
            rank = new int[numVertices];

            for (int i = 0; i < numVertices; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
public  void init(int n){
    for (int i = 0; i < n; i++) {
        parent[i] = i;
}}
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }











    public void shortestPaths(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize dist matrix with the given graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Compute shortest path for all vertices
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print shortest distance matrix
        printDistances(dist);
    }

    public void printDistances(int[][] dist) {
        System.out.println("Shortest distances between all pairs of vertices:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

}
