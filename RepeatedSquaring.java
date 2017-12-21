public class RepeatedSquaring
{
	public int modexp(int a,int b,int n)
	{
		if(b==0) return 1;
		long t=modexp(a,b/2,n);
		long c=(t*t)%n;
		if(b%2==1) c=(c*a)%n;
		return (int)c;
	}
    public RepeatedSquaring()
    {
    	System.out.println(modexp(2,3,9));
    }
    public static void main(String args[])
    {
    	new RepeatedSquaring();
    }
}