package hw4.maze;

import java.util.ArrayList;
/**
 * represents a row of cell values
 */
public class Row {
	private ArrayList<Cell> cells;
	/**
	 * constructor to set the list of cells equal to a provided list of cells
	 * @param cells provided list of cells
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>();
		for(int i = 0; i < cells.size(); i++) {
			this.cells.add(cells.get(i));
		}
	}
	
	public ArrayList<Cell> getCells(){
		return cells;
	}
	/**
	 * if the provided newCells list of cells is not null, set this.cells equal to it, otherwise set this.cells equal to null
	 * @param newCells new list of cells
	 */
	public void setCells(ArrayList<Cell> newCells) {
		this.cells.clear();
		if(newCells != null) {
			for(int i = 0; i < newCells.size(); i++) {
				this.cells.add(newCells.get(i));
			}
		}
		else {
			this.cells = null;
		}
	}
	/**
	 * represent the current row as well as its inner cells as a string
	 */
	@Override
	public String toString() {
		String retString = "Row [cells=[";
		for(int i = 0; i < this.getCells().size(); i++) {
			retString = retString + this.getCells().get(i).toString();
			if(this.getCells().size()-1 != i) {
				retString = retString + ", ";
			}
		}
		retString = retString + "]]";
		return retString;
	}
}
