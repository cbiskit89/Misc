/*
  Filename   : Array.h
  Author     : Cory Miller
  Course     : CSCI 362-01
  Assignment : Array
  Description: Array class, our implementation of a list ADT 
                 with random access and dynamic resizing
*/   

/************************************************************/
// Macro guard to prevent multiple inclusions

#ifndef ARRAY_H
#define ARRAY_H

/************************************************************/
// System includes

#include <cstdlib>
#include <algorithm>
#include <cstdio>

/************************************************************/
// Local includes

/************************************************************/
// Using declarations

using std::ostream;
using std::fill;
using std::swap;
using namespace std;

/************************************************************/

template <typename T>
class Array 
{
public:
  
  typedef T          value_type;
  // Iterators are just pointers to objects of type T
  typedef T*         iterator;
  typedef const T*   const_iterator;

  typedef T&         reference;
  typedef const T&   const_reference;
  typedef size_t     size_type;
  typedef ptrdiff_t  difference_type;

  // Initialize an empty Array
  Array ()
    : m_size (0), m_capacity (0), m_array (NULL)
  { }

  // Initialize an Array of size "pSize", with each element
  //   set to "value"
  explicit Array (size_t pSize, const T& value = T ())
    : m_size (pSize), m_capacity (pSize), m_array (new T[m_size])
  {
    fill (m_array, m_array + m_size, value);
  }

  // Initialize an Array from the range [first, last)
  Array (const_iterator first, const_iterator last)
  {

  }
  
  // Initialize this object from "a"
  Array (const Array &a)
  {
    operator= (a);
  } 
  
  // Release allocated memory
  ~Array ()
  {
    delete[] m_array;
  }
  
  // Assign "a" to this object
  //   Watch for self-assignment
  Array&
  operator= (const Array& a)
  {
    if (this != &a)
    {
      m_size = a.m_size;
      m_capacity = a.m_capacity;
      m_array = new T[m_size];
      copy (a.m_array, a.m_array + a.m_size, m_array);
    }

    
    return *this;
  }

  size_t
  size () const
  {
    return m_size;
  }

  size_t
  capacity () const
  {
    return m_capacity;
  }

  T&
  operator[] (size_t index)
  {
    return m_array[index];
  }

  const T&
  operator[] (size_t index) const
  {
    return m_array[index];
  }

  void
  push_back (const T& item)
  {

    // double the capacity if array is currently full
    if (m_size == m_capacity)
    {
      reserve (m_capacity);
    }
    
    // make the end position equal item and increase size
    m_array[m_size++] = item;
  }

  void
  pop_back ()
  {
    // do not allow pop on empty array
    if (m_size == 0)
      return;

    m_size--;
  }

  // Reserve capacity for "space" elements -- "space" must be 
  //   > capacity -- this doesn't change the size 
  //   Invoking methods double capacity when extra space is needed
  void
  reserve (size_t space)
  {
    if (space < m_capacity)
    {
      // doesn't change the size if attempt to reserve smaller space than current
      return;
    }
    
    // creates a temporary array to hold the values of m_array until it is
    // resized
    T* tempArray = m_array;

    // double the capacity if space > m_capacity
    m_capacity = space * 2;

    m_array = new T[m_capacity];
    copy (tempArray, tempArray + m_size, m_array);

    delete [] tempArray;
  }

  void
  resize (size_t newSize, const T& defValue = T ())
  {
    if (newSize > m_capacity)
    {
      reserve (newSize);
    }
    
    fill (m_array + m_size, m_array + m_capacity, defValue);

    m_size = newSize;
  }

  // Insert "item" before "pos", and return iterator referencing "item"
  iterator       insert (iterator pos, const T& item)
  {
    if (m_size == m_capacity)
    {
      reserve (m_capacity);
    }

    m_size++;
    
    // create temp array to hold elements from index 'pos - 1' to end
    T* tempArray = new T[m_size];

    copy (begin(), pos - 1, tempArray);

    // set m_array at pos - 1 to item
    fill (pos - 1, pos - 1, item);

    // fill array from pos to end
    copy (pos, m_array + m_size, tempArray);

    m_array = tempArray;

    delete [] tempArray;
    return pos;
  }
  // Remove element at "pos", and return iterator referencing next element
  iterator       erase  (iterator pos)
  {

  }

  iterator       begin ()
  {
    return &m_array[0];
  }
  const_iterator begin () const
  {
    return &m_array[0];
  }

  // Return pointer to element one past last
  iterator       end ()
  {
    return &m_array[m_size];
  }
  const_iterator end () const
  {
    return &m_array[m_size];
  }

private:

  size_t m_size;
  size_t m_capacity;
  T*     m_array;

};

/************************************************************************/
// Free functions associated with class

template <typename T>
ostream&
operator<< (ostream& output, const Array<T>& a);

#endif

/************************************************************************/
