 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Hr extends EnterUser {

	  


JFrame frame = new JFrame("HR");

Hr()	
{ 
    // creating instance of JFrame with name "first way" 
	//HR frame;
    frame=new JFrame("HR"); 
    //get clock
    new FrameClock(frame);
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
    JButton button = new JButton("עדכון עובד"); 
    
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

  

		
		
		
		
	


	

