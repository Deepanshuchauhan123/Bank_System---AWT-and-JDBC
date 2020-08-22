package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends Frame implements ActionListener{

	Frame f;
	Label name,pass,add,mob,amount;
	TextField namet,passt,addt,mobt,amountt;
	Button create,back;
	
	public Register() {
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
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		
		
		
	}

//	public static void main(String[] args) {
//		Register r = new Register();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			StartPage p1 = new StartPage();
		}
		
		f.setVisible(false);
		
	}

}
