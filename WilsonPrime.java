import java.util.*;
public class WilsonPrime
{
	public long mod_fact(long n,long MOD)
	{
		long x=1;
		for(int i=1;i<=n;i++) x=(long)(x*i)%MOD;
		return x;
	}
    public WilsonPrime()
    {
    	Scanner sc=new Scanner(System.in);
    	while(true)
    	{
    		long test=sc.nextLong();
    		if(mod_fact(test-1,test)==(test-1)) System.out.println("YES");
    		else System.out.println("NO");
    	}
    }
    public static void main(String args[])
    {
    	new WilsonPrime();
    }
}