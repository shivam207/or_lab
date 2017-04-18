#include <iostream>
#include <iomanip> 
#include <vector>
#include <cmath>
#include <utility>

using namespace std;

int main()
{
	vector< pair < int, int> > myVect;
	pair<int,int> m;
	m=make_pair(2, 3);
	myVect.push_back(m);
	m.first=10;
	myVect.push_back(m);
	for(int i = 0; i < myVect.size();++i)
        cout << myVect[i].first << ' ';
}