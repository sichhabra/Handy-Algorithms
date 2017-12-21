import java.util.*;
public class Graphs
{
	HashMap<Integer,LinkedList<Integer>> adj;
	
	public void addEdge(int v,int w)
	{
		adj.get(v).add(w);
	}
	
	public LinkedList getList(int v)
	{
		return adj.get(v);
	}
	
	public void show()
	{
		for(int i=0;i<adj.size();i++)
		{
			System.out.print(i+":");
			LinkedList list=getList(i);
			for(int j=0;j<list.size();j++) System.out.print(list.get(j)+" ");
			System.out.println();
		}
	}
	public Graphs()
	{
		int arr[]={0,1,2,3,4};
		adj=new HashMap<Integer,LinkedList<Integer>>();
		for(int i=0;i<arr.length;i++) adj.put(i,new LinkedList<Integer>());
		addEdge(0,1);
		addEdge(1,2);
		show();
	}
	public int[][] warshall(int arr[][])
	{
		int n=arr.length;
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]|=arr[i][k]&arr[i][j];
				}
			}
		}
		return arr;
	}
	public static void main(String args[])
	{
		new Graphs();
	}
}