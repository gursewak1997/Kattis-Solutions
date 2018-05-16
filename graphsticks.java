
import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

class Graph
{
   static class Digraph
{
   private final int V;
   private int E;
   private LinkedList<Integer>[] adjacentList;
   public  Digraph(int V)
   {
     this.V = V;
     this.E = 0;
     adjacentList = (LinkedList<Integer>[]) new LinkedList[V];
     for (int v = 0; v < V; v++)
     adjacentList[v] = new LinkedList<Integer>();
   }
   public int V() { return V; }
   public int E() { return E; }
   public void addEdge(int v, int w)
   {
     adjacentList[v].add(w);
     E++;
   }
   public Iterable<Integer> adjacentList(int v)
   { return adjacentList[v];
   }
   public Digraph reverse()
   {
     Digraph R = new Digraph(V);
     for (int v = 0; v < V; v++)
     for (int w : adjacentList(v))
     R.addEdge(w, v);
     return R;
   }
}
static class DirectedCycle
{
   private boolean[] marked;
   private int[] edgeTo;
   private Stack<Integer> cycle; 
   private boolean[] onStack; 
   public DirectedCycle(Digraph G)
   {
     onStack = new boolean[G.V()];
     edgeTo = new int[G.V()];
     marked = new boolean[G.V()];
     for (int v = 1; v < G.V(); v++)
     if (!marked[v]) dfs(G, v);
   }
   private void dfs(Digraph G, int v)
   {
     onStack[v] = true;
     marked[v] = true;
     for (int w : G.adjacentList(v))
     if (this.hasCycle()){
       return;
     }
     else if (!marked[w])
     { edgeTo[w] = v; dfs(G, w); }
     else if (onStack[w])
     {
     cycle = new Stack<Integer>();
     for (int x = v; x != w; x = edgeTo[x])
     cycle.push(x);
     cycle.push(w);
     cycle.push(v);
     }
     onStack[v] = false;
   }
   public boolean hasCycle()
    { 
    return cycle != null;
    }
   public Iterable<Integer> cycle()
   { 
    return cycle; 
   }
}
 static class DepthFirstOrder
{
   private boolean[] marked;
   private Stack<Integer> reversePost;
   public DepthFirstOrder(Digraph G)
   {
     reversePost = new Stack<Integer>();
     marked = new boolean[G.V()];
     for (int v = 1; v < G.V(); v++)
     if (!marked[v]) dfs(G, v);
   }
   private void dfs(Digraph G, int v)
   {
     marked[v] = true;
     for (int w : G.adjacentList(v))
     if (!marked[w])
     dfs(G, w);
     reversePost.push(v);
   }
   public Iterable<Integer> reversePost()
   { return reversePost; }
}
static class Topological
{
   private Iterable<Integer> order;
   public Topological(Digraph G)
   {
     DirectedCycle cyclefinder = new DirectedCycle(G);
     if(!cyclefinder.hasCycle()){
     DepthFirstOrder dfs = new DepthFirstOrder(G);  
     order = dfs.reversePost();
 }
   }
   public Iterable<Integer> order()
   { return order; }
   public boolean isDAG()
   { return order == null; }
}
  public static void main(String[]args)
  {
    Scanner scan = new Scanner(System.in);
        int sticks = scan.nextInt();
        int lines = scan.nextInt();
        Digraph g = new Digraph(sticks+1);

        for(int i=0; i<lines;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            g.addEdge(a,b);
        }
        Topological topo = new Topological(g.reverse());

        if(topo.isDAG()==false){
        System.out.println(topo.order().toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll(",","\n").replaceAll(" ",""));
            
        }
        else{
            System.out.println("IMPOSSIBLE");
    }
  }
}