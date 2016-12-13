

import java.util.Scanner;

public class TicTacToe {

	private char[] firstRowPosition = new char[3];
	private char[] secondRowPosition = new char[3];
	private char[] thirdRowPosition = new char[3];
	private static int moveCount = 0;
	private boolean tie = true;
	private boolean invalidMove = true;
	private boolean full = false;
	Scanner sc = new Scanner(System.in);

	// initializes all spaces on the board with a blank space
	// gives simple instructions
	public void StartGame() {
		// runs through every position of each row
		for (int i = 0; i < 3; i++) {
			firstRowPosition[i] = ' ';
			secondRowPosition[i] = ' ';
			thirdRowPosition[i] = ' ';
		}
		System.out.println("The top row is row 1, the leftmost column is column 1");
		System.out.println("When taking your turn, give a coordinate in the form: row# column#");
		System.out.println("Then press enter");
		System.out.println("player X give your coordinates");
	}

	// intended to overload drawBoard method
	public void drawBoard(double[][] coordinate) {

	}

	// intended to overload drawBoard method
	public void drawBoard(int[] rowOne, int[] rowTwo, int[] rowThree) {

	}

	// shows current board state
	public void drawBoard() {
		// runs through every place on the board
		for (int i = 0; i < 9; i++) {
			// checks if in first row and fills in first row with markers
			if (i < 3) {
				System.out.print(firstRowPosition[i]);
				// makes sure bars are not put at the end of each row
				if (i < 2) {
					System.out.print(" | ");
				}

			}
			// checks if in second row and fills in second row with markers
			else if (i < 6) {
				// begins new line at beginning of second row
				if (i == 3) {
					System.out.println("");
				}
				System.out.print(secondRowPosition[i - 3]);
				// makes sure bars are not put at the end of second row
				if (i < 5) {
					System.out.print(" | ");
				}
			}
			// must be third row now, fill in the third row
			else {
				// new line at start of third row
				if (i == 6) {
					System.out.println("");
				}
				System.out.print(thirdRowPosition[i - 6]);
				// puts bars between markers but not at the end of the row
				if (i < 8) {
					System.out.print(" | ");
				}
			}
		}
	}

	// marks one area of the grid with an X
	public void pXTurn(int row, int column) {
		// keeps calling for coordinates if the move is invalid
		while (invalidMove) {
			// checks if pX wanted to move within row 1
			if (row == 1) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[0] == ' ') {
						this.firstRowPosition[0] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[1] == ' ') {
						this.firstRowPosition[1] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[2] == ' ') {
						this.firstRowPosition[2] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// checks if pX wanted to move within row 2
			if (row == 2) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[0] == ' ') {
						this.secondRowPosition[0] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[1] == ' ') {
						this.secondRowPosition[1] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[2] == ' ') {
						this.secondRowPosition[2] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// checks if pX wanted to move within row 3
			if (row == 3) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[0] == ' ') {
						this.thirdRowPosition[0] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[1] == ' ') {
						this.thirdRowPosition[1] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[2] == ' ') {
						this.thirdRowPosition[2] = 'X';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// calls for a new coordinate if the move is invalid
			if (invalidMove) {
				row = sc.nextInt();
				column = sc.nextInt();
			}
		}
		System.out.println("player O give your coordinates");
		moveCount++;
		invalidMove = true;
	}

	public void pOTurn(int row, int column) {
		// keeps calling for coordinates if the move is invalid
		while (invalidMove) {
			// checks if pX wanted to move within row 1
			if (row == 1) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[0] == ' ') {
						this.firstRowPosition[0] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[1] == ' ') {
						this.firstRowPosition[1] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.firstRowPosition[2] == ' ') {
						this.firstRowPosition[2] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// checks if pX wanted to move within row 2
			if (row == 2) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[0] == ' ') {
						this.secondRowPosition[0] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[1] == ' ') {
						this.secondRowPosition[1] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.secondRowPosition[2] == ' ') {
						this.secondRowPosition[2] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// checks if pX wanted to move within row 3
			if (row == 3) {
				// checks if it should mark column 1
				if (column == 1) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[0] == ' ') {
						this.thirdRowPosition[0] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 2
				else if (column == 2) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[1] == ' ') {
						this.thirdRowPosition[1] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
				// checks if it should mark column 3
				else if (column == 3) {
					// checks if the space has been used already or not
					if (this.thirdRowPosition[2] == ' ') {
						this.thirdRowPosition[2] = 'O';
						invalidMove = false;
					}
					// if the space has been used you can't go on top of a
					// marker
					else {
						invalidMove = true;
					}
				}
			}
			// calls for a new coordinate if the move is invalid
			if (invalidMove) {
				row = sc.nextInt();
				column = sc.nextInt();
			}
		}
		System.out.println("player X give your coordinates");
		moveCount++;
		invalidMove = true;
	}

