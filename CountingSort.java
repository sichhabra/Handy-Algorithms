public class CountingSort
{
	int range=256;
	int arr[];
	
    public CountingSort(String str)
    {
    	arr=new int[range];
    	for(int i=0;i<str.length();i++) arr[str.charAt(i)]++;
    	for(int i=1;i<range;i++) arr[i]+=arr[i-1];
    	char output[]=new char[str.length()];
    	for(int i=0;i<str.length();i++)
    	{
    		output[arr[str.charAt(i)]-1]=str.charAt(i);
    		arr[str.charAt(i)]--;
    	}
    	System.out.println(new String(output));
    }
    public static void main(String args[])
    {
    	new CountingSort("Hello world!");
    }
}