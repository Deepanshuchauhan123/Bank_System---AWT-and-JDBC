package com.banksystem;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Withdraw {

	Frame f;
	TextField amount;
	Label amt;
	Button ok;
	
	public Withdraw() {
		f = new Frame("Withdraw From Your Account");
		amount = new TextField();
		amt = new Label("Amount");
		ok = new Button("Ok");
		
		amt.setBounds(50,100,100,40);
		amount.setBounds(150,100,150,40);
		ok.setBounds(150,200,100,40);
		
		Font font = new Font(Font.SERIF,Font.PLAIN,24);
		ok.setFont(font);
		amount.setFont(font);
		amt.setFont(font);
		
		f.add(amt);
		f.add(amount);
		f.add(ok);
		
		f.setSize(400,300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Withdraw d = new Withdraw();

	}

}
