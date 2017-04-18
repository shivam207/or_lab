#include <iostream>
#include <iomanip> 
#include <vector>
#include <cmath>
#include <utility>
#include <algorithm>

using namespace std;


struct tableau
{
	float value;
	int isBasic;
};

void print(int m, int n, float **A)
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

void printT(int m, int n, tableau **A)
{
	int i, j;
	cout<<"----------------"<<endl;
	for (i=0; i<m; i++){
		for (j=0; j<(n); j++)
			cout<<setw(10)<<setprecision(5)<<A[i][j].value;
		cout<<endl;
	}
	// cout<<"----------------"<<endl;
}

void solution(tableau **T, float **cost, int nrow, int ncol)
{
	float value;
	for (int i=0; i<nrow; i++)
		for (int j=0; j<ncol; j++)
			if (T[i][j].isBasic!=0)
				value=value+cost[i][j]*T[i][j].value;

	cout<<"Value is "<<value<<endl;
}

void northWest(int nrow,int ncol,tableau** T)
{
	int curr_x, curr_y;
	curr_x=0;
	curr_y=0;

	while(1){
		T[curr_x][curr_y].isBasic=1;
		if (curr_x>nrow-1 || curr_y>ncol-1)
			break;
		if (T[nrow][curr_y].value<=T[curr_x][ncol].value){
			T[curr_x][curr_y].value=T[nrow][curr_y].value;
			T[curr_x][ncol].value=T[curr_x][ncol].value-T[nrow][curr_y].value;
			T[nrow][curr_y].value=0;
			curr_y++;
		}
		else
		{
			T[curr_x][curr_y].value=T[curr_x][ncol].value;
			T[nrow][curr_y].value=T[nrow][curr_y].value- T[curr_x][ncol].value;
			T[curr_x][ncol].value=0;
			curr_x++;
		}

		
	}
	cout<<"Initial Solution :: using North West \n";
	printT(nrow+1, ncol+1, T);
}

int move(tableau **T, int direction, int x, int y, int s, int d, vector< pair < int, int> > &loop)
{
	// Direction
	// 1 -- UP
	// 2 -- R
	// 3 -- B 
	// 4 -- L
	int res;
	int temp_x=x, temp_y=y;
	pair<int,int> temp;
	if (loop.size()>1 && loop.back().first==loop[0].first && loop.back().second==loop[0].second){
		cout<<"Destination Reached :)"<<endl;
		return 1;
	}

	if (direction==1)
	{
		cout<<"UP\n";
		if (x==0){
			cout<<"R\n";
			// cout<<"Coordinates are :"<<endl;
			// for(int i = 0; i < loop.size();++i)
		 //        cout << loop[i].first << ' '<< loop[i].second<<endl;
			cout<<"x"<<x<<"y"<<y<<endl;
			res=move(T, 2, x, y, s, d, loop);
			if (res==1)
				return 1;
		}
		while (x>0)
		{
			x--;
			if (T[x][y].isBasic)
			{
				cout<<"R1\n";
				temp.first=x;
				temp.second=y;
				loop.push_back(temp);
				res=move(T, 2, x, y, s, d, loop);
				if (res==1)
					return 1;
			}
			// else if (x==0)
			// {

			// }
		}
		if (x==0)
			loop.pop_back();
	}
	if (direction==2)
	{
		if (y==d-1){
			res=move(T, 3, x, y, s, d, loop);
			if (res==1)
				return 1;
		}
		while (y<d-1)
		{
			y++;
			if (T[x][y].isBasic)
			{
				temp.first=x;
				temp.second=y;
				loop.push_back(temp);
				res=move(T, 3, x, y, s, d, loop);
				if (res==1)
					return 1;
			}
		}
		if (y==d-1){
			loop.pop_back();
		}
	}

	if (direction==3)
	{
		if (x==s-1){
			res=move(T, 4, x, y, s, d, loop);
			if (res==1)
				return 1;
		}
		while (x<s-1)
		{
			x++;
			if (T[x][y].isBasic)
			{
				temp.first=x;
				temp.second=y;
				loop.push_back(temp);
				res=move(T, 4, x, y, s, d, loop);
				if (res==1)
					return 1;
			}
		}
		if (x==s-1)
			loop.pop_back();
	}

	if (direction==4)
	{
		if (y==0){
			res=move(T, 1, x, y, s, d, loop);
			if (res==1)
				return 1;
		}
		while (y>0)
		{
			y--;
			if (T[x][y].isBasic)
			{
				temp.first=x;
				temp.second=y;
				loop.push_back(temp);
				res=move(T, 1, x, y, s, d, loop);
				if (res==1)
					return 1;
			}
		}
		if (y==0)
			loop.pop_back();
	}
}

