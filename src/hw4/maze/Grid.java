package hw4.maze;

import java.util.ArrayList;
/**
 * represents the grid board of the game
 */
public class Grid {
	private ArrayList<Row> rows;
	/**
	 * constructor, given a list of Row values, set rows equal to that list
	 * @param rows list or Row elements to set this.rows equal to
	 */
	public Grid(ArrayList<Row> rows) {
		if(rows != null) {
			this.rows = new ArrayList<Row>();
			for(int i = 0; i < rows.size(); i++) {
				this.rows.add(rows.get(i));
			}
		}
		else {
			this.rows = null;
		}
	}
	
	public ArrayList<Row> getRows(){
		return rows;
	}
	/**
	 * given the new list of Row elements is not null, set this.rows equal to it, otherwise set this.rows equal to null
	 * @param newRows list or Row elements to set this.rows equal to
	 */
	public void setRows(ArrayList<Row> newRows) {
		this.rows.clear();
		if(newRows != null) {
			for(int i = 0; i < newRows.size(); i++) {
				this.rows.add(newRows.get(i));
			}
		}
		else {
			this.rows = null;
		}
	}
	/**
	 * represent the Grid as well as the internal rows and cells as a string
	 */
	@Override
	public String toString() {
		String retString = "Grid [rows=[";
		for(int i = 0; i < this.getRows().size(); i++) {
			retString = retString + this.getRows().get(i).toString();
			if(this.getRows().size()-1 != i) {
				retString = retString + ", ";
			}
		}
		retString = retString + "]]";
		return retString;
	}
}
