import java.util.*;
public class StringPermutations
{
	public void print(String pre,String str)
	{
		if(str.length()<=1) System.out.println(pre+str);
		else
		{
			for(int i=0;i<str.length();i++) print(pre+""+str.charAt(i),str.substring(0,i)+str.substring(i+1));
		}
	}
    public StringPermutations()
    {
    	String str="SID";
    	char temp[]=str.toCharArray();
    	Arrays.sort(temp);
    	int left=0;
    	int right=temp.length-1;
    	print("",new String(temp));
    }
    public static void main(String args[])
    {
    	new StringPermutations();
    }
}