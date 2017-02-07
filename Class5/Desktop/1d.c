#include<stdio.h>
int main()
{
	int i,p=getpid();
	fork();
	for(i=1;i<4098;i++)
		if(p==getpid())
			printf("X");
		else
			printf("Y");
return 0;
	}
