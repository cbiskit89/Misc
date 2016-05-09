/*
  Filename   : Find_Time.cc
  Author     : Cory R. Miller
  Course     : CSCI 362
  Assignment : 
  Description: Populate a vector with integers from 1 to N.
  Then search the vector for the best and worst
  case using std::find and std::binary_search.
  Time this program to analyze the results.
*/   

/************************************************************/
// System includes

#include <iostream>
#include <cstdlib>
#include <vector>
#include <algorithm>

/************************************************************/
// Local includes


/************************************************************/
// Using declarations

using std::cout;
using std::vector;
using std::endl;

/************************************************************/
// Function prototypes/global vars/typedefs
void
populateVectorRandomly (vector<int>& vectorToPopulate);
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  vector<int> vectorToSearch (4e8);
  populateVectorRandomly (vectorToSearch);

  if (std::find (vectorToSearch.begin (),
		 vectorToSearch.end (),
		 vectorToSearch.back ())
      != vectorToSearch.end ())
  {
    cout << "Found" << endl;
  }
  else
  {
    cout << "Not found" << endl;
  }
  
  return EXIT_SUCCESS;
}

/************************************************************/
void
populateVectorRandomly (vector<int>& vectorToPopulate)
{
  for (int &i : vectorToPopulate)
  {
    i = rand ();
  }
}
/************************************************************/
