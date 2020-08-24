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

public class Deposit extends Frame implements ActionListener 
{

	Frame f;
	TextField amount;
	Label amt;
	Button deposit,back;
	Connection con;
	String url,am;
	int am_value2,am_value1 = 0;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public Deposit() 
	{
		
		f = new Frame("Deposit into Your Account");
		amount = new TextField();
		amt = new Label("Amount");
		deposit = new Button("Deposit");
		back = new Button("Back");
		
		amt.setBounds(50,100,100,40);
		amount.setBounds(150,100,150,40);
		deposit.setBounds(70,200,100,40);
		back.setBounds(230,200,100,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		deposit.setFont(font);
		amount.setFont(font);
		amt.setFont(font);
		back.setFont(font);
		
		f.add(amt);
		f.add(amount);
		f.add(deposit);
		f.add(back);
		
		try 
		{
		
			url = "jdbc:mysql://localhost:3306/bank_system";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,"root",null);
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		deposit.addActionListener(this);
		back.addActionListener(this);
		
		f.setSize(400,300);
		f.setLayout(null);
		f.setVisible(true);
	}

//	public static void main(String[] args) 
//	{
//		Deposit d = new Deposit();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==back) 
		{
			HomePage p1 = new HomePage();
			f.setVisible(false);
			
		}else 
		{
			
			try 
			{
				am = amount.getText();
				
				if(!am.equals("")) 
				{
					
					ps = con.prepareStatement("select * from Employee_Details where acno=?");
					
					ps.setInt(1, LoginPage.get_acno());
					
					rs = ps.executeQuery();
					
					while(rs.next()) 
					{
						am_value2 = rs.getInt(6);
					}
					
					ps.close();
					
					ps = con.prepareStatement("update Employee_Details set amount=? where acno=?");
				
					ps.setInt(1,(am_value2+ Integer.parseInt(am)) );
					
					ps.setInt(2, LoginPage.get_acno());
					
					ps.executeUpdate();
					
					ps.close();
					rs.close();
					
					JOptionPane.showMessageDialog(f, "Your Account is Updated Successfully.\nYour Account Balanace is "+(am_value2+ Integer.parseInt(am)));
				
					amount.setText("");
				}
				
			} catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			}
		}
		
	}

}
