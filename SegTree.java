public class SegTree
{
	int n;
	//node class
	class Node
	{
		int val;
		public Node(int val)
		{
			this.val=val;
		}
		public void split(Node l,Node r)
		{
			
		}
		public void merge(Node l,Node r)
		{
			val=Math.min(l.val,r.val);
		}
	}
	Node tree[]=new Node[1<<(n+1)];
	Node identity=new Node(Integer.MAX_VALUE);
	
	//query
	public Node query(int root,int left_most,int right_most,int u,int v)
	{
		if(u<=left_most&&right_most>=v) return tree[root];
		int mid=(left_most+right_most)/2,left_child=2*root,right_child=left_child+1;
		tree[root].split(tree[left_child],tree[right_child]);
		Node l=identity,r=identity;
		if(u<mid) l=query(left_child,left_most,mid,u,v);
		if(v>mid) r=query(right_child,mid,right_most,u,v);
		tree[root].merge(tree[left_child],tree[right_child]);
		Node n=identity;
		n.merge(l,r);
		return n;
	}
	
	//constructor
    public SegTree()
    {
    	n=3;
    }
    public static void main(String args[])
    {
    	new SegTree();
    }
}