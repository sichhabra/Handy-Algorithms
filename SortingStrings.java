import java.util.*;
public class SortingStrings
{
	class StringComparator implements Comparator<String>
	{
		public String sortChars(String s)
		{
			char temp[]=s.toCharArray();
			Arrays.sort(temp);
			return new String(temp);
		}
		public int compare(String s1,String s2)
		{
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
    public SortingStrings()
    {
    	String array[]={"a","c","b"};
    	Arrays.sort(array,new StringComparator());
    	System.out.println(Arrays.toString(array));
    }
    public static void main(String args[])
    {
    	new SortingStrings();
    }
}