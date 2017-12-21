public class ConvexHull
{
	int cross(int A[],int B[],int C[])	//ABxAC
	{
		int AB[]=new int[2];
		int AC[]=new int[2];
		AB[0]=B[0]-A[0];
		AB[1]=B[1]-A[1];
		AC[0]=C[0]-A[0];
		AC[1]=C[1]-A[1];
		return (AB[0]*AC[1]-AB[1]*AC[0]);
	}
	double dist(int A[],int B[])	//AB length
	{
		int d1=A[0]-B[0];
		int d2=A[1]-B[1];
		return Math.sqrt(d1*d1+d2*d2);
	}
	int dot(int A[],int B[],int C[])	//AB.BC
	{
		int AB[]=new int[2];
		int BC[]=new int[2];
		AB[0]=B[0]-A[0];
		AB[1]=B[1]-A[1];
		BC[0]=C[0]-B[0];
		BC[1]=C[1]-B[1];
		return (AB[0]*BC[0]+AB[1]*BC[1]);
	}
	public void convexHull(int X[][],boolean onEdge)
	{
		int N=X.length;
		int p=0;
		boolean used[]=new boolean[N];
		for(int i=1;i<N;i++)
		{
			if(X[i][0]<X[p][0]) p=i;
			else if(X[i][0]==X[p][0]&&X[i][1]>X[p][1]) p=i;
		}
		int start=p;
		System.out.println(X[p][0]+":"+X[p][1]);
		do
		{
			int n=-1;
			int dist=onEdge?Integer.MAX_VALUE:0;
			for(int i=0;i<N;i++)
			{
				if(i==p) continue;
				if(used[i]) continue;
				if(n==-1) {n=i;}
				int cross=cross(X[p],X[i],X[n]);
				int d=(int)dist(X[p],X[i]);
				if(cross<0)
				{
					n=i;
					dist=d;
					System.out.println(X[i][0]+":"+X[i][1]);
				}
				else if(cross==0)
				{
					if(onEdge&&dist>d)
					{
						n=i;
						dist=d;
					}
					else if(!onEdge&&dist<d)
					{
						n=i;
						dist=d;
					}
				}
			}
			p=n;
			used[p]=true;
		}
		while(start!=p);
	}
	public ConvexHull()
	{
		int p[][]=new int[5][2];
		p[0][0]=0;p[0][1]=0;
		p[1][0]=2;p[1][1]=0;
		p[2][0]=2;p[2][1]=2;
		p[3][0]=0;p[3][1]=2;
		p[4][0]=1;p[4][1]=1;
		convexHull(p,true);
	}
	public static void main(String args[])
	{
		new ConvexHull();
	}
}