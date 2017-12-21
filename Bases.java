public class Bases
{
	public int java2decimal(int n,int b)
	{
		return Integer.parseInt(""+n,b);
	}
	public int fromDecimal(int n,int b)
	{
		int result=0;
		int multiplier=1;
		while(n>0)
		{
			result+=(n%10)*multiplier;
			multiplier*=b;
			n/=b;
		}
		return result;
	}
	public int fromDecimal2(int n,int b)
	{
		String chars="0123456789ABCDEFGHIJ";
		String result="";
		
		while(n>0)
		{
			result=chars.charAt(n%b)+result;
			n/=b;
		}
		return result;
	}
	//Integer.toBinaryString(n);//same Octal and Hex
	public static void main(String args[])
	{
		
	}
}