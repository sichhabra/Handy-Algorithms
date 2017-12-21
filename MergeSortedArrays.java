public class MergeSortedArrays
{
	int a[];
	public void merge(int a[],int b[],int n,int m)
	{
		int k=m+n-1;
		int i=n-1;
		int j=m-1;
		while(i>=0&&j>=0)
		{
			if(a[i]>b[j]) a[k--]=a[i--];
			else a[k--]=b[j--];
		}
		while(j>=0) a[k--]=b[j--];
	}
	public void print(int arr[])
	{
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]);
		System.out.println();
	}
    public MergeSortedArrays()
    {
    	a=new int[10];
    	int b[]=new int[5];
    	a[0]=1;a[1]=3;a[2]=5;a[3]=7;a[4]=9;
    	b[0]=2;b[1]=4;b[2]=6;b[3]=8;b[4]=10;
    	merge(a,b,5,5);
    	print(a);
    }
    public static void main(String args[])
    {
    	new MergeSortedArrays();
    }
}