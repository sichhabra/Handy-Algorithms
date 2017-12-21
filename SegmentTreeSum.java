public class SegmentTreeSum
{
	int arr[]={1000,1002,1003,1004,1005};
	int n=5;
	int st[];
	
	public void constructTree()
	{
		int x=(int)Math.ceil(Math.log(n)/Math.log(2));
		int range=2*(int)Math.pow(2,x)-1;
		st=new int[range];
		constructTreeUtil(0,n-1,0);
	}
	
	public int constructTreeUtil(int ss,int se,int i)
	{
		if(ss==se) {st[i]=arr[ss];return st[i];}
		int mid=(ss+se)/2;
		st[i]=constructTreeUtil(ss,mid,2*i+1)+constructTreeUtil(mid+1,se,2*i+2);
		return st[i];
	}
	
	public void print()
	{
		for(int i=0;i<st.length;i++) System.out.print(st[i]+" ");
		System.out.println();
	}
	
	public int getSum(int qs,int qe)
	{
		if(qs<0||qe>n-1||qe<qs) return -1;
		return getSumUtil(0,n-1,qs,qe,0);
	}
	
	public int getSumUtil(int ss,int se,int qs,int qe,int index)
	{
		if(qs<=ss&&qe>=se) return st[index];
		if(se<qs||ss>qe) return 0;
		int mid=(ss+se)/2;
		return getSumUtil(ss,mid,qs,qe,2*index+1)+getSumUtil(mid+1,se,qs,qe,2*index+2);
	}
	
	public SegmentTreeSum()
	{
		constructTree();
		System.out.println(getSum(0,2));
		update(0,arr[0]+3);
		System.out.println(getSum(0,2));
	}
	
	public void update(int i,int new_value)
	{
		if(i<0||i>n-1) return;
		int diff=new_value-arr[i];
		arr[i]=new_value;
		updateUtil(0,n-1,i,diff,0);
	}
	
	public void updateUtil(int ss,int se,int i,int diff,int index)
	{
		if(i<ss||i>se) return;
		st[index]+=diff;
		if(se!=ss)
		{
			int mid=(ss+se)/2;
			updateUtil(ss,mid,i,diff,2*index+1);
			updateUtil(mid+1,se,i,diff,2*index+2);
		}
	}
	
	public static void main(String args[])
	{
		new SegmentTreeSum();
	}
}