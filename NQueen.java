public class NQueen {
	
	int x[];
	int n=7;

    public NQueen() {
    	
    	x=new int[n];
    	
    	nqueen(1);
    }
    
    public void nqueen(int r)
    {
    	if(r==n+1) print(x);
    	else
    	{
    		boolean legal;
    		for(int j=1;j<=n;j++)
    		{
    			legal=true;
    			for(int i=1;i<=r-1;i++)
    				if(x[i-1]==j||x[i-1]==j+r-i||x[i-1]==j-r+i) legal=false;
    				
    			if(legal)
    			{
    				x[r-1]=j;
    				nqueen(r+1);
    			}
    			else {System.out.print("-");}
    		}
    	}
    }
    
    public void print(int arr[])
    {
    	for(int i=0;i<arr.length;i++) System.out.print(" "+arr[i]);
    }
    
    public static void main(String args[])
    {
    	new NQueen();
    }
}