public class DisjointSets
{
	int P[];
	int rank[];
	
	public int findset(int x)
	{
		if(x!=P[x]) return findset(P[x]);
		else return P[x];
	}
	public void createset(int x)
	{
		P=new int[x+1];
		for(int i=1;i<=x;i++) P[i]=i;
		rank=new int[x+1];
		for(int i=1;i<=x;i++) rank[i]=0;
	}
	public void mergeset(int x,int y)
	{
		if(x>y) mergeset(y,x);
		else
		{
			int px=findset(x);
			int py=findset(y);
			if(rank[px]>rank[py]) P[py]=px;
			else P[py]=P[px];
			if(rank[py]==rank[px]) rank[py]++;
		}
	}
	public DisjointSets()
	{
		createset(6);
		mergeset(1,2);
		mergeset(2,3);
		mergeset(4,5);
		mergeset(5,6);
		mergeset(3,4);
		for(int i=1;i<=6;i++) System.out.print(rank[i]+" ");
	}
	public static void main(String args[])
	{
		new DisjointSets();
	}
}