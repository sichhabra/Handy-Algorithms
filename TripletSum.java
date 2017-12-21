class TripletSum
{
	public void findTriplets(int arr[],int sum)
	{
		java.util.Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			int l=i+1;
			int r=arr.length-1;
			while(l<r)
			{
				if(arr[i]+arr[l]+arr[r]==sum) {System.out.println(arr[i]+":"+arr[l]+":"+arr[r]);l++;}
				else if(arr[i]+arr[l]+arr[r]<sum) l++;
				else r--;
			}
		}
	}
	public TripletSum()
	{
		int arr[]={1,2,3,4,5,6};
		findTriplets(arr,8);
	}
	public static void main(String args[])
	{
		new TripletSum();
	}
}