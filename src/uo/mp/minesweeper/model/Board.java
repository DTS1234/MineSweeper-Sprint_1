package uo.mp.minesweeper.model;

import java.util.Random;

import uo.mp.minesweeper.utilities.CheckParameters;
import uo.mp.minesweeper.utilities.Constants;
import uo.mp.minesweeper.utilities.StateOfTheGame;

public class Board {

	private Square[][] board;
	private StateOfTheGame state;
	private int mines;
	private int flagsLeft;

	public Board(int height, int width, int percentage) {
		CheckParameters.check(height, width);
		
		board = new Square[height][width];
		setState(StateOfTheGame.PLAYING);
		mines = (int) ((height * width) * percentage / 100);
		flagsLeft = mines;
		initBoard();
		armBoard(mines, height, width);
		fullFillBoard();
	
	}

	public Board(int mines, Square[][] squares) {

		board = squares;
		setState(StateOfTheGame.PLAYING);
		this.mines = mines;
		flagsLeft = mines;
		
		fullFillBoard();

	}

	private void armBoard(int mines, int height, int width) {

		for (int i = 0; i < mines; i++) {
			Random randomGen = new Random();
			int randomRow = randomGen.nextInt(height - 1);
			int randomCol = randomGen.nextInt(width - 1);
			board[randomRow][randomCol].putMine();
		}
	}

	private void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Square(0);
			}
		}
	}

	private void fullFillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Square(calculateSquareValue(i, j));
			}
		}
	}

	public boolean isExploded(int x, int y) {

		CheckParameters.check(x);
		CheckParameters.check(y);

		if (board[x][y].hasMine() && board[x][y].isOpen()) {
			return true;
		}

		return false;
	}

	public void stepOn(int x, int y) {

		CheckParameters.check(x);
		CheckParameters.check(y);

		board[x][y].stepOn();

	}

	public void flag(int x, int y) {

		CheckParameters.check(x);
		CheckParameters.check(y);

		if (!board[x][y].hasFlag() && !board[x][y].isOpen()) {
			board[x][y].flag();
			flagsLeft--;

			if (board[x][y].hasMine() && board[x][y].hasFlag()) {
				mines--;
			}

		}

	}

	public void unflag(int x, int y) {

		CheckParameters.check(x);
		CheckParameters.check(y);

		if (board[x][y].hasFlag()) {
			board[x][y].unflag();
			flagsLeft++;
		}

	}

	public void unveil() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j].open();
			}
		}
	}

	public int getFlagsLeft() {
		return this.flagsLeft;
	}

	public int getMinesLeft() {
		return this.mines;
	}

	public void markAsExploded() {
		this.setState(StateOfTheGame.LOST);
	}

	public char[][] getStatus() {

		char[][] charArray = new char[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				switch (board[i][j].getState()) {
				case CLOSED:
					charArray[i][j] = Constants.unrevealedChar;
					break;
				case FLAGGED:
					charArray[i][j] = Constants.armedChar;
					break;
				case OPEN:
					if (board[i][j].hasMine()) {
						charArray[i][j] = Constants.revealedMineChar;
					} else if (board[i][j].getSquareValue() != 0) {
						charArray[i][j] = (char) (board[i][j].getSquareValue() + '0');
					} else {
						charArray[i][j] = Constants.blankChar;
					}
					break;
				}

			}
		}

		return charArray;

	}

	// TO CHANGE !!!
	public Square[][] getSquaresForTest() {

		/*
		 * for (int i = 0; i < board.length; i++) { for (int j = 0; j < board[0].length;
		 * j++) {
		 * 
		 * System.out.print("[" + board[i][j].getSquareValue() + "]");
		 * 
		 * } System.out.println(); }
		 */
		
		return this.board;
	}

	public StateOfTheGame getState() {
		return state;
	}

	public void setState(StateOfTheGame state) {
		this.state = state;
	}

	private int calculateSquareValue(int x, int y) {

		CheckParameters.check(y);
		CheckParameters.check(x);
		
		if(board[x][y].hasMine()) {
			return -1;
		}
		
		int up = y + 1;
		int down = y - 1;
		int left = x - 1;
		int right = x + 1;

		int squareValue = 0;

		for (int i = left; i <= right; i++) {
			for (int j = down; j <= up; j++) {
				if (i >= 0 && j >= 0 && i < board.length 
					&& j < board.length && board[i][j].hasMine()) {
					squareValue++;
				}
			}
		}		

		return squareValue;

	}

}
