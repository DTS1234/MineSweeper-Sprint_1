package board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class UnFlagTests {

	private Board testBoard;
	private Square[][] testSquares;
	
	@Before
	public void setUp() throws Exception {
		
		
		testSquares = new Square[9][9];
		
		for(int i = 0; i<testSquares.length; i++) {
			for(int j = 0; j<testSquares.length; j++) {
				testSquares[i][j] = new Square(0);
			}
		}
		
		testBoard = new Board(0, testSquares);
		testBoard.flag(0, 0);
		testBoard.getSquaresForTest()[0][0].putMine();
		testBoard.getSquaresForTest()[1][1].putMine();
		
	}
	
	
	/*
	 * GIVEN: board square already flagged and mined 
	 * WHEN: calling a unflag method
	 * THEN: square is unflagged
	 */
	@Test
	public void unFlagFlaggedTest() {
		
		testBoard.unflag(0, 0);
		assertFalse(testBoard.getSquaresForTest()[0][0].hasFlag());
		
	}
	
	/*
	 * GIVEN: board square unflagged and mined 
	 * WHEN: calling a unflag method
	 * THEN: square is unflagged
	 */
	@Test
	public void unFlagUnFlaggedMinedTest() {
		
		testBoard.unflag(1, 1);
		assertFalse(testBoard.getSquaresForTest()[1][1].hasFlag());
		
	}
	
	/*
	 * GIVEN: board square unflagged 
	 * WHEN: calling a unflag method
	 * THEN: square is unflagged
	 */
	@Test
	public void unFlagUnFlaggedTest() {
		
		testBoard.unflag(2, 2);
		assertFalse(testBoard.getSquaresForTest()[2][2].hasFlag());
		
	}

}
