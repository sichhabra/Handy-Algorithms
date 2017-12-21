public class ExtendedEuclid
{
    public ExtendedEuclid()
    {
    	long a=120,b=23;
    	long x=0,y=1,lx=1,ly=0,temp;
    	while(b!=0)
    	{
    		long q=a/b;
    		long r=a%b;
    		a=b;
    		b=r;
    		temp=x;
    		x=lx-q*x;
    		lx=temp;
    		temp=y;
    		y=ly-q*y;
    		ly=temp;
    	}
    	System.out.println(lx+":"+ly);
    }
    public static void main(String args[])
    {
    	new ExtendedEuclid();
    }
}