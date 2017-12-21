public class SearchSortedMatrix
{
	class Index
	{
		int x,y;
		public Index(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public Index find(int arr[][],int no,int N,int M)
	{
		int row=0;
		int col=N-1;
		while(row<M&&col>=0)
		{
			if(arr[row][col]==no) return (new Index(row,col));
			else if(arr[row][col]>no) col--;
			else row++;
		}
		return (new Index(-1,-1));
	}
    public SearchSortedMatrix()
    {
    	int arr[][]={{1,2,4},{2,3,5},{3,4,6}};
    	Index in=find(arr,11,3,3);
    	if(in.x==-1||in.y==-1) System.out.println("Element not found!");
    	else System.out.println(in.x+":"+in.y);
    }
   	public static void main(String args[])
   	{
   		new SearchSortedMatrix();
   	}
}