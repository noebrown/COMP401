package a4;

public class PositionImpl implements Position {

	private int x;
	private int y;

	public PositionImpl(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;

	}

	/*
	 * getManhattanDistanceTo(Position p) Calculates the "Manhattan" distance
	 * between two positions. The Manhattan distance is simply the absolute
	 * difference in x positions summed with the absolute difference in y positions.
	 */
	
	// THIS IS INCOREECT 
	public int getManhattanDistanceTo (Position other){
		return (Math.abs(other.getX() - getX()) + Math.abs(other.getY() - getY()));
		}
}
