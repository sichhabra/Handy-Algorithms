import java.io.*;
public class SudokuSolver
{
	int N=3;
	int model[][]=new int[N*N][N*N];
	
	public boolean checkRow(int row,int num)
	{
		for(int col=0;col<(N*N);col++)
			if(model[row][col]==num) return false;
		return true;
	}
	public boolean checkCol(int col,int num)
	{
		for(int row=0;row<(N*N);row++)
			if(model[row][col]==num) return false;
		return true;
	}
	public boolean checkBox(int row,int col,int num)
	{
		row=(row/N)*N;
		col=(col/N)*N;
		for(int r=0;r<N;r++)
			for(int c=0;c<N;c++)
				if(model[row+r][col+c]==num) return false;
		return true;
	}
	public void next(int row,int col)
	{
		if(col<(N*N-1)) {solve(row,col+1);}
		else {solve(row+1,0);}
	}
	public void print(int model[][])
	{
		int m=model.length;
		int n=model[0].length;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++) System.out.print(model[i][j]+" ");
			System.out.println();
		}
	}
	public void solve(int row,int col)
	{
		if(row<(N*N-1))
		{
		if(model[row][col]!=0) next(row,col);
		else
		{
			for(int num=1;num<(N*N+1);num++)
			{
				if(checkRow(row,num)&&checkCol(col,num)&&checkBox(row,col,num))
				{
					model[row][col]=num;
					next(row,col);
				}
			}
			next(row,col);
		}
		}
		else {print(model);}
	}
    public SudokuSolver() throws Exception
    {
    	model[0][1]=1;
    	model[1][3]=4;
		model[2][2]=1;
		model[3][0]=3;
      	solve(0,0);
    }
    public static void main(String args[]) throws Exception
    {
    	new SudokuSolver();
    }
}