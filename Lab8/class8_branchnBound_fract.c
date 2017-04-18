//		LAB 8 :: BRANCH AND BOUND

#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#define BigM 10000.000
#define max 100000000.000
double ***Table_list,**main_array,*sol,*sols;
int MaxorMin,counter,*ms,*ns;
int wxyz=0;

double rnd(double tmp, double n)
{
    int i = 0;
    if(tmp<0) tmp = -1*tmp;
    if((int)tmp%(int)n >= 0.5*n)
        return ((int)tmp/(int)n +1)*n;
    else return ((int)tmp/(int)n)*n;
}

int Box(double x){
	int y = 0;
	// if((x - (int)x) <= 0.0001 && (x - (int)x) >= -0.0001){
	// 	return -1;
	// }
	if(x == (double)rnd(x,1))
		return -1;
	while(1){
		if(x < y)
			break;
		y++;
	}
	return y;
}



void printSol(int nonIndices[],int n,int m, double **main_array){
    int i,j;
    double soln[n];
    for(i=0 ; i<n ; i++)
        soln[i] = 0.0;
    for(i=0 ; i<m ; i++){
        for(j=0; j<m ; j++){
            if(main_array[i][nonIndices[j]]==1){
                soln[nonIndices[j]] = main_array[i][n];
            }
        }
    }
    for(i=0 ; i<n ; i++){
        printf("x%d = %lf 		",(i+1),soln[i]);
        sol[i] = soln[i];
    }
}

void printArray(int n,int m, double **main_array){
    int i,j;
    for(i=0 ; i<(m+1) ; i++){
        if(i==0){
            for(j=0 ; j<(n+1) ; j++)
                printf("********************");
            printf("\n");
        }
		for(j=0 ; j<(n+1) ; j++){

			printf("%lf 		",main_array[i][j] );
		}
		printf("\n");

	if(i==m){
            for(j=0 ; j<(n+1) ; j++)
                printf("********************");
            printf("\n");
        }
	}
}

int pivotcol(int indices[],int n,int m, double **main_array){
	int i,pivot=-1;
	double min=0.0;
	for(i=0 ; i<(n-m) ; i++){
		if(main_array[m][indices[i]] <= min && main_array[m][indices[i]]<0 ){
			pivot = indices[i];
			min = main_array[m][indices[i]];
		}
	}
	return pivot;
}

int pivotrow(int indices[], int n, int m, int col, double **main_array){
	int i,pivot=-1;
	double ratios[m],min;
	for (i = 0; i < m; i++){
		if(main_array[i][col]<=0)
			ratios[i]=-1;
		else
			ratios[i] = main_array[i][n]/main_array[i][col];
		if(main_array[i][n]==0){
			if(main_array[i][col]>0) ratios[i]=0;
			else ratios[i]=-1;
		}
	}
	min = max;
	for (i = 0; i < m; ++i){
		if(min >= ratios[i] && ratios[i]>=0.0){
            		pivot = i;
            		min = ratios[i];
		}
	}
	return pivot;
}

void SimplexMethod(int n,int m,double **main_array,int MaxorMin){
    wxyz++;
	int i,j,k,xyz,indices[n-m],nonIndices[m],p_r,p_c;
	int alter = 0;
	double pivot;
	for(i=0 ; i<(n-m) ; i++){
		indices[i] = i;
	}
	for (j = 0; j<(m); ++j)
	{
		nonIndices[j]=i;
		i++;
	}
	xyz = 1;
	p_c = pivotcol(indices,n,m,main_array);
	p_r = pivotrow(indices,n,m,p_c,main_array);
	while(1){
        if(p_c==(-1) || p_r==(-1)|| alter >= 1)
            break;
        if(main_array[m][p_c]==0){
            alter = alter + 1;
            printSol(nonIndices, n, m, main_array);
            printf("\n***Alternate Solution Exists****\n");
        }
        xyz++;
		pivot = main_array[p_r][p_c];
        // printf("\npivot column = %d pivot row = %d pivot = %lf\n",p_c,p_r,pivot);
		for(i=0 ; i<(n+1) ; i++){
			main_array[p_r][i] = main_array[p_r][i]/pivot;
		}
		for(i=0 ; i<(m+1) ; i++){
            double temp = main_array[i][p_c];
			for (j = 0; j<(n+1) ; ++j){
				if (i!=p_r){
					main_array[i][j] = main_array[i][j] - temp*main_array[p_r][j];
				}
			}
		}
		for(i=0 ; i<m ; i++){
			if(main_array[p_r][nonIndices[i]]!=0){
				for(j=0 ; j<(n-m) ; j++){
					if(p_c==indices[j]){
						indices[j] = nonIndices[i];
						nonIndices[i] = p_c;
					}
				}
			}
		}
		// printf("\nSimplex Tableau %d : \n",xyz);
		//printArray(n,m,main_array);
		p_c = pivotcol(indices,n,m,main_array);
        p_r = pivotrow(indices,n,m,p_c,main_array);
	}
	// printArray(n,m,main_array);
	// if(alter >=1) printf("\nThe Alternate Solution is : \n");
	printSol(nonIndices,n,m,main_array);
	// if(main_array[m][n] > max)
	// 	printf("\nThe System is unbounded here\n");
	// else
		printf("\n The Optimum value of the Objective function is : %lf\n",MaxorMin*main_array[m][n] );

}

