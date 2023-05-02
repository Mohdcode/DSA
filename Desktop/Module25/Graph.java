import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge{
        int src;
        int des;
        int wt;

        public Edge(int src,int des,int wt) {

            this.src = src;
            this.des=des;
            this.wt=wt;

        }}
        public static void bfs(ArrayList<Edge>[]graph){
            Queue<Integer>q=new LinkedList<>();
            boolean[] vis =new boolean[graph.length];
            q.add(0);//cuz index starts from 0
            while(!q.isEmpty()){
                int cur=q.remove();
                if(!vis[cur]){
                    System.out.println(cur);
                    vis[cur]=true;
                    for (int i = 0; i < graph[cur].size(); i++) {//current vertex
                        Edge e=graph [cur].get(i);//exploring the neighbours of current index
                        q.add(e.des);//destination is the  new vertex


                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[]graph,int cur,boolean vis[]){
        System.out.print(cur+" ");
        vis[cur]=true;//this to get the visited
        for (int i = 0; i < graph[cur].size(); i++) {//just like a 2d array
            Edge e=graph[cur].get(i);
            //backtracking is used in this
            if(!vis[e.des]){
                //if not visited then visit
                dfs(graph,e.des,vis);
            }
        }

    }
    public static boolean haspath(ArrayList<Edge>[]graph,int s,int d,boolean []vis){//DFS
        if (s==d){
            return true;
        }
        vis[s]=true;
        for (int i = 0; i < graph[s].size(); i++) {
            Edge e=graph[s].get(i);
            if(!vis[e.des]&& haspath(graph,e.des,d,vis)){
                return true;
            }

        }return false;
    }
    public static void main(String[] args) {
        //there is adjecency in every representation of graphs
        //like Node class in linked list and tree
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        //arraylist of edges of array
        for (int i=0;i<V;i++){
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new Edge(0,1,5));
        //1st vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(0,1,5));
//2nd vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));
        //3rd vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
//4rth vertex
        graph[4].add(new Edge(4,2,2));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e=graph[2].get(i);
            System.out.println(e.des);
        }
        bfs(graph);
        dfs(graph,0,new boolean[V]);
boolean b=haspath(graph,0,4,new boolean[V]);
System.out.println(b);





    }
}
