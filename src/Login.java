
/*
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;*/

import java.awt.EventQueue;
//import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;

import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;



public class Login extends FrameClock {

	private JLabel lblEmp;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private JTextField txtEmp;
	private JButton btnEnter;
	private EnterUser EU=null;
	private EnterSystem ES=null;

	private ConnectSql conector = null;
	private Data d = null;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		super.getFrame().setVisible(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//d= new Data();
		txtEmp = new JTextField(10);
		txtEmp.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmp.setBounds(932, 180, 128, 33);

		txtEmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )|| c== KeyEvent.VK_ENTER)
					if (c== KeyEvent.VK_ENTER)
						txtPass.requestFocus();
					else
						e.consume();
				
			}

		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtEmp);
		txtEmp.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPass.setBounds(932, 300, 128, 33);
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnEnter.requestFocus();

			}
		});
		txtPass.setColumns(10);
		frame.getContentPane().add(txtPass);
		

		btnEnter = new JButton("אישור");
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 18));
//
		btnEnter.setBounds(678, 468, 232, 72);
		
		btnEnter.addActionListener(new ActionListener() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					processEnterButton();
			}
			public void actionPerformed(ActionEvent e) {
				processEnterButton();
			}
				

		});
		
		frame.getContentPane().add(btnEnter);

		lblEmp = new JLabel("מס' עובד:");
		lblEmp.setBounds(1085, 180, 120, 33);
		lblEmp.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblEmp);

		lblPass = new JLabel("סיסמא:");
		lblPass.setBounds(1085, 300, 120, 33);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblPass);

	}

	
	void processEnterButton() {
		System.out.println("clicked");
		
		d=new Data();
		d.setID(Integer.parseInt(txtEmp.getText()));
		d.setPass(txtPass.getText());
		txtPass.setText(null);
		
		
		conector = new ConnectSql();
		
		switch (conector.connect()) {
		case -1:
			JOptionPane.showMessageDialog(frame,"מס' עובד או סיסמא אינם תקינים", "שגיאה", 0);// 0-X 1-!
			break;
		case 0:
			JOptionPane.showMessageDialog(frame,"עובד לא פעיל", "שגיאה", 1);// 0-X 1-!
			break;
		case 1:
			JOptionPane.showMessageDialog(frame,"כניסה של יוזר רגיל", "שגיאה", 0);// 0-X 1-!
			EU = new EnterUser();
			EU.getFrame().setVisible(true);
			d.addFrame(frame);
			frame.setVisible(false);
			break;
		case 2:
			JOptionPane.showMessageDialog(frame,"כניסה של מנהל", "שגיאה", 1);// 0-X 1-!
			break;
		case 3:
			JOptionPane.showMessageDialog(frame,"כניסה של HR", "שגיאה", 0);// 0-X 1-!
			break;
		case 4:
			JOptionPane.showMessageDialog(frame,"כניסה של מנהל מערכת", "שגיאה", 1);// 0-X 1-!
			ES = new EnterSystem();
			ES.getFrame().setVisible(true);
			d= new Data();
			d.addFrame(frame);
			frame.setVisible(false);
			break;

			
			
		default:
			break;
		}
	}


}
