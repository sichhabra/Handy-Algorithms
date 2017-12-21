import java.io.*;
import java.util.*;
public class Main
{
	long fact[]=new long[800001];
	long ifact[]=new long[800001];
	int MOD=1000000007;
	
	public long mod_exp(long a,long n,long MOD)
	{
		long ans=1;
		while(n>0)
		{
			if(n%2==1) ans=(a*ans)%MOD;
			a=(a*a)%MOD;
			n/=2;
		}
		return ans%MOD;
	}
	public long ways(int x,int y)
	{
		return (((fact[x+y]*ifact[x])%MOD)*ifact[y])%MOD;
	}
	
    public Main() throws Exception
    {
    	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	    fact[0]=1;
	    for(int i=1;i<=800000;i++)
	    {
	    	fact[i]=(i*fact[i-1]);
	    	if(fact[i]>MOD) fact[i]%=MOD;
	    }
	    ifact[800000]=mod_exp(fact[800000],MOD-2,MOD);
	    for(int i=800000;i>0;i--)
	    {
	    	ifact[i-1]=ifact[i]*i;
	    	if(ifact[i-1]>MOD) ifact[i-1]%=MOD;
	    }
	    int test=Integer.parseInt(in.readLine());
	    while(test-->0)
	    {
	    	String str[]=in.readLine().split(" ");
	    	int N=Integer.parseInt(str[0]);
	    	int M=Integer.parseInt(str[1]);
	    	int A=Integer.parseInt(str[2]);
	    	int B=Integer.parseInt(str[3]);
	    	if(A==0||B==0)
	    	{
	    		out.write(ways(M,N)+"\n");
	    		continue;
	    	}
	    	long ans=0;
	    	for(int p=0;p<=(N-A);p++)
	    	{
	    		ans+=(ways(p,B-1)*ways(N-p,M-B));
	    		if(ans>=MOD) ans%=MOD;
	    	}
	    	out.write(ans+"\n");
	    }
	    out.flush();
    }
    public static void main(String args[]) throws Exception
    {
	    new Main();
    }
} 