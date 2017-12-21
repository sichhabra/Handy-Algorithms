public class Vectors
{
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
	int cross(int A[],int B[],int C[])	//ABxBC
	{
		int AB[]=new int[2];
		int BC[]=new int[2];
		AB[0]=B[0]-A[0];
		AB[1]=B[1]-A[1];
		BC[0]=C[0]-B[0];
		BC[1]=C[1]-B[1];
		return (AB[0]*BC[1]-AB[1]*BC[0]);
	}
	double dist(int A[],int B[])	//AB length
	{
		int d1=A[0]-B[0];
		int d2=A[1]-B[1];
		return Math.sqrt(d1*d1+d2*d2);
	}
	double linePointDistance(int A[],int B[],int C[],boolean isSegment)	//distance of C from AB.
	{
		double dist=cross(A,B,C)/dist(A,B);
		if(isSegment)
		{
			int dot1=dot(A,B,C);
			if(dot1>0) return dist(B,C);
			int dot2=dot(B,A,C);
			if(dot2>0) return dist(A,C);
		}
		return Math.abs(dist);
	}
	double area(int p[][])
	{
		double area=0;
		int n=p.length;
		for(int i=1;i+1<n;i++)
		{
			int x1=p[i][0]-p[0][0];
			int y1=p[i][1]-p[0][1];
			int x2=p[i+1][0]-p[0][0];
			int y2=p[i+1][1]-p[0][1];
			int cross=x1*y2-y1*x2;
			area+=cross;
		}
		return Math.abs(area/2.0);
	}
	public Vectors()
	{
		int p[][]=new int[3][2];
		p[0][0]=0;p[0][1]=0;
		p[1][0]=0;p[1][1]=1;
		p[2][0]=1;p[2][1]=1;
		System.out.print(area(p));
	}
	public static void main(String args[])
	{
		new Vectors();
	}
}