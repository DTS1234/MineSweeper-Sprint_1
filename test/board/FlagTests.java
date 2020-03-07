package board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class FlagTests {

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
		testBoard.getSquaresForTest()[1][1].putMine();
	}
	
	/*
	 * GIVEN: board square already flagged 
	 * WHEN: calling a flag method
	 * THEN: square is flagged
	 */
	@Test
	public void flagFlaggedTest() {
		
		testBoard.flag(0, 0);
		assertTrue(testBoard.getSquaresForTest()[0][0].hasFlag());		
		
	}
	
	/*
	 * GIVEN: board square unflagged and mined 
	 * WHEN: calling a flag method
	 * THEN: square is flagged
	 */
	@Test
	public void flagUnFlaggedMinedTest() {
		
		testBoard.flag(1, 1);
		assertTrue(testBoard.getSquaresForTest()[1][1].hasFlag());		
		
	}

	/*
	 * GIVEN: board square unflagged 
	 * WHEN: calling a flag method
	 * THEN: square is flagged
	 */
	@Test
	public void flagUnFlaggedTest() {
		
		testBoard.flag(2, 2);
		assertTrue(testBoard.getSquaresForTest()[2][2].hasFlag());		
		
	}
	
}
