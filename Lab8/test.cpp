#include <iostream>
#include <iomanip> 
using namespace std;
void print(int n, int m, int A[][2])
{
	int i, j;
	cout<<"----------------"<<endl;
	for (i=0; i<m; i++){
		for (j=0; j<(n); j++)
			cout<<setw(10)<<setprecision(5)<<A[i][j];
		cout<<endl;
	}
	A[0][0]=100;
	// cout<<"----------------"<<endl;
}


int main()
{
	int array[2][2];
	array[0][0]=1;
	array[0][1]=2;
	array[1][0]=3;
	array[1][1]=4;

	
	print(2, 2, array);
	cout<<array[0][0];

}