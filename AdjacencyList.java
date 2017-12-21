public class AdjacencyList {
	
	int N;
	AdjacencyList graph;
	
	
	class Node	//node	
	{
		int v;
		Node next;
		public Node(int v,Node next)
		{
			this.v=v;
			this.next=next;
		}
	}
	
	class Edge	//edge
	{
		int v;
		int w;
		public Edge(int v,int w)
		{
			this.v=v;
			this.w=w;
		}
	}
	
	interface AdjList	//adjlist interface
	{
		int beg();
		int next();
		boolean end();
	}
	
	class AdjLinkedList	implements AdjList	//linked list class
	{
		int v;
		Node t;
		AdjLinkedList(int v)
		{
			this.v=v;
			t=null;
		}
		public int beg()
		{
			t=adj[v];
			return t==null ? -1 : t.v;
		}
		public int next()
		{
			if(t!=null) t=t.next;
			return t==null ? -1 : t.v;
		}
		public boolean end()
		{
			return t==null;
		}
	}
	
	AdjList getAdjList(int v)	//getAdjList
	{
		return new AdjLinkedList(v);
	}
	
	Node adj[];//array of linked lists.
	
	
    public AdjacencyList(int v)	//parameterised constructor
    {
    	adj=new Node[v];
    }
    
    void insert(Edge e)			//insert
    {
    	int v=e.v;
    	int w=e.w;
    	adj[v]=new Node(w,adj[v]);
    	adj[w]=new Node(v,adj[w]);
    }
    
    void show(AdjacencyList G)	//display
    {
    	for(int s=0;s<N;s++)
    	{
    		System.out.print(s+" : ");
    		AdjList A=G.getAdjList(s);
    		for(int t=A.beg();!A.end();t=A.next())
    		{
    			System.out.print(" "+t);
    		}
    		System.out.println();
    	}
    }
    
    public AdjacencyList()
    {
    	N=4;
    	graph=new AdjacencyList(N);
    	for(int i=0;i<3;i++) graph.insert(new Edge(i,i+1));
    	show(graph);
    }
    public static void main(String args[])
    {
    	new AdjacencyList();
    }
}