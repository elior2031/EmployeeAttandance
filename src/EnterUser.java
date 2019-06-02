

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterUser {

//	private JFrame frame;
	JButton btnExit;
	JButton btnEnter;
	JButton btnManage;
	JButton btnBack;
	Login login;
	Data d;
	private JFrame frame = new JFrame();
	
	
	private ConnectSql conector = null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public EnterUser() {
		new FrameClock(frame);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frame = new JFrame();
		frame.setBounds(270, 60, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);*/
		
		conector = new ConnectSql();
		
		btnExit = new JButton("יציאה");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conector = new ConnectSql();
				if(conector.EnterExit(2)==true)
					JOptionPane.showMessageDialog(frame,"בוצע יציאה");
				else
					JOptionPane.showMessageDialog(frame,"לא בוצע יציאה משום שיש כבר יציאה היום ללא כניסה");	
			}
		});
		btnExit.setBounds(700, 100, 250, 100);
		frame.getContentPane().add(btnExit);
		
		btnEnter = new JButton("כניסה");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conector = new ConnectSql();
				if(conector.EnterExit(1)==true)
					JOptionPane.showMessageDialog(frame,"בוצע כניסה");
				else
					JOptionPane.showMessageDialog(frame,"לא בוצע כניסה משום שיש כבר כניסה היום במערכת ללא יציאה");
				
			}
		});
		btnEnter.setBounds(1050, 100, 250, 100);
		frame.getContentPane().add(btnEnter);
		
		btnManage = new JButton("ניהול נוכחות");
		btnManage.setBounds(700, 270, 600, 100);
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conector=new ConnectSql();
				conector.createTimeForUser();
				d=new Data();
				d.getTimeForUser();
			}
		});
		frame.getContentPane().add(btnManage);
		
		btnBack = new JButton("חזרה למסך ראשי");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	login = /*new Login();*/d.
				//login.getFrame().setVisible(true);
				d=new Data();
				frame.setVisible(false);
				frame = d.getFrameLast();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(100, 700, 300, 100);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
		
	}
}
