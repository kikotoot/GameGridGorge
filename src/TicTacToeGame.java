

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TicTacToe ttt = new TicTacToe();
		ttt.StartGame();
		ttt.drawBoard();
		while (ttt.getTie() && !ttt.getFull()) {
			ttt.pXTurn(sc.nextInt(), sc.nextInt());
			ttt.drawBoard();
			ttt.isWinner();
			ttt.isFull();
			ttt.pOTurn(sc.nextInt(), sc.nextInt());
			ttt.drawBoard();
			ttt.isWinner();
			ttt.isFull();
		}

	}

}
