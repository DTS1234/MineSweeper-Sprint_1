package uo.mp.minesweeper.model;

import uo.mp.minesweeper.utilities.CheckParameters;
import uo.mp.minesweeper.utilities.StateOfSquare;

public class Square {

	private StateOfSquare state;
	private int squareValue;

	public Square(int squareValue) {
		this.state = StateOfSquare.CLOSED;
		setSquareValue(squareValue);
	}

	public int getSquareValue() {
		return squareValue;
	}

	public void setSquareValue(int squareValue) {
		CheckParameters.check(squareValue);
		this.squareValue = squareValue;
	}

	public StateOfSquare getState() {
		return state;
	}

	public void open() {
		this.state = StateOfSquare.OPEN;
	}

	public void unflag() {
		
		if(this.state != StateOfSquare.OPEN)
			this.state = StateOfSquare.CLOSED;
	}
	
	public void flag() {
		
		if(this.state != StateOfSquare.OPEN)
			this.state = StateOfSquare.FLAGGED;
	}
	
	public void stepOn() {
		if(this.state == StateOfSquare.CLOSED) {
			this.state = StateOfSquare.OPEN;
		}
	}
	
	public boolean hasMine() {
		if(squareValue == -1) {
			return true;
		}
		return false;
	}
	
	public void putMine() {
		this.squareValue = -1;
	}
	
	public boolean hasFlag() {
		return this.state == StateOfSquare.FLAGGED;
	}
	
	public boolean isOpen() {
		return this.state == StateOfSquare.OPEN;

	}
}
