public class BinaryIndexedTree
{
	int arr[]={1,2,3,4,5,6,7,8};
	int tree[]=new int[arr.length];
	
    public BinaryIndexedTree()
    {
  		for(int i=1;i<=arr.length;i++)
  		{
  			int idx=i;
  			do{
                tree[idx-1] += arr[i-1];
                idx += (idx & -idx);
            }while (idx <= arr.length && idx>0);
  		}
  		System.out.println(readSingle(6));
    }
    public int read(int idx)
    {
        int sum = 0;
        while (idx > 0)
        {
            sum = sum + tree[idx-1];
            idx = idx - (idx & -idx);
        }
        return sum;
    }
    void update(int idx,int val)
    {
    	while(idx<=arr.length)
    	{
    		tree[idx]+=val;
    		idx+=(idx & (-idx));
    	}
    }
    int readSingle(int idx)
    {
    	int sum=tree[idx];
    	if(idx>0)
    	{
    		int z=idx-(idx & (-idx));
    		idx--;
    		while(idx!=z)
    		{
    			sum-=tree[idx];
    			idx-=(idx & (~idx));
    		}
    	}
    	return sum;
    }
    public void print(int arr[])
    {
    	for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    	System.out.println();
    }
    public static void main(String args[])
    {
    	new BinaryIndexedTree();
    }
}