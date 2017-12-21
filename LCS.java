public class LCS {

	String x="haelo";
	String y="hell";
	
	int c[][];
	int b[][];
	
    public LCS() {
    	
    	int m=x.length();
    	int n=y.length();
    	
    	c=new int[m+1][n+1];
    	b=new int[m][n];
    	
    	for(int i=1;i<=m;i++)
    	{
    		for(int j=1;j<=n;j++)
    		{
    			if(x.charAt(i-1)==y.charAt(j-1))
    			{
    				c[i][j]=c[i-1][j-1]+1;
    				b[i-1][j-1]=0;
    			}
    			else if(c[i-1][j]>=c[i][j-1])
    			{
    				c[i][j]=c[i-1][j];
    				b[i-1][j-1]=1;
    			}
    			else
    			{
    				c[i][j]=c[i][j-1];
    				b[i-1][j-1]=2;
    			}
    		}
    	}
    	print(b,x,x.length(),y.length());
    }
    
    void print(int b[][],String x,int i,int j)
    {
    	if(i==0||j==0)
    	{
    		return;
    	}
    	else
    	{
    		if(b[i-1][j-1]==0) {print(b,x,i-1,j-1);System.out.print(x.charAt(i-1));}
    		else if(b[i-1][j-1]==1) print(b,x,i-1,j);
    		else print(b,x,i,j-1);	
    	}
    }
    
    public static void main(String args[])
    {
    	new LCS();
    }
}