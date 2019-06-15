 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class HR extends EnterUser {

	  


JFrame frame = super.getFrame();

HR()	
{ 
    // creating instance of JFrame with name "first way" 
	//HR frame;

	
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
    JButton button = new JButton(" הוספת עובד "); 
    
    button.setBounds(700, 400, 600, 100); 
    // setting close operation 
    button.addActionListener(new ActionListener() {
  		public void keyPressed(KeyEvent e) {

  			if (e.getKeyCode() == KeyEvent.VK_ENTER)
  				switchFrame();
  		}
  		public void actionPerformed(ActionEvent e) {
  			switchFrame();
  		}
  			

  	});
      
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

void switchFrame() {
	
	frame.setVisible(false);
	EnterSystem ES = new EnterSystem();
	ES.getFrame().setVisible(true);
}
}


  

		
		
		
		
	


	

