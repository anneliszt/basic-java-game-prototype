package com.tutorial.src;

import javax.swing.JFrame;

public class MainClass {
	
	public static final int WIDTH = 640, HEIGHT = 480;
	public static final String TITLE = "Tutorial";
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame(TITLE);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Sets frame to middle position
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates program
		frame.add(new Game()); // Calls game class
		frame.setVisible(true);
		
	}

}
