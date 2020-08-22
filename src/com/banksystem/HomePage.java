package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;	

public class HomePage extends Frame implements ActionListener {

	Frame f;
	JButton deposit,withdraw,transfer,show;
	
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
		
		
		f.setLayout(new GridLayout(2,2));
		
		f.setSize(400,500);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		HomePage p = new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
