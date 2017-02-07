//				Lab3 Question

#include <iostream>
#include <iomanip> 
#include <vector>

using namespace std;

int min_index(float *lastrow, int length)
{
	int index=0;
	for (int i=1; i<length; i++)
	{
		if (lastrow[i]<lastrow[index])
			index=i;
	}
	if (lastrow[index]>=0)
		return -1;
	else
		return index;
}

int min_col_index(float *temp, int length)
{
	int index=0;
	for (int i=1; i<length; i++)
	{
		if (temp[i]<temp[index])
			index=i;
	}
	return index;
}

void print(int n, int m, float **A)
{
	int i, j;
	cout<<"----------------"<<endl;
	for (i=0; i<m; i++){
		for (j=0; j<(n); j++)
			cout<<setw(10)<<setprecision(5)<<A[i][j];
		cout<<endl;
	}
	// cout<<"----------------"<<endl;
}

void simplex(float **activeA, int n, int m, int *index)
{
	float lastrow[n+1], *temp;
	int i, j, pivot_col=0, pivot_row, count;
	bool stop=true, unbounded=false;

	for (i=0; i<n; i++)
	{
		if (activeA[m][i]<=0)
			stop=false;

	}

	if (stop==true){
		cout<<endl<<"Optimal Solution is "<<activeA[m][n]<<endl;
		float *sol_;
		sol_ = new float [m];
		for (i=0; i<m; i++)
		{
			if (index[i]>=0)
				sol_[index[i]]=activeA[i][n];
		}
		for (i=0; i<m; i++)
		{
			cout<<"x"<<i+1<<" is "<<sol_[i]<<endl;
		}
		return;
	}

	pivot_col=min_index(activeA[m], n+1);

	//If the last element corresponding to pivot choosen pivot col is zero, Alternate solution exists.
	if (activeA[m][pivot_col]==0)
	{
		cout<<endl<<"Alternate Solution Exists. Optimal Solution is "<<activeA[m][n]<<endl;
		float *sol_;
		sol_ = new float [m];
		for (i=0; i<m; i++)
		{
			if (index[i]>=0)
				sol_[index[i]]=activeA[i][n];
		}
		for (i=0; i<m; i++)
		{
			cout<<"x"<<i+1<<" is "<<sol_[i]<<endl;
		}
		return;
	}


	//Unboundedness Checking
	count=0;
	for (i=0; i<m; i++)
	{
		if (activeA[i][pivot_col]<=0)
			count++;
	}
	if (count==m){
		cout<<"Solution is Unbounded"<<endl;
		return;
	}

	//creating temp array for choosing pivot_row
	temp=new float [m];
	for (i=0; i<m; i++)
	{
		if (activeA[i][pivot_col]>0)
			temp[i]=activeA[i][n]/activeA[i][pivot_col];
		else
			temp[i]=1000000;
	}
	pivot_row=min_col_index(temp, m);
	cout<<"Row Column"<<pivot_row<<"  "<<pivot_col<<endl;

	index[pivot_row]=pivot_col;

	//make new table
	float pivot=activeA[pivot_row][pivot_col];
	for (i=0; i<=m; i++)
	{
		for(j=0; j<=n; j++)
		{
			if (i!= pivot_row && j!= pivot_col)
			{
				activeA[i][j]=(activeA[i][j]*activeA[pivot_row][pivot_col]-activeA[pivot_row][j]*activeA[i][pivot_col])/activeA[pivot_row][pivot_col];
			}
		}
	}

	for (i=0; i<=n; i++)
		activeA[pivot_row][i]=activeA[pivot_row][i]/pivot;

	for (i=0; i<=m; i++)
		activeA[i][pivot_col]=-activeA[i][pivot_col]/pivot;
	activeA[pivot_row][pivot_col]=1/pivot;
	
	print(n+1, m+1, activeA);


	simplex(activeA, n, m, index);

}


int main()
{
	int n, m, i, j, *sol_index;
	float **A, *b, **activeA, *z;

	cout<<"Enter No of Equations : ";
	cin>>m;

	cout<<"Enter No of Unknwons : ";
	cin>>n;

    A= new float* [m]; 
    activeA = new float* [m+1];

    for (i=0; i<m; i++){
        A[i]= new float [n];
        activeA[i]= new float [n+1];
    }
    activeA[m]= new float [n+1];

    // arr = new int [n];

	cout<<"Enter the matrix A : \n";
	for (i=0; i<m; i++){
		for (j=0; j<n; j++){
			cin>>A[i][j];
			activeA[i][j]=A[i][j];
		}
	}

	cout<<"Enter the column vector 'b' : \n";
    b=new float [m];
	for (i=0; i<m; i++){
		cin>>b[i];
		activeA[i][n]=b[i];
	}

	cout<<"Enter the objective function z :\n";
	z=new float [n];
	for (i=0; i<n; i++){
		cin>>z[i];
		activeA[m][i]=-z[i];
	}


	print(n+1, m+1, activeA);
	sol_index = new int[m];

	for (i=0; i<m; i++)
		sol_index[i]=-1;

	simplex(activeA, n, m, sol_index);

	return 0;


}
