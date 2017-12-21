public class Manacher	//finding longest palindrome substring O(n) time.
{
	
	public String preProcess(String str)
	{
		int n=str.length();
		if(n==0) return "^$";
		String ret="^";
		for(int i=0;i<n;i++)
		{
			ret+="#"+str.charAt(i);
		}
		ret+="#$";
		return ret;
	}
	
	public String longestPalindrome(String str)
	{
		String T=preProcess(str);
		int n=T.length();
		int P[]=new int[n];
		int C=0,R=0;
		for(int i=1;i<n-1;i++)
		{
			System.out.println(i+":");
			P[i]=(R>i)?Math.min(R-i,P[2*C-i]):0;
			System.out.println(P[i]);
			while((i+1+P[i]<n)&&(i-P[i]-1>0)&&T.charAt(i+1+P[i])==T.charAt(i-1-P[i])) P[i]++;
			System.out.println(P[i]);
			if(i+P[i]>R)
			{
				C=i;
				R=i+P[i];
			}
		}
		int maxLen=0,centerIndex=0;
		for(int i=1;i<n-1;i++)
		{
			if(P[i]>maxLen)
			{
				maxLen=P[i];
				centerIndex=i;
			}
		}
		
		return str.substring((centerIndex-1-maxLen)/2,maxLen);
	}
	
	public Manacher()
	{
		String str="aabb";
		System.out.println(longestPalindrome(str));
	}
	public static void main(String args[])
	{
		new Manacher();
	}
}