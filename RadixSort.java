public class RadixSort
{
	int arr[]={170, 45, 75, 90, 802, 24, 2, 66};
	
	public int getMax()
	{
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			if(arr[i]>max) max=arr[i];
		return max;
	}
	
	public void countSort(int exp)
	{
		int n=arr.length;
		int output[]=new int[n];
		int count[]=new int[10];
		for(int i=0;i<n;i++) count[(arr[i]/exp)%10]++;
		for(int i=1;i<10;i++) count[i]+=count[i-1];
		for(int i=n-1;i>=0;i--)
		{
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		for(int i=0;i<n;i++) arr[i]=output[i];
	}
	
    public RadixSort()
    {
    	int m=getMax();
    	for(int exp=1;m/exp>0;exp*=10) countSort(exp);
    	for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
    public static void main(String args[])
    {
    	new RadixSort();
    }
}