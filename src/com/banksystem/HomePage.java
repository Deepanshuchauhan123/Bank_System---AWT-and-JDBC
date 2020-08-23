package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;	

public class HomePage extends Frame implements ActionListener 
{

	Frame f;
	JButton deposit,withdraw,transfer,show;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url,name,amount,mobile;
	
	public HomePage() 
	{
		f = new JFrame("Welcome To HomePage");
		deposit = new JButton("Deposit");
		withdraw = new JButton("WithDraw");
		transfer = new JButton("Transfer");
		show = new JButton("Show Details");
		

		f.add(deposit);
		f.add(show);
		f.add(transfer);
		f.add(withdraw);
		
		Font font = new Font(Font.SERIF,Font.BOLD,24);
		deposit.setFont(font);
		withdraw.setFont(font);
		transfer.setFont(font);
		show.setFont(font);
		
		deposit.setBackground(Color.PINK);
		withdraw.setBackground(Color.YELLOW);
		transfer.setBackground(Color.RED);
		show.setBackground(Color.MAGENTA);
		
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
		withdraw.addActionListener(this);
		transfer.addActionListener(this);
		show.addActionListener(this);
		
		f.setLayout(new GridLayout(2,2));
		
		f.setSize(400,500);
		f.setVisible(true);
		
	}

//	public static void main(String[] args) {
//		HomePage p = new HomePage();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == deposit) 
		{
			Deposit d = new Deposit();
			
			f.setVisible(false);
			
		}else if(e.getSource() == withdraw) 
		{
			
			Withdraw w = new Withdraw();
			
			f.setVisible(false);
			
		}else if(e.getSource() == transfer) 
		{
			
			Transfer t = new Transfer();
			
			f.setVisible(false);
			
		}else if(e.getSource() == show) 
		{
			
			try 
			{
				
				ps = con.prepareStatement("select * from Employee_Details where acno = ?");
				
				ps.setInt(1, LoginPage.get_acno());
				
				rs = ps.executeQuery();
				
				while(rs.next()) 
				{
				
					name = rs.getString(2);
					amount = rs.getString(6);
					mobile = rs.getString(5);
				}
				
				JOptionPane.showMessageDialog(f, "Name : "+name+"\nAmount : "+amount+"\nMobile : "+mobile);
				
			} catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			}
			
		}
		
		
	}

}
