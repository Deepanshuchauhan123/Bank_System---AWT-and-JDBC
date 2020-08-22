package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends Frame implements ActionListener
{

	Frame f ;
	Button b1,b2;
	StartPage()
	{
		
		f = new Frame("Welcome To My Bank");
		b1 = new Button("New User");
		b2 = new Button("Existing User");
		
		b1.setBounds(100,100,200,50);
		b2.setBounds(100,200,200,50);
		
		Font font = new Font("Serif", Font.PLAIN, 24);
		b1.setFont(font);
		b2.setFont(font);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.add(b1);
		f.add(b2);
		
		
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1) 
		{
			Register r = new Register();
		}else 
		{
			LoginPage p1 = new LoginPage();
		}
		f.setVisible(false);
		
	}
	
	public static void main(String arr[]) 
	{
		StartPage s = new StartPage();
	}
}