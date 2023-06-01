package midPointAlgorithm;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


public class Main  {
	public static  BoardComponent component = new BoardComponent(0,0);
	
	public static void main(String[]args) {

		initalise();
	}
	
	private static void initalise() {
		JFrame frame= new JFrame();
		JTextField text = new JTextField();
		JLabel label= new JLabel();
	    JButton button=new JButton("Click Here");  	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grid");
		frame.setSize(1000,1000);
		frame.setResizable(false);
		component = new BoardComponent(10,11);
	    component.setBounds(50,100,95,30);
	    
	    label.setBounds(700,900,95,30);
	    label.setText("Enter diameter");
	    text.setBounds(800,900,95,30);
	    button.setBounds(900,900,95,30);
		frame.add(label);
		frame.add(button);
		frame.add(text);
		frame.add(component);
		frame.setVisible(true);



		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	String input;
		    	int value;		    
		    	input=text.getText();
		    	value=Integer.parseInt(input);
				frame.remove(component);
		    	component = new BoardComponent(10,value);
				frame.add(component);
				frame.setVisible(true);

		    }
		});
	}
	

	




}
