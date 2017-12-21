import java.io.*;
import java.util.*;
public class SegmentedSieve
{
	static long start;
	static boolean primes[]=sieve(1000000);
	public static boolean[] sieve(int n)
	{
		boolean prime[]=new boolean[n+1];
		Arrays.fill(prime,true);
		prime[0]=false;
		prime[1]=false;
		int m=(int)Math.sqrt(n);
		for(int i=2;i<=m+1;i++)
		{
			if(prime[i])
			{
				for(int k=i*i;k<=n;k+=i) prime[k]=false;
			}
		}
		return prime;
	}
    public SegmentedSieve() throws Exception
    {
    	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	    int test=Integer.parseInt(in.readLine());
	    while(test-->0)
	    {
	    	String str[]=in.readLine().split(" ");
	    	long a=Long.parseLong(str[0]);
	    	long b=Long.parseLong(str[1]);
	    	if(a==1) a=2;
			boolean is_prime[]=new boolean[(int)(b-a+1)];
			Arrays.fill(is_prime,true);
			int sqr=(int)Math.sqrt(b);
			for (int i = 2; i <= sqr; i++)
			{
				if (primes[(int) i])
				{
					if (a % i == 0) start = a;
					else start = a + (i - (a % i));
					for (long j = start; j <= b; j += i)
						if (j != i)
							is_prime[(int)(j-a)] = false;
				}
			}
			int count=0;
	    	for(int i=0;i<is_prime.length;i++) if(is_prime[i]) count++;
	    	out.write(count+"\n");
	    }
	    out.flush();
    }
    public static void main(String args[]) throws Exception
    {
	    new SegmentedSieve();
    }
} 