package com.banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends Frame implements ActionListener {

	Frame f;
	TextField amount;
	Label amt;
	Button deposit;
	
	public Deposit() {
		
		f = new Frame("Deposit into Your Account");
		amount = new TextField();
		amt = new Label("Amount");
		deposit = new Button("Deposit");
		
		amt.setBounds(50,100,100,40);
		amount.setBounds(150,100,150,40);
		deposit.setBounds(150,200,100,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		deposit.setFont(font);
		amount.setFont(font);
		amt.setFont(font);
		
		f.add(amt);
		f.add(amount);
		f.add(deposit);
		
		f.setSize(400,300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Deposit d = new Deposit();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
