                                                                                                                                                                                                 #include<stdio.h>
int main()
{
	printf("%d %d\n", getpid(), getppid());
	int p=getpid();
	fork();
		if(p==getpid())
		sleep(0);
	printf("%d %d\n", getpid(), getppid());
	sleep(1);
	return 0;
}
