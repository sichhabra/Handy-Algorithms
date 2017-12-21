int v[],w[],n;
	public void quicksort(int l,int h)
	{
		int i=l,j=h;
		int ind=l+(h-l)/2;
		int p=w[ind]/v[ind];
		while(i<=j)
		{
			while(w[i]/v[i]<p) i++;
			while(w[j]/v[j]>p) j--;
			if(i<=j)
			{
				int temp=w[i];
				w[i]=w[j];
				w[j]=temp;
				temp=v[i];
				v[i]=v[j];
				v[j]=temp;
				i++;
				j--;
			}
		}
		if(l<j) quicksort(l,j);
		if(i<h) quicksort(i,h);
	}