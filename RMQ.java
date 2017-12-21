public class RMQ	//Range Minimum Query - finding minimum
{
	int arr[]={3,3,2,2,3,3};
	int N=5;
	int M[][];
	
	public void process2()	//<O(Nlog(n)),O(1)> space=N^2 store min from i to 2^j
	{
		for(int i=0;i<N;i++) M[i][0]=i;
		for(int j=1;(1<<j)<=N;j++)
		{
			for(int i=0;i+(1<<j)-1<N;i++)
			{
				if(arr[M[i][j-1]]<arr[M[i+(1<<(j-1))][j-1]]) M[i][j]=M[i][j-1];
				else M[i][j]=M[i+(1<<(j-1))][j-1];
			}
		}
	}
	public int rmq(int i,int j)
	{
		int k=(int)(Math.log(j-i+1)/Math.log(2));
		if(arr[M[i][k]]<=arr[M[j-(1<<k)+1][k]]) return M[i][k];
		else return M[j-(1<<k)+1][k];
	}
	public RMQ()
	{
		int L=(int)(Math.log(N)/Math.log(2));
		M=new int[N][L+1];
		process2();
		System.out.println(arr[rmq(0,5)]);
	}
	public static void main(String args[])
	{
		new RMQ();
	}
}