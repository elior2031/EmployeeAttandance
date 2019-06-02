
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;

public class Data {

	private static int ID;
	private static String Pass;
	private static Stack<JFrame> frames = new Stack();
	private static ArrayList<TimeEmployee> Times = new ArrayList();
	private TimeEmployee TE;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getDate() {
		return FrameClock.getDate();
	}

	public String getTime() {
		return FrameClock.getTime();
	}

	public void addFrame(JFrame frame) {
		frames.push(frame);
	}

	public JFrame getFrameLast() {
		setPass(null);
		if (frames.isEmpty())
			return null;
		return frames.pop();
	}

	public void getTimeForUser() {
		// TODO Auto-generated method stub
		TimeEmployee t;
		for (int i = 0; i < Times.size(); i++) {
			System.out.println(Times.get(i).getID());
			System.out.println(Times.get(i).getTime());
			System.out.println(Times.get(i).getDate());
			System.out.println(Times.get(i).getMovement());
			System.out.println();

		}
	}

	public void addTime(int ID, String date, String time, int mov) {
		// TODO Auto-generated method stub
		TE = new TimeEmployee();
		TE.setID(ID);
		TE.setDate(date);
		TE.setTime(time);
		TE.setMovment(mov);
		Times.add(TE);
	}

}
