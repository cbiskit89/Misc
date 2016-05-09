#include <cstdlib>
#include <iostream>
#include <string>
#include <iterator>
#include <cstdio>

#include "Array.h"

using std::cout;
using std::endl;
using std::ostream_iterator;
using std::string;


int
main (int argc, char* argv[])
{

  Array<int> emptyArray;

  cout << emptyArray.size() << endl;
  Array<int> testArray (3, 0);

  cout << testArray.size() << endl;
  for (size_t i = 0; i < testArray.size(); ++i)
  {
    cout << testArray[i] << " ";
  }

  testArray[1] = 5;

  cout << endl;

  for (size_t i = 0; i < testArray.size(); ++i)
  {
    cout << testArray[i] << " ";
  }

  cout << endl;

  cout << testArray.begin() << endl;

  Array<int> testCopyInitializer (testArray);

  cout << testCopyInitializer.size() << endl;

  for (size_t i = 0; i < testArray.size(); ++i)
  {
    cout << testArray[i] << " ";
  }

  cout << endl;

  cout << testArray.end() << endl;

  testArray.resize(10, 0);

  for (size_t i = 0; i < testArray.size(); ++i)
  {
    cout << testArray[i] << " ";
  }

  cout << endl;

  testArray.insert(testArray.begin() + 5, 7);

  for (size_t i = 0; i < testArray.size(); ++i)
  {
    cout << testArray[i] << " ";
  }

  return EXIT_SUCCESS;
}
