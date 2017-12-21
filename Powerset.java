import java.util.*;
public class Powerset
{
    static ArrayList<Boolean[]>  getSubsets(int set[],int sum,int p[],int q[])
    {
    	ArrayList<Boolean[]> list=new ArrayList<Boolean[]>();
	    int len=set.length;
	    float ans=0.000000F;
	    int max = 1 << len;
	    for (int i = 0; i < max; i++)
	    {
		    Boolean subset[]=new Boolean[len];
		    int k = i;
		    int index = 0;
		    int getsum=0;
		    while (k > 0)
		    {
			    if ((k & 1) > 0) {subset[index]=true;getsum+=set[index];}
			    k >>= 1;
			    index++;
		    }
		    list.add(subset);
	    }
    	return list;
    }
    public static void main(String args[]) throws Exception
    {
    
    }
} 