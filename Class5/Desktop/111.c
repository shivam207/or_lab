#include<stdio.h>
int main()
{
	fork();fork();
	printf("X\n");
	fork();
	printf("Y\n");
	fork();fork();fork();
	printf("Z");
}
