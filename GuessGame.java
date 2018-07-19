package LudoFast;
//import java.util.Contaner;
import javax.swing.*;

import java.util.Random;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.*; 
class GuessGame  
{  
	public static String dialog;
    public static int x,a;
	
    public  static Random rn;

      public static void main(String args[])  
         { 
    	 
	JFrame f = new JFrame("GUESS GAME");
	JButton rb;
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.getContentPane().setBackground(Color.cyan);
    f.setPreferredSize(new Dimension(400, 300));
    rb = new JButton("New Game");
    rb.setBounds(100,200, 100,30);
    
   
    f.pack();
    JTextField t1,t2; 
    rn = new Random(); 
    t1=new JTextField("");  
    t1.setBounds(50,100, 200,30);  

    t2=new JTextField();  
    t2.setBounds(50,150, 200,30);
    t1.setEditable(true);
    t2.setEditable(false);

    x=rn.nextInt(500); 
    
   KeyListener keylistener = new KeyListener() {
	
	@Override
	public void keyTyped(KeyEvent arg0) {
	
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {

		String str = t1.getText();
		
		
		
		if(str.equals("")) str = "0";
		
		if((str.charAt(0)=='0')||
				(str.charAt(0)=='1') ||
				(str.charAt(0)=='2') ||
				(str.charAt(0)=='3') ||
				(str.charAt(0)=='4') ||
				(str.charAt(0)=='5') ||
				(str.charAt(0)=='6') ||
				(str.charAt(0)=='7') ||
				(str.charAt(0)=='8') ||
				(str.charAt(0)=='9') 
				
				)
		{
			a = Integer.parseInt(str);
		}
		
	    
		if(a==x){
	    	dialog="Correct";
	    	t2.setText(dialog);
	    	f.getContentPane().setBackground(Color.green);
	    }
	    else if(a>x){
	    	dialog ="Too High";
	    	t2.setText(dialog);
	    	f.getContentPane().setBackground(Color.red);
	    }
	    else{
	    	dialog ="Too Low";
	    	t2.setText(dialog);
	    	f.getContentPane().setBackground(Color.blue);
	    }
	}
};
    t1.addKeyListener(keylistener);
  
    f.add(t1);
    f.add(t2);  

    rb.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

    	  rn = new Random(); 
    	  x=  rn.nextInt(500); 
    	  f.getContentPane().setBackground(Color.cyan); 
      }
    });
    f.add(rb);
    
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);
    }

}  