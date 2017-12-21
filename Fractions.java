public class Fractions
{
	public int[] multiply(int a[],int b[])
	{
		int c[]={a[0]*b[0],a[1]*b[1]};
		return c;
	}
	public int[] add(int a[],int b[])
	{
		GCD g=new GCD();
		int denom=g.lcm(a[1],b[1]);
		int c[]={denom/a[1]*a[0]+denom/b[1]*b[0],denom};
		return c;
	}
	public int[] subtract(int a[],int b[])
	{
		GCD g=new GCD();
		int denom=g.lcm(a[1],b[1]);
		int c[]={denom/a[1]*a[0]-denom/b[1]*b[0],denom};
		return c;
	}
	public int[] reduce(int a[])
	{
		GCD g=new GCD();
		int b=g.gcd(a[0],a[1]);
		int c[]={a[0]/b,a[1]/b};
		return c;
	}
	public static void main(String args[])
	{
		
	}
}