package com.cs;


import java.awt.Color;

import javax.swing.JButton;

public class Pixel extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Pixel(){
		super.setEnabled(false);
		super.setFocusPainted(false); 
		super.setBackground(Color.BLACK);
	}
	
	public void dark(){
		super.setVisible(false);
	}
	
	public void light(){
		super.setVisible(true);
	}
	
	public void changleColor(Color c){
		super.setBackground(c);
	}

}
