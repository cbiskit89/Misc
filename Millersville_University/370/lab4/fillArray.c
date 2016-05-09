#include <stdio.h>

int fillArray(int a[])
 {
   int count = 0;
   int nextValue;
   const int MAXNUM = 25;

   printf("Enter next coefficient <999 to exit> => ");
   scanf("%d", &nextValue);
   printf("\n");
  
  while (nextValue != 999)
   {     
      a[count] = nextValue;
      count++;     
      if (count == MAXNUM) break;
      printf("Enter next coefficient <999 to exit> => ");
      scanf("%d", &nextValue);
      printf("\n");
    }
   return count;
  }

