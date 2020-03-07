package board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class UnveilTests {
	
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
		
		testBoard = new Board(10, testSquares);
		
	}
	
	
	/*
	 * GIVEN: board with all squares hidden
	 * WHEN: calling a unveil method
	 * THEN: every square is open
	 */
	@Test
	public void squaresHiddenTest() {
		
		testBoard.unveil();
		int counter = 0;
		
		for(int i = 0; i<testBoard.getSquaresForTest().length; i++) {
			for(int j = 0; j<testBoard.getSquaresForTest().length; j++) {
				
				if(!testBoard.getSquaresForTest()[i][j].isOpen()) {
					counter++;
				}
				
			}
		}
		
		assertEquals(0, counter);
		
	}
	
	/*
	 * GIVEN: board with some squares flagged
	 * WHEN: calling a unveil method
	 * THEN: every square is open
	 */
	@Test
	public void squaresFlaggedTest() {
		
		testSquares[0][0].flag();
		testSquares[1][1].flag();
		testSquares[2][2].flag();
		
		testBoard.unveil();
		int counter = 0;
		
		for(int i = 0; i<testBoard.getSquaresForTest().length; i++) {
			for(int j = 0; j<testBoard.getSquaresForTest().length; j++) {
				
				if(!testBoard.getSquaresForTest()[i][j].isOpen()) {
					counter++;
				}
				
			}
		}
		
		assertEquals(0, counter);
		
	}
	
	
	/*
	 * GIVEN: board with some squares opened
	 * WHEN: calling a unveil method
	 * THEN: every square is open
	 */
	@Test
	public void squaresRevealedTest() {
		
		testBoard.getSquaresForTest()[0][0].open();
		testBoard.getSquaresForTest()[1][1].open();
		testBoard.getSquaresForTest()[2][2].open();
		
		testBoard.unveil();
		int counter = 0;
		
		for(int i = 0; i<testBoard.getSquaresForTest().length; i++) {
			for(int j = 0; j<testBoard.getSquaresForTest().length; j++) {
				
				if(!testBoard.getSquaresForTest()[i][j].isOpen()) {
					counter++;
				}
				
			}
		}
		
		assertEquals(0, counter);
		
	}
	
	
}
