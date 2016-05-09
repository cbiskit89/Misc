# file name : polyEval.s 
# We want a program that reads coefficients
# of a polynomial from the standard input
# and evaluates the polynomial at a given value.
# This incomplete programs reads and stores the
# ploynomial coefficients. It also reads and stores
# the point at which the polynomial should be evaluated.
# Your programming assignment is to write assembly code to 
# evaluate the polynomial and display this value.
#---------------------------------------------------
# Dr. Chaudhary
# Department of CS @MU
# Modified by: Cory Miller
#---------------------------------------------------
.section .data

.section	.data

x:	.int	0

value:	.int	0

n:	.int	0

outSpec: .asciz	"\nThe ploynomial evaluates to  = %d\n"

outSpec1: .asciz "Enter x ==> "

inpSpec: .asciz "%d"

#------------------------------#
# Here is one way of declaring #
# an array of 32-bit words     #
# -----------------------------#

.section	.bss	#declare raw data section

 .comm		coefficients	100
 
 # allocates any array of 25 elements 

.section .text

.globl main

main:

   	PUSHL	$coefficients	# Push the address of coefficients

   	CALL	fillArray	# Call fillArray function

   	MOVL	%eax,	n	# n = number of elements
   	
   	ADDL	$4,	%esp	# give back the stack space

   #------------------------- read a value for x ----------------------
   	
	PUSHL	$outSpec1

	CALL	printf

   	ADDL	$4,	%esp

	PUSHL	$x
 
   	PUSHL	$inpSpec
 
   	CALL	scanf
   
   	ADDL	$8,	%esp

#--------------------------- evaluate polynomial ---------------------
#  

	XOR	%eax,	%eax

	XOR	%edx,	%edx

	LEAL	coefficients,	%esi

	MOVL	n,	%ecx

	INCL	%eax

	for:
	
		CMPL	%ecx,	%eax

		JG	display

		IMULL	x,	%edx

		ADDL	(%esi),	%edx

		ADDL	$4,	%esi

		INCL	%eax
	
		JMP	for

#---------------------------- Display value --------------------------
display:

        MOVL	%edx,	value		# remove this line when done

 	PUSHL	value        
 
 	PUSHL	$outSpec

	CALL	printf

   	ADDL	$8,	%esp

#---------------------------- exit codes ------------------------------        	
	 
#  exit codes

	LEAVE

	CALL	exit
