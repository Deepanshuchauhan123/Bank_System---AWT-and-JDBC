package com.banksystem;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Transfer {


	Frame f;
	TextField amount,account;
	Label amt,acc;
	Button ok;
	
	public Transfer() {
		f = new Frame("Transfer From Your Account");
		account = new TextField();
		acc = new Label("To Account");
		amount = new TextField();
		amt = new Label("Amount");
		ok = new Button("Transfer");
		
		acc.setBounds(50,100,150,40);
		account.setBounds(200,100,200,40);
		amt.setBounds(50,200,150,40);
		amount.setBounds(200,200,200,40);
		ok.setBounds(150,300,100,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		ok.setFont(font);
		amount.setFont(font);
		amt.setFont(font);
		acc.setFont(font);
		account.setFont(font);
		
		f.add(amt);
		f.add(amount);
		f.add(ok);
		f.add(acc);
		f.add(account);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		
		Transfer t = new Transfer();
	}

}
