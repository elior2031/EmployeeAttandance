

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;


public class Data extends FrameClock{
	
	private static int ID;
	private static String Pass;
	private static Stack <JFrame> frames = new Stack();

	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID =ID;
	}
	
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	public String getDate() {
		return super.getDate();
	}
	
	public String getTime() {
		return super.getTime();
	}

	public void addFrame(JFrame frame)
	{
		frames.push(frame);
	}
	public JFrame getFrameLast()
	{
		if(frames.isEmpty())
			return null;
		return frames.pop();
	}

	
	
	
}
