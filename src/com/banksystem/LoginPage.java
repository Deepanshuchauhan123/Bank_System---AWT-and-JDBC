package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends Frame implements ActionListener {
	
	Frame frame;
	Button login;
	Label account,password;
	TextField acc,pass;
	
	LoginPage(){
		
		frame = new Frame("Welcome To Login Page");
		account = new  Label("Account No.");
		password = new Label("Password   "); 
		acc = new TextField();
		pass= new TextField();
		login =new Button("Login");
		
		account.setBounds(50, 100, 120, 40);
		password.setBounds(50, 200, 120, 40);
		acc.setBounds(220,100,200,40);
		pass.setBounds(220,200,200,40);
		login.setBounds(140,300,150,40);
		
		Font f = new Font("Serif", Font.PLAIN, 24);
		account.setFont(f);
		password.setFont(f);
		login.setFont(f);
		acc.setFont(f);
		pass.setFont(f);
		
		frame.add(account);
		frame.add(password);
		frame.add(acc);
		frame.add(pass);
		frame.add(login);
		
		frame.setSize(500,500);
		
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		

		LoginPage p = new LoginPage();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
