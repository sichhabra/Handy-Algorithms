import java.util.*;
import java.io.*;
public class AhoCorasick
{
	public AhoCorasick() throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	    int test=Integer.parseInt(in.readLine());
	    while(test-->0)
	    {
	    	String str[]=in.readLine().split(" ");
	    	int N=Integer.parseInt(str[0]);
	    	int M=Integer.parseInt(str[1]);
	    	char s[]=in.readLine().toCharArray();
	    	
	    	Trie trie=new Trie();
	    	for(int i=0;i<M;i++) trie.add(in.readLine().toCharArray());
	    	trie.buildFailure();
	    	
	    	Trie.Node ta[]=trie.toArray();
	    	int u=ta.length;
	    	int dp[][]=new int[N+1][u];
	    	String val[][]=new String[N+1][u];
	    	
	    	for(int i=0;i<=N;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
	    	dp[0][0]=0;
	    	val[0][0]="";
	    	
	    	for(int t=0;t<N;t++)
	    	{
	    		for(int pos=0;pos<u;pos++)
	    		{
	    			if(dp[t][pos]<0) continue;
	    			Trie.Node cur=ta[pos];
	    			char inf=(s[t]=='?')?'a':s[t];
	    			char sup=(s[t]=='?')?'z':s[t];
	    			for(char c=inf;c<=sup;c++)
	    			{
	    				Trie.Node nex=trie.next(cur,c);
	    				if(dp[t+1][nex.id]<dp[t][pos]+nex.hit)
	    				{
	    					dp[t+1][nex.id]=dp[t][pos]+nex.hit;
	    					val[t+1][nex.id]=val[t][pos]+c;
	    				}
	    				else if(dp[t+1][nex.id]==dp[t][pos]+nex.hit)
	    				{
	    					String x=val[t][pos]+c;
	    					if(x.compareTo(val[t+1][nex.id])<0) val[t+1][nex.id]=x;
	    				}
	    			}
	    		}
	    	}
	    	int max=-1;
	    	String ret="~";
	    	for(int pos=0;pos<u;pos++)
	    	{
	    		if(dp[N][pos]>max||dp[N][pos]==max&&val[N][pos].compareTo(ret)<0)
	    		{
	    			max=dp[N][pos];
	    			ret=val[N][pos];
	    		}
	    	}
	    	out.write(max+"\n");
	    	out.write(ret+"\n");
	    }
	    out.flush();
	}
	public class Trie//construction of trie.
	{
		public class Node
		{
			public int id;
			public char c;
			public Node next,firstChild;
			public int hit=0;
			public Node fail;
			public Node(char c,int id){this.id=id;this.c=c;}
		}
		public Node root=new Node((char)0,0);
		public int gen=1;
		public void add(char s[])//add a string in trie.
		{
			Node cur=root;
			Node pre=null;
			for(char c:s)
			{
				pre=cur;cur=cur.firstChild;
				if(cur==null) {cur=pre.firstChild=new Node(c,gen++);}
				else
				{
					for(;cur!=null&&cur.c!=c;pre=cur,cur=cur.next);
					if(cur==null) cur=pre.next=new Node(c,gen++);
				}
			}
			cur.hit++;
		}
		public void buildFailure() //make failure links and complete ac-trie.
		{
			root.fail=null;
			Queue<Node> q=new ArrayDeque<Node>();
			q.add(root);
			while(!q.isEmpty())
			{
				Node cur=q.poll();
				inner : for(Node ch=cur.firstChild;ch!=null;ch=ch.next)
				{
					q.add(ch);
					for(Node to=cur.fail;to!=null;to=to.fail)
					{
						for(Node lch=to.firstChild;lch!=null;lch=lch.next)
						{
							if(lch.c==ch.c)
							{
								ch.fail=lch;
								ch.hit+=lch.hit;
								continue inner;
							}
						}
					}
					ch.fail=root;
				}
			}
		}
		public void search(char q[])	//searching string ij ac-trie.
		{
			Node cur=root;
			outer : for(char c : q)
			{
				for(;cur!=null;cur=cur.fail)
				{
					for(Node ch=cur.firstChild;ch!=null;ch=ch.next)
					{
						if(ch.c==c)
						{
							cur=ch;
							continue outer;
						}
					}
				}
				cur=root;
			}
		}
		public Node[] toArray()
		{
			Queue<Node> q=new ArrayDeque<Node>();
			q.add(root);
			Node ret[]=new Node[gen];
			while(!q.isEmpty())
			{
				Node cur=q.poll();
				ret[cur.id]=cur;
				if(cur.next!=null) q.add(cur.next);
				if(cur.firstChild!=null) q.add(cur.firstChild);
			}
			return ret;
		}
		public Node next(Node cur,char c)
		{
			for(;cur!=null;cur=cur.fail)
			{
				for(Node ch=cur.firstChild;ch!=null;ch=ch.next)
					if(ch.c==c) return ch;
			}
			return root;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		new AhoCorasick();
	}
}