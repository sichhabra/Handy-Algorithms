public class KadaneMaxSubarray
{
	//finding maximum subarray
	//does not work if all no. are negative -> take bool find case and give max of array in dat case.
	public int maxsum(int arr[])
	{
		int end=0,yet=0;
		for(int i=0;i<arr.length;i++)
		{
			end+=arr[i];
			if(end<0) end=0;
			if(yet<end) yet=end;
		}
		return yet;
	}
    public KadaneMaxSubarray()
    {
    	int arr[]={1,1,1,1};
    	System.out.println(maxsum(arr));
    }
    public static void main(String args[])
    {
    	new KadaneMaxSubarray();
    }
}