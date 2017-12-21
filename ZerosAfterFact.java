public class ZerosAfterFact
{
	static int count=0;
    public ZerosAfterFact(int num)
    {
    	for(int i=5;num/i>0;i*=5) count+=num/i;
    }
    public static void main(String args[])
    {
    	new ZerosAfterFact(26);
    	System.out.println(count);
    }
}