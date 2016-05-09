#include <iostream>
#include <sys/time.h>

using namespace std;

void staticArray(int size);
void stackArray(int size);
void heapArray(int size);

const int SIZE = 100000;

int main()
{	
	struct timeval startStatic;
	struct timeval endStatic;
	struct timeval startStack;
	struct timeval endStack;
	struct timeval startHeap;
	struct timeval endHeap;
	double tS, tE;

	gettimeofday(&startStatic, NULL);
	for(int i = 0; i < 10000000; i++)
	{
		staticArray(SIZE);
	}
	gettimeofday(&endStatic, NULL);

	tS = startStatic.tv_sec*1000000 + (startStatic.tv_usec);
	tE = endStatic.tv_sec*1000000 +	(endStatic.tv_usec);
	std::cout << "Total Time Taken: " << tE - tS << 		std::endl;
	
	gettimeofday(&startStack, NULL);
	for(int i = 0; i < 10000000; i++)
	{
		stackArray(SIZE);
	}
	gettimeofday(&endStack, NULL);

	tS = startStack.tv_sec*1000000 + (startStack.tv_usec);
	tE = endStack.tv_sec*1000000 + 	(endStack.tv_usec);
	std::cout << "Total Time Taken: " << tE - tS << 		std::endl;

	gettimeofday(&startHeap, NULL);
	for(int i = 0; i < 10000000; i++)
	{
		heapArray(SIZE);
	}
	gettimeofday(&endHeap, NULL);

	tS = startHeap.tv_sec*1000000 + (startHeap.tv_usec);
	tE = endHeap.tv_sec*1000000 + 	(endHeap.tv_usec);
	std::cout << "Total Time Taken: " << tE - tS << 		std::endl;
}

void staticArray(int size)
{
	static int array1[SIZE];
}

void stackArray(int size)
{
	int array1[SIZE];
}

void heapArray(int size)
{
	int* array1 = new int[SIZE];
	delete[] array1;
}
