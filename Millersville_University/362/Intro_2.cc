/*
  Filename   : ArrayEq.cc
  Author     : Cory R. Miller
  Course     : CSCI 362
  Assignment : 
  Description: Write a C++ function named ArrayEq that has
               3 parameters, two arrays of integers, and their
	       size (both arrays should be the same.) Return
	       true if the arrays contain the same values in
	       the same order.
*/   

/************************************************************/
// System includes

#include <iostream>
#include <string>
#include <cstdlib>

/************************************************************/
// Local includes


/************************************************************/
// Using declarations

using std::cout;
using std::endl;
using std::cin;

/************************************************************/
// Function prototypes/global vars/typedefs

bool
ArrayEq (int arrayA[], int arrayB[], int size) ;

void
printArray (int array[]) ;
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  int size;
  cout << "Please enter the size of the array: ";
  cin >> size;
  int a[size], b[size];

  printArray (a);
  cout << endl;
  printArray (b);
  cout << endl << ArrayEq(a, b, 10) << endl;

  return EXIT_SUCCESS; 
}

/************************************************************/
bool
ArrayEq (int arrayA[], int arrayB[], int size)
{
  bool ArrayComparison = false;

  return ArrayComparison;
}

void
printArray (int array[])
{
  for (int i = 0; i < 10; ++i)
  {
    cout << array[i] << " ";
  }
}
/************************************************************/
