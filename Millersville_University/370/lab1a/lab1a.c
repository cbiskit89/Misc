#include <stdio.h>
#include <stdlib.h>

int count_ones(unsigned x)
{
	int count = 0;
	int i;

	for (i = 0; i < 32; ++i)
	{
		count += (x & 1);
		x = x >> 1;
	}

	return count;
}

main()
{
	/* max 32-bit integer */

	unsigned u;
	int numberOfOnes;

	while (u != 0)
	{
		printf ("Enter a 32-bit hex number ==> ");
		scanf ("%X", &u);
		numberOfOnes = count_ones (u);
		printf ("--------- %i %s \n", numberOfOnes, "---------");
	}

	exit (0);
}