void BigM_Method(double** main_array,int n_obj,int n_const,int n,int m,int l,int g,int e){
	int i,j;
	double temp=0.0;
	for(i=0 ; i<m ;i++){
			if(i<(g+e))
				temp = temp + main_array[i][n];
		}
	main_array[m][n] = -1*BigM*temp;
	for(i=0 ; i<g ; i++){
		for (j=0; j<m; j++){
			if (i==j){
				main_array[j][n_const+i] = -1;
				main_array[j][n_const+g+i] = 1;
			}
		}
		main_array[m][n_const+i] = BigM;
	}
	for(i=g ; i<(g+e); i++){
		for (j=0; j<m; j++){
			if (i==j){
				main_array[j][n_const+g+i] = 1;
			}
		}
	}
	for(i=(g+e) ; i<m; i++){
		for (j=0; j<m; j++){
			if (i==j){
				main_array[j][n_const+g+i] = 1;
			}
		}
	}
	for(i=0 ; i<n_obj ; i++){
		double temp = 0.0;
		for (j=0; j<(g+e); j++)
			temp= temp + main_array[j][i];
		main_array[m][i]= main_array[m][i]- temp*BigM;
	}
 //    printf("\nInitial Tableau is : \n");
	// printArray(n,m,main_array);
	for(i=0; i<(m+1) ; i++)
		for (j = 0; j < (n+1); j++)
			Table_list[counter][i][j] = main_array[i][j];
	ms[counter] = m; ns[counter] = n;
	counter++;
	SimplexMethod(n,m,main_array,MaxorMin);
}

void BranchNBound(double** array,double obj[], int n_obj,int n_const,int n,int m,int l,int g,int e){
    // if(wxyz>6) return;
	int i,j,k,y;
	double **array2;
	array2 = (double **)malloc((m+2)*sizeof(double));
	for(i=0;i<m+2;i++)
		array2[i] = (double *)malloc((n+2)*sizeof(double));
	for(i=0 ; i<(m+1) ; i++){
		for(j=0 ; j<(n+1) ; j++)
			array2[i][j] = array[i][j];
	}
	BigM_Method(array,n_obj,n_const,n,m,l,g,e);
	for(i=0 ; i<n_obj ; i++){
		if(Box(sol[i])!= -1)
			break;
	}
	// printf("\n%d 	%d \n",Box(sol[i]),i);
	// printf("\n %lf 		%lf \n",rnd(array[m][n],BigM),BigM );
	if(i==n_obj && rnd(array[m][n],BigM)<=BigM){
		// printf("%lf   	%lf\n",sols[n_obj],array[m][n] );
		if(sols[n_obj] <= array[m][n]){
			for(j = 0 ; j<n_obj ; j++){
				sols[j] = sol[j];
				// printf("%lf   	%lf\n",sols[j],sol[j] );
			}
			sols[n_obj] = array[m][n];
			// printf("%lf   	%lf\n",sols[n_obj],array[m][n] );
		}
        // printf("**********************YESS!!!*****************************\n");
        return;
	}
	else if(rnd(array[m][n],1000.000)>= 1000.000 ){
		// printf("***********UNBOUNDED************\n");
        return;
	}
	else{
        double temp;
		k=i;
		y = Box(sol[i]);
		n = n+1;
		m = m+1;
		array = (double **)malloc((m+2)*sizeof(double));
		for(i=0;i<m+2;i++)
			array[i] = (double *)malloc((n+2)*sizeof(double));
		sol = (double *)malloc((n)*sizeof(double));
		for(i=0 ; i<(m+1);i++)
			for(j=0 ; j<(n+1) ; j++)
				array[i][j] = 0.0;
		for(i=0 ; i<(m-1) ; i++)
			for(j=0 ; j<(n_const);j++)
				array[i][j] = array2[i][j];
		array[i][k] = 1;
		array[i][n] = y-1;
		l=l+1;
		for(i=0 ; i<n_obj ; i++){
			array[m][i]= obj[i];
		}
		for(i=0 ; i<(m-1) ; i++)
			array[i][n]	= array2[i][n-1];
		// printf("Before BigM\n");
		// printArray(n,m,array);
		BranchNBound(array,obj,n_obj,n_const,n,m,l,g,e);

		n = n+1;
		// m = m+1;
		array = (double **)malloc((m+2)*sizeof(double));
		for(i=0;i<m+2;i++)
			array[i] = (double *)malloc((n+2)*sizeof(double));
		sol = (double *)malloc((n)*sizeof(double));
		for(i=0 ; i<(m+1);i++)
			for(j=0 ; j<(n+1) ; j++)
				array[i][j] = 0.0;
		for(i=0 ; i<(g) ; i++)
			for(j=0 ; j<(n_const);j++)
				array[i][j] = array2[i][j];
		array[i][k] = 1;
		array[i][n] = y;
		// printf("array[i][n] = %d\n",y);
		for(i=g+1 ; i<m ; i++)
			for(j=0 ; j<(n_const);j++)
				array[i][j] = array2[i-1][j];
		for(i=0 ; i<n_obj ; i++){
			array[m][i]= obj[i];
		}
		for(i=0 ; i<(g) ; i++)
			array[i][n]	= array2[i][n-2];
		array[i][n]	= y;
		for(i=(g+1) ; i<(m) ; i++)
			array[i][n]	= array2[i-1][n-2];
		l=l-1;
		g = g+1;
		temp = 0.0;
		// printf("Before BigM\n");
		// printArray(n,m,array);
		BranchNBound(array,obj, n_obj,n_const,n,m,l,g,e);

	}

}

