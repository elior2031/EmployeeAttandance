
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Formatter;
import java.awt.Window.Type;

public class FrameClock  {

	private JPanel contentPane;
	JLabel lblDate;
	JLabel lblTime;
	protected JFrame frame;
	
	
	/**
	 * Create the frame.
	*/ 
	public FrameClock() {
		frame = new JFrame();
		frame.setTitle("ניהול נוכחות");
		//frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(270, 60, 1400, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.getContentPane().setLayout(null);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.BOLD, 18));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(118, 112, 218, 95);
		contentPane.add(lblDate);

		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.BOLD, 18));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(118, 337, 218, 95);
		contentPane.add(lblTime);
		showDate();
		showTime();
	}

	private void showDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		lblDate.setText(s.format(d));
	}

	private void showTime() {
		new Timer(0,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date d= new Date();
				SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
				lblTime.setText(s.format(d));
			}
		}).start();
	}
	
	public String getDate() {
		Date t = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(t);
	}
	
	public String getTime() {
		Date t = new Date();
		Format formatter = new SimpleDateFormat("HHmmss");
		return formatter.format(t);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
