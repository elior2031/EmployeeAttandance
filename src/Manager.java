import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Manager extends EnterUser {

JFrame frame = super.getFrame();

Manager()	
{ 
    // creating instance of JFrame with name "first way" 

    // get EnterUser PAGE;
				btnExit.setBounds(700, 100, 250, 100);
				frame.getContentPane().add(btnExit);
				btnEnter.setBounds(1050, 100, 250, 100);
				frame.getContentPane().add(btnEnter);
				btnManage.setBounds(700, 270, 600, 100);
				frame.getContentPane().add(btnManage);
				btnBack.setBounds(100, 700, 300, 100);
				frame.getContentPane().add(btnBack);
   
      
    // creates instance of JButton 
    JButton button = new JButton("ניהול עובדים"); 
    
  
    button.setBounds(700, 400, 600, 100); 
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

	

}






