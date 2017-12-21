public class Count2s
{
    public Count2s()
    {
    	System.out.println(count(579));
    }
    public int count(int n)
    {
    	if(n==0) return 0;
    	int power=1;
    	while(10*power<n) power*=10;
    	int first=n/power;
    	int rem=n%power;
    	
    	int f2=0;
    	if(first>2) f2+=power;
    	else if(first==2) f2+=(rem+1);
    	
    	int f22=first*count(power-1)+count(rem);
    	
    	return f2+f22;
    }
    public static void main(String args[])
    {
    	new Count2s();
    }
}