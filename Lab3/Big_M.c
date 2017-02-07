#include <stdio.h>

int pivotcol;
int pivotrow;
int count=0,k=0;
int x[20][2]={0};

void pivot(int n,float a[][n+1],int m){
	int i,j;
	float min,least;
	least = a[m][0];
	pivotrow=0;
	pivotcol=0;
	for(i=0;i<n;i++)
	{
		if(a[m][i]<least){
			least = a[m][i];
			pivotcol = i;
		}
	}
	min = 500000;
	for(i=0;i<m;i++)
	{
		if(((a[i][n] / a[i][pivotcol]) < min) && (a[i][n] / a[i][pivotcol]) > 0)
		{
			min = (a[i][n] / a[i][pivotcol]);
			pivotrow = i;
		}
	}
	printf("\npivot row=%d\n",pivotrow);
	printf("pivot col = %d\n",pivotcol);

}

void table(int n,int m,float a[m+1][n+1],int num){
	int i,j;
	printf("\nTable after iteration number %d is",count++);
	for(i=0;i<m+1;i++)
	{
		printf("\n");
		for(j=0;j<n+1;j++)
		{
			printf("%f ",a[i][j]);
		}
	}


	for(i=0;i<n;i++){
		if(a[m][i]<=0)
			break;
		if(i==n-1){
			printf("\nOptimal Solution\n");
			if(num==1){
			printf("optimal value is %f\n",a[m][n] );}
			else{printf("optimal value is %f\n",-a[m][n] );}
			for(j=0;j<n;j++)
			{
				printf("x%d = %f ,",x[j][1]+1,a[x[j][0]][n]);
			}
			return;
		}
	}
	pivot(n,a,m);
	if(a[m][pivotcol]==0)
    {
        printf("Optimal Solution. Alternate Solution exists.\n");
        if(num==1){
			printf("optimal value is %f\n",a[m][n] );}
        else{printf("optimal value is %f\n",-a[m][n] );}
        for(j=0;j<m;j++)
        {
				printf("x%d=%lf ,",x[j][1]+1,a[x[j][0]][n]);
        }
        return;

    }
	x[k][0] = pivotrow;
	x[k++][1] = pivotcol;
	for(i=0;i<m;i++){
		if(a[i][pivotcol]>0)
			break;
		if(i==m-1)
		{
			printf("Solution is unbounded\n");
			return;
		}
	}

	for(i=0;i<m+1;i++)
	{
		for(j=0;j<n+1;j++)
		{
			if(j!= pivotcol && i!=pivotrow)
			{
				a[i][j]= (a[pivotrow][pivotcol]*a[i][j]-a[i][pivotcol]*a[pivotrow][j])/(a[pivotrow][pivotcol]);
			}
		}
	}
	for(i=0;i<n+1;i++)
	{
		if(i!=pivotcol){
			a[pivotrow][i]=a[pivotrow][i]/a[pivotrow][pivotcol];
		}
	}
	for(i=0;i<m+1;i++)
	{
		if(i!=pivotrow){
			a[i][pivotcol] = -a[i][pivotcol]/a[pivotrow][pivotcol];
		}
	}
	a[pivotrow][pivotcol]=1/a[pivotrow][pivotcol];
	table(n,m,a,num);

}



void main(){
			int m,n,i,u,j,num;
			printf("Enter the number of unknowns\n");
			scanf("%d",&n);
			printf("Enter the number of constraints\n");
			scanf("%d",&m);
			printf("Enter the number of greater than equal to constraints\n");
			scanf("%d",&u);
			float a[m+1][n+u+1];
			for(i=0;i<m+1;i++)
			{
			    for(j=0;j<n+u+1;j++)
			    {
			        a[i][j]=0;
			    }
			}
			for(i=0;i<u;i++){
				printf("Enter the coefficients of greater than or equal to constraint number %d\n",i+1);
				for(j=0;j<n;j++){
					scanf("%f",&a[i][j]);
				}
				scanf("%f",&a[i][n+u]);
			}
			for(i=u;i<m;i++){
				printf("Enter the coefficients of constraint %d in a1x1+a2x2+....+anxn=d form:\n",i+1);
				for(j=0;j<n;j++){
					scanf("%f",&a[i][j]);
				}
				scanf("%f",&a[i][n+u]);
			}
			j = n;
			for(i=0;i<u;i++){
				a[i][j++] = -1;
			}
			int M = 100000;

			printf("Enter the type of problem 1:Maximization 2:Minimization\n");
			scanf("%d",&num);
			printf("Enter the coefficients of objective function\n");
			for(i=0;i<n;i++)
				{
				scanf("%f",&a[m][i]);
			}

			if(num==1){
			for(i=0;i<n;i++)
				{
					a[m][i]= - a[m][i];
				}
			}
			
			if(u>0){
			for(i=0;i<n+u;i++)
			{
				for(j=0;j<m;j++)
				{
					a[m][i] = a[m][i]-M*a[j][i];
				}
			}
			for(i=0;i<m;i++)
			{
			a[m][n+u]=a[m][n+u]-M*a[i][n+u];
		    }
			}
			else{a[m][n]=0;}
			table(n+u,m,a,num);
		}