void findloop(tableau **T, int enter_x, int enter_y, int s, int d)
{
	int x=enter_x, y=enter_y, leave_x, leave_y;
	vector< pair < int, int> > loop;
	pair<int,int> temp;
	temp.first=x;
	temp.second=y;
	loop.push_back(temp);
	move(T, 1, x, y, s, d, loop);
	// cout<<"Coordinates are :"<<endl;
	// for(int i = 0; i < loop.size();++i)
 //        cout << loop[i].first << ' '<< loop[i].second<<endl;

 //    cout<<"Size is : "<<loop.size()<<endl;
    //Leaving Variable
    if (T[loop[1].first][loop[1].second].value < T[loop[3].first][loop[3].second].value)
    {
    	leave_x=loop[1].first;
    	leave_y=loop[1].second;
    	T[loop[3].first][loop[3].second].value=T[loop[3].first][loop[3].second].value-T[leave_x][leave_y].value;
    } 
    else
    {
    	leave_x=loop[3].first;
    	leave_y=loop[3].second;
    	T[loop[1].first][loop[1].second].value=T[loop[1].first][loop[1].second].value-T[leave_x][leave_y].value;
    }
    T[loop[2].first][loop[2].second].value=T[leave_x][leave_y].value+T[loop[2].first][loop[2].second].value;
    T[leave_x][leave_y].isBasic=0;
    T[x][y].value=T[leave_x][leave_y].value;
    T[leave_x][leave_y].value=0;   
}

void iterateop(tableau **T, float **cost, int s, int d)
{
	int i, j, flag=1;
	for (i=0; i<s; i++)
		T[i][d+1].value=-1111;
	for (j=0; j<d; j++)
		T[s+1][j].value=-1111;
	// Multipliers calculation
	T[0][d+1].value=0;
	while(flag)
	{
		flag=0;
		for (i=0; i<s; i++)
		{
			for (j=0; j<d; j++)
			{
				if (T[i][j].isBasic == 1)
				{
					if (T[i][d+1].value==-1111 && T[s+1][j].value==-1111)
						flag=1;
					else if (T[i][d+1].value==-1111)
						T[i][d+1].value=cost[i][j]-T[s+1][j].value;
					else if (T[s+1][j].value==-1111)
						T[s+1][j].value=cost[i][j]-T[i][d+1].value;
				}
			}
		}
	}

	int enter_var_x=0;
	int enter_var_y=0;
	float temp=-10000;
	for (i=0; i<s; i++)
	{
		for (j=0; j<d; j++)
		{
			if (T[i][j].isBasic != 1)
			{
				T[i][j].value=T[i][d+1].value+T[s+1][j].value-cost[i][j];
				if (temp<T[i][j].value)
				{
					temp=T[i][j].value;
					enter_var_y=j;
					enter_var_x=i;
				}
			}
		}
	}
	if (temp<=0)
	{
		cout<<"========FINAL SOL========="<<endl;
		solution(T, cost, s, d);
		for (i=0; i<s; i++)
			for (j=0; j<d; j++)
				if (T[i][j].isBasic != 1)
					T[i][j].value=0;
		cout<<"Transportation Tableau is : \n";
		printT(s, d, T);
		return;
	}
	cout<<"entering var : X"<<enter_var_x+1<<enter_var_y+1<<endl;
	T[enter_var_x][enter_var_y].isBasic=1;
	findloop(T, enter_var_x, enter_var_y, s, d);
	solution(T, cost, s, d);
	iterateop(T, cost, s, d);

}


int main()
{
	int s, d, i, j;
	float **cost;
	tableau **T;
	cout<<"Enter no of source and destination"<<endl;
	cin>>s>>d;

	cost = new float* [s+1]; 

    for (i=0; i<s+1; i++){
        cost[i]= new float [d+1];
    }

    cout<<"Enter the cost matrix with supply and demand"<<endl;
	for (i=0; i<s+1; i++){
		for (j=0; j<d+1; j++){
			cin>>cost[i][j];
		}
	}

	cout<<"Entered Table is : \n";
    print(s+1, d+1, cost);

    T=new tableau* [s+1+1];
    for (i=0; i<s+1+1; i++){
        T[i]= new tableau [d+1+1];
    }

    for (i=0; i<s; i++)
    	T[i][d].value=cost[i][d];
    for (i=0; i<d; i++)
    	T[s][i].value=cost[s][i];

    northWest(s, d, T);
    solution(T, cost, s, d);
    iterateop(T, cost, s, d);

}