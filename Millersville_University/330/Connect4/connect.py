def createBoard(colLen, rowLen, emptySpace):
#create an initial board with indices board[0 to 6][0 to 5]
	gameBoard = []
	for y in range(rowLen):
		row = []
		for x in range(colLen):
			row.append(emptySpace)
		gameBoard.append(row)
	return gameBoard
		

def playerMove(playNum, curBoard):
#ask for column that the player wants to place their chip in
#loop continuously until a proper move has been selected
#display proper error message in case of full column or invalid column number
#places the proper X or O value into column based on player number
	loop = 1
	while loop == 1:
		playChoice = input(["Player ", playNum, ", what is your move? "])
		if playChoice > 7:
			print "Invalid move! Please enter 1-7"
		elif playChoice < 1:
			print "Invalid move! Please enter 1-7"
		elif curBoard[5][playChoice-1] != ' ':
			print "Invalid move! No room there.."
		elif playNum == 1:
			for i in range(6):
				if curBoard[i][playChoice-1] == ' ':
					curBoard[i][playChoice-1] = 'X'
					loop = 0
					break
		elif playNum == 2:
			for i in range(6):
				if curBoard[i][playChoice-1] == ' ':
					curBoard[i][playChoice-1] = 'O'
					loop = 0
					break
	return curBoard

def displayBoard(theBoard):
#prints out a 7x6 board with | as the boards
#also prints out a board bottom
	printMsg = ''
	for i in range(5, -1, -1):
		for j in range(7):
			printMsg += '|' + theBoard[i][j]
		printMsg += '|'
		print printMsg
		printMsg = ''
	print ("**************")

def hasWinner(theBoard):
#checks the methods of a winning game
#returns True if there is a winner or else
#returns False
	winner = False
	if diagonalUp(theBoard):
		winner = True
	elif diagonalDown(theBoard):
		winner = True
	elif horizontal(theBoard):
		winner = True
	elif vertical(theBoard):
		winner = True
	return winner

def diagonalUp(theBoard):
#checks for 4 in a row moving diagonally up and
#to the right
	winner = False
	for i in range(5):
		for j in range(4):
			# I used [j][i] as my index comparison to save space rather than compare each [j-x][i-x] to
			# [j-1][i-1] since it's still a long if statement
			if theBoard[j][i] == theBoard[j-1][i-1] and theBoard[j][i] == theBoard[j+1][i+1] and theBoard[j][i] == theBoard[j+2][i+2] and theBoard[j][i] != ' ':
				winner = True
	return winner

def diagonalDown(theBoard):
#checks for 4 in a row moving diagonally down and
#to the right
	winner = False
	for i in range(5):
		for j in range(4):
			if theBoard[j+1][i] == theBoard[j+2][i-1] and theBoard[j+1][i] == theBoard[j][i+1] and theBoard[j+1][i] == theBoard[j-1][i+2] and theBoard[j+1][i] != ' ':
				winner = True
	return winner

def horizontal(theBoard):
#checks for 4 in a row moving straight across the board
	winner = False
	for i in range(5):
		for j in range(6):
			if theBoard[j][i] == theBoard[j][i-1] and theBoard[j][i] == theBoard[j][i+1] and theBoard[j][i] == theBoard[j][i+2] and theBoard[j][i] != ' ':
				winner = True
	return winner

def vertical(theBoard):
#checks for 4 in a row moving straight up/down the board
	winner = False
	for i in range(7):
		for j in range(4):
			if theBoard[j][i] == theBoard[j-1][i] and theBoard[j][i] == theBoard[j+1][i] and theBoard[j][i] == theBoard[j+2][i] and theBoard[j][i] != ' ':
				winner = True
	return winner

	

col = 7
row = 6
blank = ' '
anotherGame = 'y'
gameWon = False

while anotherGame == 'y':
	board = createBoard(col, row, blank)
	while gameWon == False:
		displayBoard(board)
		board = playerMove(1, board)
		displayBoard(board)
		if hasWinner(board):
			print "Player 1 has won!"
			anotherGame = raw_input("Do you want to play again? (y/n)")
			if anotherGame != 'y':
				print "Thanks for playing!"
			break
		board = playerMove(2, board)
		displayBoard(board)
		if hasWinner(board):
			print "Player 2 has won!"
			anotherGame = raw_input("Do you want to play again? (y/n)")
			if anotherGame != 'y':
				print "Thanks for playing!"
			break
	

