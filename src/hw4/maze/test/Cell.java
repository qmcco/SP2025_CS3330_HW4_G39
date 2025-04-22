package hw4.maze.test;

public class Cell {
	private CellComponents up = null;
	private CellComponents down = null;
	private CellComponents left = null;
	private CellComponents right = null;
	
	public Cell(CellComponents up, CellComponents down, CellComponents left, CellComponents right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	public CellComponents getUp() {
		return up;
	}
	
	public void setUp(CellComponents newUp) {
		this.up = newUp;
	}
	
	public CellComponents getDown() {
		return down;
	}
	
	public void setDown(CellComponents newDown) {
		this.down = newDown;
	}
	
	public CellComponents getLeft() {
		return left;
	}
	
	public void setLeft(CellComponents newLeft) {
		this.left = newLeft;
	}
	
	public CellComponents getRight() {
		return right;
	}
	
	public void setRight(CellComponents newRight) {
		this.right = newRight;
	}
	
	
}
