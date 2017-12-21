public class Lines
{
	public double[] lineFromPoints(int x1,int y1,int x2,int y2)	//of form Ax+By=C
	{
		double A=y2-y1;
		double B=x1-x2;
		double C=A*x1+B*y1;
		return new double[]{A,B,C};
	}
	public double[] pointOfIntersection(double A1,double B1,double C1,double A2,double B2,double C2)
	{
		double det=A1*B2-A2*B1;
		if(det==0) {return new double[]{1/0,1/0};}
		double x=(B2*C1-B1*C2)/det;
		double y=(A1*C2-A2*C1)/det;
		return new double[]{x,y};
	}
	public double[] circleFrom3Points(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		double line1[]=lineFromPoints(x1,y1,x2,y2);
		double line2[]=lineFromPoints(x2,y2,x3,y3);
		double midx1=(x1+x2)/2;
		double midy1=(y1+y2)/2;
		double D=line1[0]*midy1-line1[1]*midx1;
		double A=-line1[1];
		double B=line1[0];
		line1=new double[]{A,B,D};
		double midx2=(x2+x3)/2;
		double midy2=(y2+y3)/2;
		D=line2[0]*midy2-line2[1]*midx2;
		A=-line2[1];
		B=line2[0];
		line2=new double[]{A,B,D};
		double center[]=pointOfIntersection(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2]);
		double radius=(y1-center[1])*(y1-center[1])+(x1-center[0])*(x1-center[0]);
		return new double[]{center[0],center[1],radius};
	}
	public double[] reflectedPoint(int x1,int y1,double A,double B,double C)
	{
		double D=A*y1-B*x1;
		double Y[]=pointOfIntersection(A,B,C,-B,A,D);
		double x2=2*Y[1]-x1;
		double y2=2*Y[0]-y1;
		return new double[]{x2,y2};
	}
	public double[] rotatePoint(int x1,int y1,double theeta)	//counter-clockwise by theeta degrees
	{
		double x=x1*Math.cos(theeta)-y1*Math.sin(theeta);
		double y=x1*Math.sin(theeta)+y1*Math.cos(theeta);
		return new double[]{x,y};
	}
	
	public Lines()
	{
		double ans[]=circleFrom3Points(-1,0,0,1,1,0);
		System.out.println(ans[0]+":"+ans[1]+":"+ans[2]);
	}
	public static void main(String args[])
	{
		new Lines();
	}
}