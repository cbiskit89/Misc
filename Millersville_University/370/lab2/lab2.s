# file name : sqrtWInputPrmpt.s
# Reads data from keyboard using prompt
# and scanf

.section .data    # read write data section

a:  .int 0

product: .quad 0

inprompt: .asciz "Enter a value for x ==> "

prompt: .asciz "Result = %d\n"

inputSpec:
	.ascii	"%d"

.section .text   # read only section

.globl main

main:
   PUSHL	$inprompt
   CALL		printf
#----------------------------------------------------------------------------
# read in x
   PUSHL	$a		#push address of a on stack
   PUSHL	$inputSpec	#push address of inputSpec string on stack
   CALL		scanf
#----------------------------------------------------------------------------
# compute 4x^2+2x-10
   MOVL		a,   %eax		# copy value1 to register A
   IMULL	a,   %eax		# Reg A = Reg A^2
   IMULL	$4,  %eax		# Reg A = (Reg A^2)*4
   ADDL		a,   %eax		# Reg A = (Reg A^2)*4+A
   ADDL		a,   %eax		# Reg A = (Reg A^2)*4+2*A
   SUBL		$10, %eax		# Reg A = (Reg A^2)*4+2*A-10
#---------------------------- display result -------------------------------------
   PUSHL	%eax	 		# push  A to the stack
   PUSHL	$prompt
   CALL		printf
   ADDL		$8,	%esp
#-------- return now -------------
   LEAVE

   CALL		 exit
