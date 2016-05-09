/*
  Filename   : Spellchecker.cc
  Author     : Cory R. Miller
  Course     : CSCI 362
  Assignment : 
  Description: Populate a vector from a dictionary text file.
  Use this vector to spell check another text file.
*/   

/************************************************************/
// System includes

#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <vector>
#include <algorithm>

/************************************************************/
// Local includes


/************************************************************/
// Using declarations

using std::cout;
using std::vector;
using std::string;
using std::ifstream;
using std::cout;
using std::endl;
using std::cin;

/************************************************************/
// Function prototypes/global vars/typedefs
template<typename T>
bool
isSorted (vector<T>& v);

template<typename T>
void
shellSort (vector<T>& v);

template<typename T>
bool
lookup (const vector<T>& v, const T& value);

template<typename T>
void
populateDictionaryVector (vector<T>& v);
/************************************************************/

int      
main (int argc, char* argv[]) 
{
  vector<string> dictionary (0);
  populateDictionaryVector (dictionary);


  // Determine input txt file
  string inputFile;
  cout << "File to spell check ==> ";
  cin >> inputFile;

  // Make sure we can use the input txt file
  ifstream fileStream (inputFile);
  if (! fileStream)
  {
    cout << "Could not open file " << inputFile << ", now exiting." << endl;
    return EXIT_SUCCESS;
  }

  bool sorted = false;
  shellSort (dictionary);
  sorted = isSorted (dictionary);
  
  cout << "\nSorted? ";
  if (sorted)
  {
    cout << "yes\n" << endl;
  }
  else
  {
    cout << "no\n" << endl;
  }

  
  cout << "Misspelled words\n================" << endl;
  bool inDictionary = false;
  string word;
  while (fileStream >> word)
  {
    inDictionary = lookup (dictionary, word);
    if (! inDictionary)
    {
      cout << word << endl;
      inDictionary = false;
    }
    
  }
  return EXIT_SUCCESS; 
}

/************************************************************/
template<typename T>
bool
isSorted (vector<T>& v)
{
  vector<T> copy (v);
  std::sort (copy.begin (), copy.end ());
  if (copy != v)
  {
    return false;
  }
  return true;
}

template<typename T>
void
shellSort (vector<T>& v)
{
  size_t h;
  for (h = 1; h <= v.size () / 4; h = h * 2 + 1);
  while (h > 0)
  {
    for (size_t i = h; i < v.size (); ++i)
    {
      size_t k = i;
      T element = v [i];

      while (k >= h && element < v [k - h])
      {
        v [k] = v [k - h];
        k = k - h;
      }
      v [k] = element;
    }
    
    h /= 2;
  }
}

template<typename T>
bool
lookup (const vector<T>& v, const T& value)
{
  size_t min = 0;
  size_t max = v.size () - 1;
  // Binary search method
  while (max > min)
  {
    size_t middle = (max + min) / 2;
    if (v [middle] == value)
    {
      return true;
    }
    else if (v [middle] < value)
    {
      min = middle + 1;
    }
    else
    {
      max = middle - 1;
    }
  }
  return false;
}

template<typename T>
void
populateDictionaryVector (vector<T>& v)
{
  ifstream fileStream ("/home/faculty/zoppetti/Dictionary.txt");
  if (! fileStream)
  {
    cout << "Could not open file, now exiting." << endl;
    exit (0);
  }
  T element;
  while (fileStream >> element)
  {
    v.push_back (element);
  }
}
/************************************************************/
