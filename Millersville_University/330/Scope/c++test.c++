#include <iostream>
using namespace std;

int function();
int x;

int main()
{
	cout << "\nx = " << function();
	cout << "\nx = " << x;
	cin.get();	
}

int function()
{
	x = 21;
	int x;
	x = 42;
	cout << "x = " << x;
	return x;
}
