

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
		
		btnExit = new JButton("�����");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conector = new ConnectSql();
				if(conector.EnterExit(2)==true)
					JOptionPane.showMessageDialog(frame,"���� �����");
				else
					JOptionPane.showMessageDialog(frame,"�� ���� ����� ���� ��� ��� ����� ���� ��� �����");	
			}
		});
		btnExit.setBounds(700, 100, 250, 100);
		frame.getContentPane().add(btnExit);
		
		btnEnter = new JButton("�����");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conector = new ConnectSql();
				if(conector.EnterExit(1)==true)
					JOptionPane.showMessageDialog(frame,"���� �����");
				else
					JOptionPane.showMessageDialog(frame,"�� ���� ����� ���� ��� ��� ����� ���� ������ ��� �����");
				
			}
		});
		btnEnter.setBounds(1050, 100, 250, 100);
		frame.getContentPane().add(btnEnter);
		
		btnManage = new JButton("����� ������");
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
		
		btnBack = new JButton("���� ���� ����");
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
