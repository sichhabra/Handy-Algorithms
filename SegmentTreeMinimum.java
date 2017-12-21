import java.util.*;
public class SegmentTreeMinimum
{
	int arr[]={4,1,2,3,4};
	int n=arr.length;
	int base;
	int seg[];
	
	public int construct(int i,int j,int index)
	{
		if(i==j) return seg[index];
		else
		{
			int mid=(i+j)/2;
			seg[index]=Math.min(construct(i,mid,2*index+1),construct(mid+1,j,2*index+2));
			return seg[index];
		}
	}
	
	public int range(int si,int sj,int qi,int qj,int index)
	{
		if(qi<=si&&qj>=sj) return seg[index];
		else if(si>qj||sj<qi) return Integer.MAX_VALUE; 
		else
		{
			int mid=(si+sj)/2;
			return Math.min(range(si,mid,qi,qj,2*index+1),range(mid+1,sj,qi,qj,2*index+2));
		}
	}
	
	public void update(int ind,int value)
	{
		arr[ind]=value;
		int x=ind+base;
		seg[x]=value;
		x>>=1;
		while(x>0)
		{
			seg[x]=Math.min(seg[2*x+1],seg[2*x+2]);
			x>>=1;
		}
	}
	
    public SegmentTreeMinimum()
    {
    	double log2=Math.log(2);
    	int size=(int)Math.ceil(Math.log(n)/log2);
    	size=1<<size;
    	seg=new int[size<<1];
    	Arrays.fill(seg,(int)(1e9+1));
    	base=size-1;
    	int limit=base+n;
    	for(int i=base;i<limit;i++) seg[i]=arr[i-base];
    	construct(0,base,0);
    	for(int i=0;i<n;i++)
	    		for(int j=i;j<n;j++) System.out.println(i+":"+j+":"+range(0,n-1,i,j,0));
    }
    public static void main(String args[])
    {
    	new SegmentTreeMinimum();
    }
}