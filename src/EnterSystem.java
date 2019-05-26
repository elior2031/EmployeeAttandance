

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

public class EnterSystem extends FrameClock {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterSystem window = new EnterSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnterSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		frame.setBounds(270, 60, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddUsers = new JButton("הוספת עובד חדש");
		btnAddUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ConnectSql();
				if(txtName.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר שם עובד\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(Pass.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר סיסמא\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtAdmin.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר מנהל\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtPermission.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר הרשאה\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtAddress.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר כתובת\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtPhone.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר טלפון\n לא בוצע הקמת עובד", "שגיאה", 0);
				else if(txtBirthday.getText().contentEquals("")) 
					JOptionPane.showMessageDialog(frame,"חסר תאריך לידה\n לא בוצע הקמת עובד", "שגיאה", 0);
				
				else if(con.AddNewUser(txtName.getText(), Pass.getText(), Integer.parseInt(txtAdmin.getText()), 
						Integer.parseInt(txtPermission.getText()),txtAddress.getText(), txtPhone.getText(), 
						txtBirthday.getText())== true)
					JOptionPane.showMessageDialog(frame,"בוצע הקמת עובד חדש");
				else
					JOptionPane.showMessageDialog(frame,"לא בוצע הקמת עובד חדש");
			}
		});
		btnAddUsers.setBounds(627, 541, 600, 100);
		frame.getContentPane().add(btnAddUsers);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setBounds(529, 277, 127, 34);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		Pass = new JPasswordField();
		Pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pass.setBounds(691, 277, 127, 34);
		frame.getContentPane().add(Pass);
		
		txtAdmin = new JTextField();
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAdmin.setColumns(10);
		txtAdmin.setBounds(854, 277, 127, 34);
		frame.getContentPane().add(txtAdmin);
		
		txtPermission = new JTextField();
		txtPermission.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPermission.setColumns(10);
		txtPermission.setBounds(1021, 277, 127, 34);
		frame.getContentPane().add(txtPermission);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(1185, 277, 127, 34);
		frame.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPhone.setColumns(10);
		txtPhone.setBounds(691, 399, 127, 34);
		frame.getContentPane().add(txtPhone);
		
		txtBirthday = new JTextField();
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
	}
}
