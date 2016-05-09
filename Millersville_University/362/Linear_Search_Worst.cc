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

bool
searchForValue (vector<int>& vectorToSearch, int valueToFind);
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  vector<int> vectorToSearch (2e8);
  populateVectorRandomly (vectorToSearch);

  // Worst case is that the value is not in the vector.
  int worstCaseSearchValue = -1;

  // std::boolalpha prints true or false rather than 1 or 0
  cout << "Linear search for " << worstCaseSearchValue << " resulted in "
       << std::boolalpha <<
    searchForValue (vectorToSearch, worstCaseSearchValue);
  
  return EXIT_SUCCESS;
}

/************************************************************/
void
populateVectorRandomly (vector<int>& vectorToPopulate)
{
  for (unsigned int i = 0; i < vectorToPopulate.size (); ++i)
  {
    vectorToPopulate.at (i) = i + 1;
  }
}

bool
searchForValue (vector<int>& vectorToSearch, int valueToFind)
{
  if (std::find (vectorToSearch.begin (),
                 vectorToSearch.end (),
                 valueToFind)
      != vectorToSearch.end ())
  {
    return true;
  }
  else
  {
    return false;
  }
}
/************************************************************/