void main(){
	int i,j,k,m,n,n_obj,n_const,g,l,e;
	double temp;
	counter = 0;
	printf("No of Variables in constraints :");
	scanf("%d",&n_const);
	printf("No of constraints :");
	scanf("%d",&m);
	printf("No of >= , = , <= constraints(In order) :\n");
	scanf("%d %d %d",&g,&e,&l);
	n = n_const + l + e + 2*g;
	main_array = (double **)malloc((m+2)*sizeof(double));
	for(i=0;i<m+2;i++)
		main_array[i] = (double *)malloc((n+2)*sizeof(double));
	Table_list = (double ***)malloc((20)*sizeof(double));
	for(i=0 ; i<20 ; i++){
		Table_list[i] = (double **)malloc((20)*sizeof(double));
		for(j=0;j<20;j++)
			Table_list[i][j ] = (double *)malloc((20)*sizeof(double));
	}
	ms = (int*)malloc((20)*sizeof(int));
	ns = (int*)malloc((20)*sizeof(int));
	for (i = 0; i < m+1; i++){
		for (j = 0; j < n+1; j++)
			main_array[i][j] = 0.0;
	}
	sol = (double *)malloc((n)*sizeof(double));
	sols = (double *)malloc((n_obj+1)*sizeof(double));
	for(i=0 ; i<=n_obj ; i++)
		sols[i] = 0;
	printf("Enter the coefficients of the constraints(In order of >= , = , <=) :\n");
	for(i=0 ; i<m ; i++){
		for(j=0 ; j<n_const ; j++)
			scanf("%lf",&main_array[i][j]);
	}
	printf("Maximize / Minimize (1/-1) :");
	scanf("%d",&MaxorMin);
	printf("Enter the constants of the constraints (In order as of Constraints): \n");
	temp = 0.0;
	for(i=0 ; i<m ;i++){
		scanf("%lf",&main_array[i][n]);
	}
	printf("%d 		%d\n",m,n );
	printf("No of Variables in Objective function :");
	scanf("%d",&n_obj);
	double obj[n_obj];
	printf("Enter the constants of objective function :\n");
	for(i=0 ; i<n_obj ; i++){
		scanf("%lf",&temp);
		// printf("%lf 	%lf\n",temp, -1*temp*MaxorMin);
		obj[i] = -1*temp*MaxorMin;
		main_array[m][i]= -1*temp*MaxorMin;
		// printf("%lf\n",main_array[m][i] );
	}
	for(i=n_obj ; i<n ;i++)
		main_array[m][i] = 0;

	BranchNBound(main_array,obj,n_obj,n_const,n,m,l,g,e);
	printf("********Complete**********\n");
    int option=0;
	while(option!=(-1)){
		printf("\n-1. Exit \n1.Initial Table \n2.Table of ith iteration  \n3.optimal solution (if exists otherwise generate report for infeasibility, unboundedness, altenative optimum etc.)\n");
		scanf("%d",&option);
		switch(option){
			case 1 : printArray(ns[0],ms[0],Table_list[0]);
				break;
			case 2 : printf("Iteration No (1 to %d) :  ",(counter));
				scanf("%d",&k);
				printf("%d 		%d \n",ns[k-1],ms[k-1] );
				printArray(ns[k-1],ms[k-1],Table_list[k-1]);
				break;
			case 3 :
				printf("\n********The Best Solution is :*********\n");
				for(i=0 ; i<n_obj ; i++){
			        printf("x%d = %.0lf 		",(i+1),sols[i]);
			    }
			    printf("\n******The Best Optimum Value is: %.0lf\n",sols[n_obj]);
				break;
			default : printf("\n Enter a valid option\n");
				break;
		}
	}
}
