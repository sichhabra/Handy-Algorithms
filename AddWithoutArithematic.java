public class AddWithoutArithematic
{
    public AddWithoutArithematic()
    {
    	System.out.println(add_bit(13,21));
    }
    public int add_bit(int a,int b)
    {
    	if(b==0) return a;
    	int c=a^b;
    	int d=(a&b)<<1;
    	return add_bit(c,d);
    }
    public static void main(String args[])
    {
    	new AddWithoutArithematic();
    }
}