	// checks each case in which there would be a winner and determines who the
	// winner is
	public void isWinner() {
		// horizontal 1st row case
		if (firstRowPosition[0] == firstRowPosition[1] && firstRowPosition[1] == firstRowPosition[2]) {
			// checks to make sure ' ' isn't occupying the space
			if (firstRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + firstRowPosition[1] + " Wins!");
				tie = false;
			}
		}
		// horizontal 2nd row case
		if (secondRowPosition[0] == secondRowPosition[1] && secondRowPosition[1] == secondRowPosition[2]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[1] + " Wins!");
				tie = false;
			}
		}
		// horizontal 3rd row case
		if (thirdRowPosition[0] == thirdRowPosition[1] && thirdRowPosition[1] == thirdRowPosition[2]) {
			// checks to make sure ' ' isn't occupying the space
			if (thirdRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + thirdRowPosition[1] + " Wins!");
				tie = false;
			}
		}
		// vertical 1st column case
		if (firstRowPosition[0] == secondRowPosition[0] && secondRowPosition[0] == thirdRowPosition[0]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[0] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[0] + " Wins!");
				tie = false;
			}
		}
		// vertical 2nd column case
		if (firstRowPosition[1] == secondRowPosition[1] && secondRowPosition[1] == thirdRowPosition[1]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[1] + " Wins!");
				tie = false;
			}
		}
		// vertical 3rd column case
		if (firstRowPosition[2] == secondRowPosition[2] && secondRowPosition[2] == thirdRowPosition[2]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[2] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[2] + " Wins!");
				tie = false;
			}
		}
		// diagonal from top left to bottom right
		if (firstRowPosition[0] == secondRowPosition[1] && secondRowPosition[1] == thirdRowPosition[2]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[1] + " Wins!");
				tie = false;
			}
		}
		// diagonal from top right to bottom left
		if (firstRowPosition[2] == secondRowPosition[1] && secondRowPosition[1] == thirdRowPosition[0]) {
			// checks to make sure ' ' isn't occupying the space
			if (secondRowPosition[1] != ' ') {
				System.out.println("\nPlayer " + secondRowPosition[1] + " Wins!");
				tie = false;
			}
		}
	}

	public void isFull() {
		// checks if enough moves have been made to fill the board
		if (moveCount == 9) {
			System.out.println("\nBoard is Full");
			// checks if someone won the game already or not
			if (tie) {
				System.out.println("\nYou tied");
			}
			this.full = true;
		}
	}

	// used to access a specific marker on the board
	public char getMarker(int row, int column) {
		// checks if user wanted row 1, and which column to choose
		if (row == 1) {
			return this.firstRowPosition[column - 1];
		}
		// checks if user wanted row 2, and which column to choose
		else if (row == 2) {
			return this.secondRowPosition[column - 1];
		}
		// checks if user wanted row 3
		// (implied that input for row will be between 1 and 3 (inclusive))
		// and which column to choose
		else {
			return this.thirdRowPosition[column - 1];
		}
	}

	// used to mutate a specific marker on the board
	public void setMarker(int row, int column, char marker) {
		// checks if user wanted to somewhere within row 1 and sets the desired
		// column in row 1
		// to the desired marker
		if (row == 1) {
			this.firstRowPosition[column - 1] = marker;
		}
		// checks if user wanted to somewhere within row 2 and sets the desired
		// column in row 2
		// to the desired marker
		else if (row == 2) {
			this.secondRowPosition[column - 1] = marker;
		}
		// checks if user wanted to somewhere within row 3 and sets the desired
		// column in row 3
		// to the desired marker
		// (implied that input for row will be between 1 and 3 (inclusive))
		else {
			this.thirdRowPosition[column - 1] = marker;
		}
	}

	// used to access the value of the moveCount variable
	public int getMoveCount() {
		return moveCount;
	}

	// used to access the value of the tie variable
	public boolean getTie() {
		return this.tie;
	}

	// used to access the value of the invalidMove variable
	public boolean getInvalidMove() {
		return this.invalidMove;
	}

	// used to access the value of the full variable
	public boolean getFull() {
		return this.full;
	}

	// used to change the value of the moveCount variable
	public void setMoveCount(int desiredMoves) {
		moveCount = desiredMoves;
	}

	// used to change the value of the tie variable
	public void setTie(boolean isTie) {
		this.tie = isTie;
	}

	// used to change the value of the invalidMove variable
	public void setInvalidMove(boolean isInvalid) {
		this.invalidMove = isInvalid;
	}

	// used to change the value of the full variable
	public void setFull(boolean fullBoard) {
		this.full = fullBoard;
	}
}
