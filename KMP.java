public class KMP
{
	String text="abcdabcdabcaba";
	String pattern="abababca";
	
	int[] preprocess(String pattern)
	{
		int j=0;
		int m=pattern.length();
		int failure[]=new int[m];
		
		for(int i=1;i<m;i++)
		{
			while(j>0&&pattern.charAt(i)!=pattern.charAt(j)) j=failure[j-1];
			if(pattern.charAt(i)==pattern.charAt(j)) j++;
			failure[i]=j;
		}
		return failure;
	}
	
	public int match(String text,String pattern)
	{
		int j=0;
		int m=text.length();
		int n=pattern.length();
		int failure[]=preprocess(pattern);
		
		if(m==0) return -1;
		for(int i=0;i<m;i++)
		{
			while(j>0&&pattern.charAt(j)!=text.charAt(i)) j=failure[j-1];
			if(pattern.charAt(j)==text.charAt(i)) j++;
			if(j==n)
			{
				return (i-n+1);
			}
		}
		return -1;
	}
	
	public void print(int arr[])
	{
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
		System.out.println();
	}
	
    public KMP()
    {
    	System.out.println(match("siddhartha","a"));
    }
    public static void main(String args[])
    {
    	new KMP();
    }
}