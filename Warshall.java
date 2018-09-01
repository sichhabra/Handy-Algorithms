class Warshall {
	int D[][][];
	public int[][] warshall(int N)
	{
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					D[k][i][j]=Math.min(D[k-1][i][j],D[k-1][i][k]+D[k-1][k][j]);
		return D[N];
	}

	static void matrixOutput (int [ ] [ ] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) 
				System.out.print(" " + a[i][j]);
			System.out.println(" ");
		}
	}
}
