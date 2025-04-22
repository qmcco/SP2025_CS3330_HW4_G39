package hw4.maze;

public class Cell {
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	private int wallCount;
	
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
	
	public CellComponents getUp() {
		return up;
	}
	
	public void setUp(CellComponents newUp) {
		if(this.up == CellComponents.WALL) {
			wallCount--;
		}
		if(newUp == CellComponents.WALL) {
			wallCount++;
		}
		this.up = newUp;
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
		this.down = newDown;
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
		this.left = newLeft;
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
		this.right = newRight;
	}
	public int getWallCount() {
		return wallCount;
	}
	
	
}
