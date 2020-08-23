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

public class Register extends Frame implements ActionListener
{

	Frame f;
	Label name,pass,add,mob,amount;
	TextField namet,passt,addt,mobt,amountt;
	Button create,back;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url,name_value,password_value,add_value,mob_value,amount_value;
	
	
	public Register() 
	{
		
		f = new Frame("Welcome to Register Page");
		name = new Label("Name");
		pass = new Label("Password");
		add = new Label("Address");
		mob = new Label("Mobile No.");
		amount = new Label("Amount");
		namet = new TextField();
		passt = new TextField();
		addt = new TextField();
		mobt = new TextField();
		amountt = new TextField();
		create = new Button("Create");
		back =new Button("Back");
		
		name.setBounds(50,50,120,40);
		pass.setBounds(50,100,120,40);
		add.setBounds(50,150,120,40);
		mob.setBounds(50,200,120,40);
		amount.setBounds(50,250,120,40);
		namet.setBounds(200,50,200,40);
		passt.setBounds(200,100,200,40);
		addt.setBounds(200,150,200,40);
		mobt.setBounds(200,200,200,40);
		amountt.setBounds(200,250,200,40);
		create.setBounds(150,350,200,40);
		back.setBounds(150,400,200,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		
		name.setFont(font);
		pass.setFont(font);
		add.setFont(font);
		mob.setFont(font);
		amount.setFont(font);
		namet.setFont(font);
		passt.setFont(font);
		addt.setFont(font);
		mobt.setFont(font);
		amountt.setFont(font);
		create.setFont(font);
		back.setFont(font);
		
		back.addActionListener(this);
		create.addActionListener(this);
		
		f.add(name);
		f.add(pass);
		f.add(add);
		f.add(mob);
		f.add(amount);
		f.add(namet);
		f.add(passt);
		f.add(addt);
		f.add(mobt);
		f.add(amountt);
		f.add(create);
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
		
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}

//	public static void main(String[] args) {
//		Register r = new Register();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		name_value = namet.getText();
		password_value = passt.getText();
		add_value = addt.getText();
		mob_value = mobt.getText();
		amount_value = amountt.getText();
		
		if(e.getSource()==back) 
		{
			StartPage p1 = new StartPage();
		}else 
		{
			if(!name_value.equals("") && !password_value.equals("")&& !add_value.equals("")&& !mob_value.equals("")&& !amount_value.equals(""))
			{
				try 
				{
					
					ps = con.prepareStatement("insert into Employee_Details(name,password,address,mobile,amount)values(?,?,?,?,?)");
					ps.setString(1, name_value);
					ps.setString(2, password_value);
					ps.setString(3, add_value);
					ps.setString(4, mob_value);
					ps.setInt(5, Integer.parseInt(amount_value));
				
					ps.executeUpdate();
					ps.close();
					
					ps = con.prepareStatement("select Max(acno) from Employee_Details");
					rs = ps.executeQuery();
					
					String ac_no = "";
					
					while(rs.next()) 
					{
						
						ac_no = rs.getString(1);
					}
					
					JOptionPane.showMessageDialog(f, "Hello! "+name_value+" Your Account is created Successfully. Your Account No. is "+ac_no);
				
					
					ps.close();
					rs.close();
					
					f.setVisible(false);
					
					LoginPage p1 = new LoginPage();
					
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
			}else 
			{
				
				JOptionPane.showMessageDialog(f,"Empty Field not Accepted!!");
			}
			
		}
		
		
	}

}
