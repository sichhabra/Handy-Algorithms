public class Factorization
{
    public static void main(String args[])
    {
    	int num=285696;
    	for(int j=1;j<=(int)Math.sqrt(num);j++)
    	{
    		if(num%j==0)
    		{
    			System.out.println(j);
    			int temp=num/j;
    			if(temp!=j) System.out.println(temp);
    		}
    	}
    }
}