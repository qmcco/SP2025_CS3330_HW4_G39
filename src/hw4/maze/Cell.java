package hw4.maze;
/**
 * class to represent individual cells of the game board
 */
public class Cell {
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	private int wallCount;
	/**
	 * constructor keeps track of the number of walls in the cell to be used in the Game random grid generation
	 * @param left component to the left of the cell
	 * @param right component to the right of the cell
	 * @param up component above the cell
	 * @param down component below the cell
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		if(up == CellComponents.WALL) {
			wallCount++;
		}
		if(down == CellComponents.WALL) {
			wallCount++;
		}
		if(left == CellComponents.WALL) {
			wallCount++;
		}
		if(right == CellComponents.WALL) {
			wallCount++;
		}
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	/**
	 * get up value
	 * @return up
	 */
	public CellComponents getUp() {
		return up;
	}
	/**
	 * if the changed up value is a wall, subtract from count, if the new value is a wall, add to count, if the new value is null, set up to Wall
	 * @param newUp new value of up
	 */
	public void setUp(CellComponents newUp) {
		if(this.up == CellComponents.WALL) {
			wallCount--;
		}
		if(newUp == CellComponents.WALL) {
			wallCount++;
		}
		if(newUp != null) {
			this.up = newUp;
		}
		else {
			this.up = CellComponents.WALL;
			wallCount++;
		}
	}
	
	public CellComponents getDown() {
		return down;
	}
	
	public void setDown(CellComponents newDown) {
		if(this.down == CellComponents.WALL) {
			wallCount--;
		}
		if(newDown == CellComponents.WALL) {
			wallCount++;
		}
		if(newDown != null) {
			this.down = newDown;
		}
		else {
			this.down = CellComponents.WALL;
			wallCount++;
		}
	}
	
	public CellComponents getLeft() {
		return left;
	}
	
	public void setLeft(CellComponents newLeft) {
		if(this.left == CellComponents.WALL) {
			wallCount--;
		}
		if(newLeft == CellComponents.WALL) {
			wallCount++;
		}
		if(newLeft != null) {
			this.left = newLeft;
		}
		else {
			this.left = CellComponents.WALL;
			wallCount++;
		}
	}
	
	public CellComponents getRight() {
		return right;
	}
	
	public void setRight(CellComponents newRight) {
		if(this.right == CellComponents.WALL) {
			wallCount--;
		}
		if(newRight == CellComponents.WALL) {
			wallCount++;
		}
		if(newRight != null) {
			this.right = newRight;
		}
		else {
			this.right = CellComponents.WALL;
			wallCount++;
		}
	}
	public int getWallCount() {
		return wallCount;
	}
	/**
	 * string representation of a cell and its components
	 */
	@Override
	public String toString() {
		return "Cell [left=" + this.getLeft() + ", right=" + this.getRight() + ", up=" + this.getUp() + ", down=" + this.getDown() + "]";
	}
	
}
