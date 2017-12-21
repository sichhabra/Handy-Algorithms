//a^n%MOD
public class ModularExponentiation
{
    public static long exp_mod(long a,long n,long MOD)
    {
    	if(n==0) return 1L%MOD;
    	if(n==1) return a%MOD;
    	if((n&1)!=0) return a*exp_mod(a,n-1,MOD)%MOD;
    	else
    	{
    		long ret=exp_mod(a,n/2,MOD);
    		return ret*ret%MOD;
    	}
    }
    public static void main(String args[])
    {
    	System.out.println(exp_mod(4,11,1000000007));
    }
}