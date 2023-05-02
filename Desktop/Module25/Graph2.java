import java.util.*;

public class Graph2 {

    public static void bfs(ArrayList<Graph.Edge>[]graph){
        boolean[] vis =new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
if(!vis[i]){
    bfsutil(graph,vis);
}
        }
    }
    public static void bfsutil(ArrayList<Graph.Edge>[]graph,boolean [] vis){//BFS
        Queue<Integer> q=new LinkedList<>();
        q.add(0);//cuz index starts from 0
        while(!q.isEmpty()){
            int cur=q.remove();
            if(!vis[cur]){
                System.out.println(cur);
                vis[cur]=true;
                for (int i = 0; i < graph[cur].size(); i++) {//current vertex
                    Graph.Edge e=graph [cur].get(i);
                    q.add(e.des);//destination is the  new vertex


                }
            }
        }
    }
    public static void dfs(ArrayList<Graph.Edge>[]graph){
        boolean[] vis =new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {//just like a 2d array
dfsutil(graph,i,vis);
    }}
    public static void dfsutil(ArrayList<Graph.Edge>[]graph, int cur, boolean vis[]){//DFS
        System.out.print(cur+" ");
        vis[cur]=true;
        for (int i = 0; i < graph[cur].size(); i++) {//just like a 2d array
            Graph.Edge e=graph[cur].get(i);
            if(!vis[e.des]){
                //if not visited then visit
                dfsutil(graph,e.des,vis);
            }
        }

    }
    public static boolean detectcycle(ArrayList<Graph.Edge>[]graph){
        boolean[] vis =new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {//just like a 2d array
          if(!vis[i]){

             if( detectcycleutil(graph,i,-1,vis)){
                 return true;
             }
          }
        }return false;
    }

    public static boolean detectcycleutil(ArrayList<Graph.Edge>[]graph, int cur,int par, boolean vis[]){//DFS

        vis[cur]=true;
        for (int i = 0; i < graph[cur].size(); i++) {//just like a 2d array
            Graph.Edge e=graph[cur].get(i);
            if(!vis[e.des]){
                if( detectcycleutil(graph,e.des,cur,vis)){
                return true;}
            }
                //if not visited then visit


        else if (vis[e.des] && e.des!=par){//parent variable is important to check if has loop or not
            return true;
            }


    }
        return false;
    }


    public static boolean isBipartite(List<Graph.Edge>[] graph) {//BFS

        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);//filling all color as neutral

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {//if neutral then add in queue
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 0;

                while (!queue.isEmpty()) {
                    int curr = queue.remove();


                    for (Graph.Edge edge : graph[curr]) {
                        int neighbor = edge.des;
                        if (colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[curr];
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[curr]) {
                            return false;
                        }}
                    }

            }
        }
        return true;
    }

    public static boolean hasCycle(ArrayList<Graph.Edge>[] graph) {//for unidirectional
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycleUtil(ArrayList<Graph.Edge>[] graph, int curr, boolean[] visited, boolean[] recStack) {//DFS
        visited[curr] = true;
        recStack[curr] = true;//for unidirectional

        for (Graph.Edge e : graph[curr]) {
            int neighbor = e.des;
            if (!visited[neighbor]) {
                if (hasCycleUtil(graph, neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[curr] = false;
        return false;
    }


    public static List<Integer> topologicalSort(ArrayList<Graph.Edge>[] graph) {//DFS
        int n = graph.length;
        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();//to store the visited vertex

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }
        //storing the sorted data in list
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void dfs(ArrayList<Graph.Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (Graph.Edge edge : graph[curr]) {
            int neighbor = edge.des;
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, stack);
            }
        }

        stack.push(curr);//special thing for sorting
    }



    public static void main(String[] args) {

    }
}
