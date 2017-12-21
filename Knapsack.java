public class Knapsack
{
	public Knapsack()
	{
		int n=4;
		int w[]={2,3,4,5};
		int v[]={16,19,23,28};
		int K=7;
		
		int arr[][]=new int[n+1][K+1];
		for(int i=0;i<arr.length;i++) arr[i][0]=0;
		for(int i=0;i<arr[0].length;i++) arr[0][i]=0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=K;j++)
			{
				if(w[i-1]<=j)
				{
					arr[i][j]=Math.max(arr[i-1][j],v[i-1]+arr[i-1][j-w[i-1]]);
				}
				else arr[i][j]=arr[i-1][j];
			}
		}
		System.out.println(arr[n][K]);
		print(arr,n,K,w);
	}
	public void print(int arr[][],int i,int j,int w[])
	{
		if(arr[i][j]==arr[i-1][j]&&i-1>0&&j>0) print(arr,i-1,j,w);
		else
		{
			System.out.print(i);
			if(i-1>0&&j-w[i-1]>0) print(arr,i-1,j-w[i-1],w);
		}
	}
	public static void main(String args[])
	{
		new Knapsack();
	}
}