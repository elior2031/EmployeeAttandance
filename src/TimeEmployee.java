import java.util.Stack;

import javax.swing.JFrame;

public class TimeEmployee {
	private int ID;
	private String Date;
	private String Time;
	private int movement;

	public TimeEmployee() {
		
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public void setDate(String date) {
		Date = date;
	}
	public void setTime(String time) {
		Time = time;
	}
	public void setMovment(int mov) {
		movement=mov;
	}
	
	public int getID() {
		return ID;
	}
	public String getDate() {
		return Date;
	}
	public String getTime() {
		return Time;
	}
	public int getMovement() {
		return movement;
	}
	
}
