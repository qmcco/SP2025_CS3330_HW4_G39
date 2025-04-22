package hw4.maze.test;

import java.util.ArrayList;

public class Grid {
	private ArrayList<Row> rows;
	
	public Grid(ArrayList<Row> rows) {
		for(int i = 0; i < rows.size(); i++) {
			this.rows.add(rows.get(i));
		}
	}
	
	public ArrayList<Row> getRows(){
		return rows;
	}
	
	public void setRows(ArrayList<Row> newRows) {
		this.rows.clear();
		for(int i = 0; i < newRows.size(); i++) {
			this.rows.add(newRows.get(i));
		}
	}
}
