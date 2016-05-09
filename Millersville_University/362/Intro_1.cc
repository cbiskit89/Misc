/*
  Filename   : Intro_1.cc
  Author     : Cory R. Miller
  Course     : CSCI 362
  Assignment : 
  Description: Write a C++ program that uses a loop to sum
               the numbers from 1 to 10 and print the result.
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

/************************************************************/
// Function prototypes/global vars/typedefs

/************************************************************/

int      
main (int argc, char* argv[]) 
{
  int sum;
  
  for (int i = 1; i <= 10; ++i)
  {
    sum += i;
  }

  cout << "The sum is: " << sum << endl;

  return EXIT_SUCCESS; 
}

/************************************************************/
/************************************************************/
