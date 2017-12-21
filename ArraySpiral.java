public class ArraySpiral
{
	int arr[][]={{1,2,3},{4,5,6},{7,8,9},{0,0,7}};
	
	public void print()
	{
		int a=0,b=0;
		int n=arr[0].length;
		int m=arr.length;
		while(b<m&&a<n)
		{
			for(int i=a;i<n;i++) System.out.print(arr[b][i]+" ");b++;
			for(int i=b;i<m;i++) System.out.print(arr[i][n-1]+" ");n--;
			if(b<m){
				for(int i=n-1;i>=a;i--) System.out.print(arr[m-1][i]+" ");m--;}
			if(a<n){
				for(int i=m-1;i>=b;i--) System.out.print(arr[i][a]+" ");a++;}
		}
	}
	
    public ArraySpiral()
    {
    	print();
    }
    public static void main(String args[])
    {
    	new ArraySpiral();
    }
}