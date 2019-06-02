

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnterSystem  {

	//private JFrame frame;
	
	JButton btnAddUsers;
	ConnectSql con = null;
	private JTextField txtName;
	private JPasswordField Pass;
	private JTextField txtAdmin;
	private JTextField txtPermission;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtBirthday;
	private JLabel lblnote;
	private JLabel lblnote_1;
	private JButton btnBack;
	private Data d;
	private JFrame frame = new JFrame();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public EnterSystem() {
		new FrameClock(frame);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	//	frame = new JFrame();
		frame.setBounds(270, 60, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddUsers = new JButton("הוספת עובד חדש");
		btnAddUsers.addActionListener(new ActionListener() {//צריך לוודא שמה שקיבלנו תקין!!!
			public void actionPerformed(ActionEvent e) {
				con = new ConnectSql();
				if(txtName.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר שם עובד\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(Pass.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר סיסמא\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtAdmin.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר מנהל\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(con.IsHaveUser(Integer.parseInt(txtAdmin.getText()))==false)
					JOptionPane.showMessageDialog(frame,"לא קיים עובד כזה במערכת", "שגיאה", 0);
				else if(txtPermission.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר הרשאה\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtAddress.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר כתובת\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtPhone.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר טלפון\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtPhone.getText().length()!=10)
					JOptionPane.showMessageDialog(frame,"מס' טלפון לא תקין", "שגיאה", 0);
				else if(txtBirthday.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר תאריך לידה\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtBirthday.getText().length()!=8)
					JOptionPane.showMessageDialog(frame,"תאריך לידה לא לפי הפורמט", "שגיאה", 0);//
				
				else{
						int ret = con.AddNewUser(txtName.getText(), Pass.getText(), Integer.parseInt(txtAdmin.getText()),
								Integer.parseInt(txtPermission.getText()),txtAddress.getText(), txtPhone.getText(),txtBirthday.getText()); 
						if(ret >-1){
							if(Integer.parseInt(txtPermission.getText())==1)
									JOptionPane.showMessageDialog(frame,"בוצע הקמת עובד מס'"+ret+" סיסמא:"+Pass.getText()+" הרשאת יוזר");
							else if(Integer.parseInt(txtPermission.getText())==2)
									JOptionPane.showMessageDialog(frame,"בוצע הקמת עובד מס'"+ret+" סיסמא:"+Pass.getText()+" הרשאת מנהל");
								else
									JOptionPane.showMessageDialog(frame,"בוצע הקמת עובד מס'"+ret+" סיסמא:"+Pass.getText()+" הרשאת HR");
						}
							
						else
							JOptionPane.showMessageDialog(frame,"לא בוצע הקמת עובד חדש");
				}
			}
				
		});
		btnAddUsers.setBounds(627, 541, 600, 100);
		frame.getContentPane().add(btnAddUsers);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar()== KeyEvent.VK_ENTER)
					Pass.requestFocus();
			}

		});
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setBounds(529, 277, 127, 34);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		Pass = new JPasswordField();
		Pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar()== KeyEvent.VK_ENTER)
					txtAdmin.requestFocus();
			}

		});
		Pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pass.setBounds(691, 277, 127, 34);
		frame.getContentPane().add(Pass);
		
		txtAdmin = new JTextField();
		txtAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )|| c== KeyEvent.VK_ENTER)
					if (c== KeyEvent.VK_ENTER)
						txtPermission.requestFocus();
					else
						e.consume();
				
			}

		});
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAdmin.setColumns(10);
		txtAdmin.setBounds(854, 277, 127, 34);
		frame.getContentPane().add(txtAdmin);
		
		txtPermission = new JTextField();
		txtPermission.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if((e.getKeyChar()>KeyEvent.VK_0 && e.getKeyChar()<KeyEvent.VK_4)|| e.getKeyChar()== KeyEvent.VK_ENTER) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER)
						txtAddress.requestFocus();
					if(!txtPermission.getText().isEmpty())
						txtPermission.setText(null);
				}
				else 
					e.consume();
				
			}

		});
		txtPermission.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPermission.setColumns(10);
		txtPermission.setBounds(1021, 277, 127, 34);
		frame.getContentPane().add(txtPermission);
		
		txtAddress = new JTextField();
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar()== KeyEvent.VK_ENTER)
					txtPhone.requestFocus();
			}
		});
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(1185, 277, 127, 34);
		frame.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )|| c== KeyEvent.VK_ENTER)
					if (c== KeyEvent.VK_ENTER)
						txtBirthday.requestFocus();
					else
						e.consume();
				
			}

		});
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPhone.setColumns(10);
		txtPhone.setBounds(691, 399, 127, 34);
		frame.getContentPane().add(txtPhone);
		
		txtBirthday = new JTextField();
		txtBirthday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )|| c== KeyEvent.VK_ENTER)
					if (c== KeyEvent.VK_ENTER)
						btnAddUsers.requestFocus();
					else
						e.consume();
				
			}

		});
		txtBirthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(1021, 399, 127, 34);
		frame.getContentPane().add(txtBirthday);
		
		JLabel lblName = new JLabel("שם עובד");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(552, 247, 83, 29);
		frame.getContentPane().add(lblName);
		
		JLabel lblPass = new JLabel("סיסמא");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPass.setBounds(727, 247, 67, 29);
		frame.getContentPane().add(lblPass);
		
		JLabel lblAdmin = new JLabel("מנהל");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setBounds(893, 247, 55, 29);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblPermission = new JLabel("קוד הרשאה");
		lblPermission.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPermission.setBounds(1030, 247, 108, 29);
		frame.getContentPane().add(lblPermission);
		
		JLabel lblAdrdess = new JLabel("כתובת");
		lblAdrdess.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdrdess.setBounds(1214, 247, 67, 29);
		frame.getContentPane().add(lblAdrdess);
		
		JLabel lblPhone = new JLabel("מס' טלפון");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(713, 369, 90, 29);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblBrthday = new JLabel("תאריך לידה");
		lblBrthday.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBrthday.setBounds(1030, 369, 108, 29);
		frame.getContentPane().add(lblBrthday);
		
		lblnote = new JLabel("קודי הרשאות:");
		lblnote.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnote.setBounds(1034, 137, 127, 34);
		frame.getContentPane().add(lblnote);
		
		lblnote_1 = new JLabel("1-יוזר,2-מנהל,3-HR");
		lblnote_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnote_1.setBounds(1021, 156, 164, 34);
		frame.getContentPane().add(lblnote_1);
		
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
		
		JLabel lblBD = new JLabel("\u05E4\u05D5\u05E8\u05DE\u05D8 \u05DC\u05EA.\u05DC\u05D9\u05D3\u05D4:");
		lblBD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBD.setBounds(1185, 377, 127, 34);
		frame.getContentPane().add(lblBD);
		
		JLabel lblbd = new JLabel("ddmmyyyy");
		lblbd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblbd.setBounds(1195, 400, 83, 34);
		frame.getContentPane().add(lblbd);
	}

	public JFrame getFrame() {
		return frame;
	}
}
