 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Hr extends EnterUser {

	 private JFrame frame1  ; 


JFrame frame = new JFrame("HR");

Hr()	
{ 
    // creating instance of JFrame with name "first way" 
    frame=new JFrame("HR"); 
      
    // creates instance of JButton 
    JButton button = new JButton("עדכון עובד"); 
    
    button.setBounds(369, 442, 90, 50); 
    // setting close operation 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // adds button in JFrame 
    frame.getContentPane().add(button); 
    // sets 500 width and 600 height 
    frame.setSize(500, 600); 
    // uses no layout managers 
    frame.getContentPane().setLayout(null); 
    // makes the frame visible 
    frame.setVisible(true); 
    
}

  
public static void main(String[] args) 
{ 
    new Hr(); 
}
}
		
		
		
		
	


	

