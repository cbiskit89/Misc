/*
   Filename   : SimpleSort.cpp
   Author     : Cory Miller
   Course     : CSCI 362-01
   Assignment : Program 1 - Time of Sorting Methods
   Description: Allows user to select a sorting method from
                 selection, bubble, or insertion as well as
                 the size of a vector to be sorted.
                 Vector is populated with random integers.
*/

/**********************************************************/
//System includes

#include <cstdlib>
#include <vector>
#include <string>
#include <iostream>
/**********************************************************/

/**********************************************************/
//Local includes

/**********************************************************/

/**********************************************************/
//Using declarations

using std::vector;
using std::cout;
using std::endl;
using std::string;
using std::swap;
/**********************************************************/

/**********************************************************/
//Function prototypes, global variables,type definitions

void
bubbleSort (vector<int>& v);

void
selectionSort (vector<int>& v);

void
insertionSort (vector<int>& v);

bool
isSorted (vector<int>& v);
/**********************************************************/

/**********************************************************/
int
main (int argc, char* argv[])
{
  //in case user does not enter correct arguments print error message
  if (argc != 3)
  {
    cout << "Error in command line arguments!" << endl;
    cout << "Command line should read \"sortingMethod numberofItemsToSort\""
         << endl;
    return EXIT_FAILURE;
  }

  //read in user command line arguments to variables
  string typeOfSort (argv[1]);
  int numberOfItemsInVector = atoi (argv[2]);
  
  //create vector of numberToSort numbers using rand
  vector<int> vectorToSort (numberOfItemsInVector);

  //populate vector with user determined number of integers
  for (int i = 0; i < numberOfItemsInVector; ++i)
  {
    vectorToSort[i] = rand ();
  }

  //check user's desired sort method, if invalid terminate program
  if (typeOfSort == "bubble")
  {
    bubbleSort (vectorToSort);
  }
  else if (typeOfSort == "selection")
  {
    selectionSort (vectorToSort);
  }
  else if (typeOfSort == "insertion")
  {
    insertionSort (vectorToSort);
  }
  else
  {
    cout << "Incorrect sort type. Please enter bubble, selection, or "
	 << "insertion." << endl;
    return EXIT_FAILURE;
  }
  
  if (isSorted (vectorToSort) == true)
  {
    cout << "Sorted: yes" << endl;
    return EXIT_SUCCESS;
  }
  else
  {
    cout << "Error, vector was not properly sorted." << endl;
    return EXIT_FAILURE;
  }
}//end of main
/**********************************************************/

/**********************************************************/
void
bubbleSort (vector<int>& v)
{
  /*
    Each iteration of the outer loop will end with the
    highest value of the vector in the last index. The
    inner loop swaps the values starting at position 0
    if the current index is larger than the next index.
   */
  for (size_t i = v.size () - 1; i > 0; --i)
  {
    for (size_t j = 0; j < i; ++j)
    {
      if (v[j] > v[j + 1])
      {
        swap (v[j], v[j + 1]);
      }
    }
  }
}
/**********************************************************/

/**********************************************************/
void
selectionSort (vector<int>& v)
{
   /*
    Each iteration of the outer loop results in the
    lowest value being placed at the current i index
    of the vector. The inner loop scans the vector
    from i to the end to find the lowest unsorted
    value of the vector.
   */

  int indexToSwitch;

  for (size_t i = 0; i < v.size (); ++i)
  {
    indexToSwitch = i;
    
    for (size_t j = i + 1; j < v.size (); ++j)
    {
      if (v[indexToSwitch] > v[j])
      {
        indexToSwitch = j;
      }
    }
    
    swap (v[i], v[indexToSwitch]);
  }
}
/**********************************************************/

/**********************************************************/
void
insertionSort (vector<int>& v)
{
  /*
    Each iteration of the outer loop will result in the
    lowest value being placed at index i of vector v.
    The inner while loop checks v at j against v at i to
    determine if v at j is greater than v at i. If it is
    then swap with the next index and move j back one
    to shift the positions of all the values in the vector.
   */

  int elementToPlace;
  size_t indexToPlace;

  for (size_t i = 1; i < v.size (); ++i)
  {
    elementToPlace = v[i];
    indexToPlace = i;

    while (indexToPlace - 1 >= 0 && elementToPlace < v[indexToPlace - 1])
    {
      v[indexToPlace] = v[indexToPlace - 1];
      indexToPlace -= 1;
    }
    v[indexToPlace] = elementToPlace;
  }
}
/**********************************************************/

/**********************************************************/
bool
isSorted (vector<int>& v)
{
  /*
    Check values of vector to make sure they are sorted
  */

  for (size_t i = 0; i < v.size () - 1; ++i)
  {
    if (v[i] > v[i+1])
    {
      return false;
    }
  }
  return true;
}
/**********************************************************/
/**********************************************************/
