public class Matrix
{
	public int[][] add(int a[][],int b[][],int m,int n)
	{
		int c[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				c[i][j]=a[i][j]+b[i][j];
		return c;
	}
	public int[][] subtract(int a[][],int b[][],int m,int n)
	{
		int c[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				c[i][j]=a[i][j]-b[i][j];
		return c;
	}
	public int[][] multiply(int a[][],int b[][],int m,int o,int n)
	{
		int c[][]=new int[m][n];
		int answer=0;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				answer=0;
				for(int k=0;k<o;k++)
				{
					answer+=a[i][k]*b[k][j];
				}
				c[i][j]=answer;
			}
		return c;
	}
	public static int[][] transpose(int[][] A,int m,int n)
	{
        int[][] C = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[j][i] = A[i][j];
        return C;
    }
    public int determinant(int[][] arr)
    {
        int result = 0;
        if (arr.length == 1)
        {
              result = arr[0][0];
              return result;
        }
        if (arr.length == 2)
       	{
               result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
               return result;
        }
       	for (int i = 0; i < arr[0].length; i++)
       	{
           	   int temp[][] = new int[arr.length - 1][arr[0].length - 1];

               for (int j = 1; j < arr.length; j++)
               {
                   for (int k = 0; k < arr[0].length; k++)
                   {

                   		if (k < i) temp[j - 1][k] = arr[j][k];
                   		else if (k > i) temp[j - 1][k - 1] = arr[j][k];
                   }
                }
                        result += arr[0][i] * Math.pow(-1, (int) i) * determinant(temp);
         }
         return result;
       }

	public Matrix()
	{
		int arr[][]={{2,0,0},{0,2,0},{0,0,2}};
		System.out.print(determinant(arr));
	}
	public static void main(String args[])
	{
		new Matrix();
	}
}