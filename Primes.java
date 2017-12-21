public class Primes
{
	//check prime
	public static boolean isPrime(int n)
	{
		if(n<=1) return false;
		if(n==2) return true;
		if(n%2==0) return false;
		int m=(int)Math.sqrt(n);
		for(int i=3;i<=m;i+=2)
		{
			if(n%i==0) return false;
		}
		return true;
	}
	//sieve if to be called again and again find a prime and make all its multiples false.
	public static boolean[] sieve(int n)
	{
		boolean prime[]=new boolean[n+1];
		java.util.Arrays.fill(prime,true);
		prime[0]=false;
		prime[1]=false;
		int m=(int)Math.sqrt(n);
		for(int i=2;i<=m;i++)
		{
			if(prime[i])
			{
				for(int k=i*i;k<=n;k+=i) prime[k]=false;
			}
		}
		return prime;
	}
	public static void main(String args[])
	{
		for(int i=1;i<=100;i++)
		if(isPrime(i)) System.out.println(i);
	}
}