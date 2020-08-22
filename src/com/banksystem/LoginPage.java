package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginPage extends Frame implements ActionListener 
{
	
	Frame frame;
	Button login,back;
	Label account,password;
	TextField acc,pass;
	Connection con;
	ResultSet rs;
	
	LoginPage()
	{
		
		frame = new Frame("Welcome To Login Page");
		account = new  Label("Account No.");
		password = new Label("Password   "); 
		acc = new TextField();
		pass= new TextField();
		login =new Button("Login");
		back =new Button("Back");
		
		account.setBounds(50, 100, 120, 40);
		password.setBounds(50, 200, 120, 40);
		acc.setBounds(220,100,200,40);
		pass.setBounds(220,200,200,40);
		login.setBounds(50,300,150,40);
		back.setBounds(250,300,150,40);
		
		Font f = new Font("Serif", Font.PLAIN, 24);
		
		account.setFont(f);
		password.setFont(f);
		login.setFont(f);
		acc.setFont(f);
		pass.setFont(f);
		back.setFont(f);
		
		back.addActionListener(this);
		login.addActionListener(this);
		
		frame.add(account);
		frame.add(password);
		frame.add(acc);
		frame.add(pass);
		frame.add(login);
		frame.add(back);
		
		
		try 
		{
				String url = "jdbc:mysql://localhost:3306/bank_system";
		           
		        Class.forName("com.mysql.jdbc.Driver");
		           
		        con= DriverManager.getConnection(url,"root",null);
	           
		}catch(Exception e) 
		{
			System.out.println(e);
		}
		
		frame.setSize(500,500);
		
		frame.setLayout(null);
		frame.setVisible(true);
		System.out.print("good");
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String account_value,pass_value;
		
		if(e.getSource() == back) 
		{
		
			StartPage p1 = new StartPage();
			frame.setVisible(false);
		}else 
		{
			int c = 0;
			account_value = acc.getText();
			pass_value = pass.getText();
			
			
			if(! account_value.equals("") && ! pass_value.equals("") )
			{
				
				try 
				{
					PreparedStatement ps =  con.prepareStatement("select * from Employee_Details where acno=? and password=?");
					
					ps.setInt(1,Integer.parseInt(account_value));
					ps.setString(2, pass_value.trim());
					
					rs = ps.executeQuery();
					
					while(rs.next()) 
					{
						c=c+1;
					}
					
					if(c!=0) 
					{
						JOptionPane.showMessageDialog(frame, "Login Successful");
						frame.setVisible(false);
						HomePage h1 = new HomePage();
					}else 
					{
						JOptionPane.showMessageDialog(frame, "Login Failed !!");
						pass.setText("");
						acc.setText("");
						
					}
					
					rs.close();
					ps.close();
					con.close();
					
				} catch (SQLException e1) 
				{
				
					e1.printStackTrace();
				}
			}else 
			{
			
				JOptionPane.showMessageDialog(frame, "Account no. or Password cannot be Empty!!");
			}
			
			
		}
		
		
	}

}
