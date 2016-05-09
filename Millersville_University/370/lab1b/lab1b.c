#include <stdio.h>
#include <stdlib.h>

main()
{ 

	/* max 32-bit integer */

	union floatOrUnsigned
	{
		/* y and u share the same storage */

		float y;
		unsigned u;

	}fltu;

	while (fltu.u != 0)
	{
   
     		printf("Enter a 32-bit hex  number (0 to exit) ==> ");
     		scanf("%f", &fltu.y);

		if (fltu.u == 0)
			exit(0);

     		printf("--------- %X %s\n", fltu.u, "---------");
		printf("--------- %f %s\n", fltu.y, "---------");

		//Examine last 23 bits for significand then shift bits
		//to the right 23
		unsigned significand =  (fltu.u & 0x7FFFFF);
		fltu.u = fltu.u >> 23;

		//Examine last 8 bits for exponent then shift bits 8
		//to the right
		unsigned exponent = (fltu.u & 0xFF);
		fltu.u = fltu.u >> 8;

		//Remaining bits in fltu.u represent the sign bit
		//Then print stored values for exponent and significand
		printf("Sign = %x \n", fltu.u);
		printf("Exponent = %x \n", exponent);
		printf("Significand = %x \n", significand);

		//Since fltu.u could be zero (only the sign bit is left)
		//set value of fltu.u to 1 to prompt user for another num
		fltu.u = 1;

	}
}