public class LCA
{
	int T[]={0,0,0,0,2,2,2,5,5,6,6,9,9};
	int L[]={0,1,1,1,2,2,2,3,3,3,3,4,4};
	int N=T.length;
	int P[][]=new int[N][(int)(Math.log10(N)/(double)Math.log10(2)+1)];
	
	public void preprocess()
	{
		for(int i=0;i<N;i++)
			for(int j=0;1<<j<N;j++) P[i][j]=-1;
		
		for(int i=0;i<N;i++) P[i][0]=T[i];
		
		for(int j=1;1<<j<N;j++)
			for(int i=0;i<N;i++) P[i][j]=P[P[i][j-1]][j-1];
	}
	public void print()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;1<<j<N;j++) System.out.print(P[i][j]+" ");
			System.out.println();
		}
	}
	public int query(int p,int q)
	{
		if(L[p]<L[q]){ int temp=p;p=q;q=temp;}
		int log;
		for(log=1;1<<log<=L[p];log++); log--;
		for(int i=log;i>=0;i--)
			if(L[p]-(1<<i)>=L[q]) p=P[p][i];
		if(p==q) return p;
		for(int i=log;i>=0;i--)
			if(P[p][i]!=-1&&P[p][i]!=P[q][i]) {p=P[p][i];q=P[q][i];}
		return T[p];
	}
    public LCA()
    {
    	preprocess();
    	System.out.println(query(0,12));
    }
    public static void main(String args[])
    {
    	new LCA();
    }
}