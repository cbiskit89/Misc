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
#include <string>
#include <cstdlib>

/************************************************************/
// Local includes


/************************************************************/
// Using declarations

using std::cout;
using std::cin;
using std::endl;
using std::string;

/************************************************************/
// Function prototypes/global vars/typedefs

int
reverseNumber (int number);

int
getDigits (int number);
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  cout << "Enter an integer: ";
  int number;
  cin >> number;
  
  for (int i = 0; i < getDigits (number); ++i)
  {
    cout << reverseNumber (number);
  }
  
  return EXIT_SUCCESS; 
}

/************************************************************/
int
reverseNumber (int number)
{
  int numberHolder;
  
  for (int i = 0; i < getDigits(number); ++i)
  {
    numberHolder = number % 10;
    number /= 10;
  }

  return numberHolder;
}

int
getDigits (int number)
{
  int digits = 0;
  do
  {  
    if (number == 0)
    {
      digits = 1;
    }
    else
    {
      number /= 10;
      digits++;
    }
  }
  while (number > 0);

  return digits;
}
/************************************************************/
