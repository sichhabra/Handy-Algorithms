public class DFS
{
	class Node
	{
		int v;
		Node next;
		public Node(int v,Node next)
		{
			this.v=v;
			this.next=next;
		}
	}
	Node adj[];
	class Edge
	{
		int v,w;
		public Edge(int v,int w)
		{
			this.v=v;
			this.w=w;
		}
	}
	public void insert(Edge e)
	{
		adj[e.v]=new Node(e.w,adj[e.v]);
	}
	class AdjList
	{
		int v;
		Node t;
		public AdjList(int v)
		{
			this.v=v;
			t=null;
		}
		public int beg()
		{
			t=adj[v];
			return t==null?-1:t.v;
		}
		public int next()
		{
			if(t!=null) t=t.next;
			return t==null?-1:t.v;
		}
		public boolean end()
		{
			return t==null;
		}
	}
	public DFS(int N)
	{
		adj=new Node[N];
		visited=new boolean[N];
		insert(new Edge(0,1));
		insert(new Edge(3,0));
		insert(new Edge(1,3));
		for(int i=0;i<N;i++) dfs(i);
	}
	
	boolean visited[];
	public void dfs(int v)
	{
		if(!visited[v])
		{
			visited[v]=true;
			System.out.println(v);
		}
		AdjList list=new AdjList(v);
		for(int i=list.beg();!list.end();i=list.next())
		{
			if(!visited[i]) dfs(i);
		}
	}
	
	public static void main(String args[])
    {
    	new DFS(4);
    }
}