public class RandomMN
{
    public RandomMN()
    {
    	int arr[]={3,1,2,5,6,8,7,4,5,6,7,8,9};
    	int sub[]=pick(arr,4);
    	print(sub);
    }
    public void print(int arr[])
    {
    	for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    	System.out.println();
    }
    public int rand(int low,int high)
    {
    	return low+(int)(Math.random()*(high-low+1));
    }
    public int[] pick(int original[],int m)
    {
    	int subset[]=new int[m];
    	int arr[]=original.clone();
    	for(int j=0;j<m;j++)
    	{
    		int index=rand(j,arr.length-1);
    		subset[j]=arr[index];
    		arr[index]=arr[j];
    	}
    	return subset;
    }
    public static void main(String args[])
    {
    	new RandomMN();
    }
}