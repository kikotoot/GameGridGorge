import java.util.Scanner;
public class GridGamesAboundHere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("choose a game, 1 for tic tac toe, 2 for worm hole");
		int gameToPlay = sc.nextInt();
		if(gameToPlay == 1){
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

}
