#include<stdio.h>
int main()
{
	int i,p=getpid();
	for(i=1;i<=10;i++)
		fork();
	if(p==getpid())
		printf("X");
	if(p==getppid())
		printf("Y");
	sleep(1);
}
