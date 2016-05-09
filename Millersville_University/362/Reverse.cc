/*
  Filename   : Reverse.cc
  Author     : Cory R. Miller
  Course     : CSCI 362
  Assignment : 
  Description: Write a program that will reverse the digits of
  an integer entered by the user.
*/   

/************************************************************/
// System includes

#include <iostream>
#include <cstdlib>

/************************************************************/
// Local includes


/************************************************************/
// Using declarations

using std::cout;
using std::cin;
using std::endl;

/************************************************************/
// Function prototypes/global vars/typedefs

int
reverseNumber (int number) ;
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  cout << "Enter an integer to be reversed: ";
  int numberToReverse;
  cin >> numberToReverse;
  
  cout << "The reverse of your input is " <<
    reverseNumber (numberToReverse) << endl;
  
  return EXIT_SUCCESS; 
}

/************************************************************/
int
reverseNumber (int number)
{
  int numberReversed; 
  
  while (number != 0)
  {
    numberReversed *= 10;
    numberReversed += number % 10;
    number /= 10;
  }

  return numberReversed;
}
/************************************************************/
