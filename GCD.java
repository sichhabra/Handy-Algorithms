public class GCD
{
	public static int gcd(int a,int b)
	{
		if(b==0) return a;
		return gcd(b,a%b);
	}
	public int lcm(int a,int b)
	{
		return a*b/gcd(a,b);
	}
	public static void main(String args[])
	{
		System.out.println(gcd(75180032,3276800));
		//31/9
	}
}