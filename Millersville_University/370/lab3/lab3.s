#---------------------------------------------------------------
#       Cory Miller
#   	Lab 3 - Speed Limit Fine/Point Calculator
#---------------------------------------------------------------

.section	.data     # data allocation directive

speed:		.int 0

fine:		.int 0 

points:		.int 0

prompt:		.asciz	"Enter speed ==> "

outputFine:	.asciz	"Fine = \$%d\n"

outputPts:	.asciz	"Points = %d\n"

inputSpec: 	.asciz	"%d"

.section	.text
	
.globl	main

main:

#	Read speed
#			
	PUSHL		$prompt

	CALL		printf

	ADDL		$4,	%esp

#------------------------------------------------------
        PUSHL		$speed

	PUSHL		$inputSpec

	CALL		scanf

    	ADDL		$8,	%esp

	MOVL		speed, 	%eax

#---------------- good input assign grade  ------------------------

	CMPL		$85,	   %eax		# compare with 86

	JG		assignFineA		# 86+ fine block

#----------------------- compare with 79 --------------------------

	CMPL		$80,	   %eax		# Compare with 80

	JG		assignFineB		# 81-85 fine block

#----------------------- compare with 69 -------------------------

	CMPL		$75,	   %eax		# Compare with  75

	JG		assignFineC		# 76-80 fine block

#----------------------- compare with 59 -------------------------

	CMPL		$70,	   %eax		# compare with 70

	JG		assignFineD		# 71-75 fine block

#------------------------ Default: Below 70 mph ----------------
	
   	MOVL		$0,	fine

	MOVL		$0,	points

    	JMP		printFine                          

#------------------------- A  ----------------------------
 assignFineA:
	
    	MOVL		$150,	fine
	
	MOVL		$6,	points

    	JMP		printFine

#------------------------- B ----------------------------
 assignFineB:
	
    	MOVL		$120,	fine
	
	MOVL		$4,	points

    	JMP		printFine
#-------------------------- C ----------------------------
 assignFineC:
	
    	MOVL		$90,	fine
	
	MOVL		$3,	points

    	JMP		printFine
#------------------------- D  ----------------------------
 assignFineD:
	
    	MOVL		$60,	fine
	
	MOVL		$2,	points

#-------------------- print grade ------------------------
printFine:  

	PUSHL		fine

  	PUSHL		$outputFine

	CALL		printf

	PUSHL		points

	PUSHL		$outputPts
 
  	CALL		printf

  	ADDL		$4,	%esp
#-------------------------------------------------------
done:

  	LEAVE

  	CALL	 exit
