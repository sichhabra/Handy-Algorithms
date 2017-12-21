import java.util.*;
public class SuffixArrays
{
	String str="abaabba";
	int n=str.length();
	
	int S[]=new int[n];
	int lcp[]=new int[n];
	String suffixes[]=new String[n];
	
	public SuffixArrays()
	{
		for(int i=0;i<n;i++) suffixes[i]=str.substring(i);
		Arrays.sort(suffixes);
		lcp[0]=0;
		for(int i=1;i<n;i++) lcp[i]=lcp(suffixes[i],suffixes[i-1]);
		for(int i=0;i<n;i++) System.out.print(lcp[i]+" ");
	}
	public int lcp(String s,String t)
	{
		int N=Math.min(s.length(),t.length());
		for(int i=0;i<N;i++)
		{
			if(s.charAt(i)!=t.charAt(i)) return i;
		}
		return N;
	}
	public static void main(String args[])
	{
		new SuffixArrays();
	}
}