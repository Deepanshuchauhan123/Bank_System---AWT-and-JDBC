package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends Frame implements ActionListener{

	Frame f ;
	Button b1,b2;
	StartPage(){
		
		f = new Frame("Welcome To My Bank");
		b1 = new Button("New User");
		b2 = new Button("Existing User");
		
		b1.setBounds(100,100,100,50);
		b2.setBounds(100,200,100,50);
		
		f.add(b1);
		f.add(b2);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	public static void main(String arr[]) {
		StartPage s = new StartPage();
	}
}