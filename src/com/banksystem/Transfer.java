package com.banksystem;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transfer extends Frame implements ActionListener
{


	Frame f;
	TextField amount,account;
	Label amt,acc;
	Button ok,back;
	Connection con;
	String url,am,accoun;
	int am_value2,am_value1 = 0;
	PreparedStatement ps;
	ResultSet rs;
	
	public Transfer() 
	{
		
		f = new Frame("Transfer From Your Account");
		account = new TextField();
		acc = new Label("To Account");
		amount = new TextField();
		amt = new Label("Amount");
		ok = new Button("Transfer");
		back = new Button("Back");
		
		acc.setBounds(50,100,150,40);
		account.setBounds(200,100,200,40);
		amt.setBounds(50,200,150,40);
		amount.setBounds(200,200,200,40);
		ok.setBounds(100,300,100,40);
		back.setBounds(260,300,100,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		ok.setFont(font);
		amount.setFont(font);
		amt.setFont(font);
		acc.setFont(font);
		account.setFont(font);
		back.setFont(font);
		
		try 
		{
		
			url = "jdbc:mysql://localhost:3306/bank_system";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,"root",null);
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		f.add(amt);
		f.add(amount);
		f.add(ok);
		f.add(acc);
		f.add(account);
		f.add(back);
		
		ok.addActionListener(this);
		back.addActionListener(this);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}

//	public static void main(String[] args) 
//	{
//		
//		Transfer t = new Transfer();
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
				accoun = account.getText();
				
				if(!am.equals("") && !accoun.equals("")) 
				{
					
					ps = con.prepareStatement("select * from Employee_Details where acno=?");
					
					ps.setInt(1, LoginPage.get_acno());
					
					rs = ps.executeQuery();
					
					while(rs.next()) 
					{
						am_value2 = rs.getInt(6);
					}
					
					JOptionPane.showMessageDialog(f, "Money Transferred Successfully.\nYour Account Balanace is "+(am_value2 - Integer.parseInt(am)));
					
					
					ps.close();
					
					if(am_value2 > Integer.parseInt(am) + 1000) 
					{
						
						ps = con.prepareStatement("update Employee_Details set amount=? where acno=?");
						
						ps.setInt(1,(am_value2 - Integer.parseInt(am)) );
						
						ps.setInt(2, LoginPage.get_acno());
						
						ps.executeUpdate();
						
						ps.close();
						rs.close();
						
						
						ps = con.prepareStatement("select * from Employee_Details where acno=?");
						
						ps.setInt(1, Integer.parseInt(accoun));
						
						rs = ps.executeQuery();
						
						while(rs.next()) 
						{
							am_value2 = rs.getInt(6);
						}
						
						ps.close();
						
						ps = con.prepareStatement("update Employee_Details set amount=? where acno=?");
					
						ps.setInt(1,(am_value2+ Integer.parseInt(am)) );
						
						ps.setInt(2, Integer.parseInt(accoun));
						
						ps.executeUpdate();
						
						
						ps.close();
						rs.close();
						
					}else 
					{
						JOptionPane.showMessageDialog(f,"Your Account doesn't have Sufficient Amount !!");
					}

				}
				
			} catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			}
		}
	}

}
