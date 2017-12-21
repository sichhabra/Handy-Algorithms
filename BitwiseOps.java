public class BitwiseOps
{
	public boolean ithBitSet(int n,int i)	//ith bit is set.
	{
		return ((n&1<<i)!=0);
	}
	
	public boolean powerOf2(int x)			//no is a power of 2.
	{
		return ((x&(x-1))==0);
	}
	
	public void printSubsets(int arr[],int n)			//print all subsets of a set.
	{
		int n2 = 1<<n;
		for(int i=0;i<n2;i++)
		{
			for(int j=0;j<n;j++)
				if((i&(1<<j))!=0)
					System.out.print(arr[j]);
			System.out.println();
		}
	}
	
	public void subsetsOfSubset(int N)		//subsets of a subset
	{
		int X=N;
		while(true)
		{
			System.out.println(X);
			if(X==0) break;
			X=(X-1)&N;
		}
	}
	
	public int setLowestBitOff(int X)		//return by setting lowest bit off.
	{
		return (X&(X-1));
	}
	
	public int lowestBit(int X)				//return lowest bit.(2^i).
	{
		return (X^(X&(X-1)));
	}
	
	public int msb(int Y)					//return only msb set -> highest power of 2 less than number.
	{
		Y|=(Y>>1);
		Y|=(Y>>2);
		Y|=(Y>>4);
		Y|=(Y>>8);
		Y|=(Y>>16);
		return ((Y+1)>>1);
	}
	
    public BitwiseOps()
    {
    	System.out.println(ithBitSet(3,0));
    	printSubsets(new int[]{1,2,3,4},4);
    	subsetsOfSubset(22);
    	System.out.println(msb(33));
    }
    public static void main(String args[])
    {
    	new BitwiseOps();
    }
}