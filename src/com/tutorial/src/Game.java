package com.tutorial.src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.input.src.Controller;
import com.input.src.KeyInput;
import com.objects.src.Enemy;
import com.objects.src.Player;

public class Game extends JPanel implements ActionListener{ // See window

	private static final long serialVersionUID = 1L;
	
	private String background = "/res/bg.gif";
	
	Timer gameloopTimer; // Timer using swing
	Player p;
	Controller c;

	public Game() { // Constructor
		setFocusable(true); // Sets focusable state of this component to the specified value
	
		gameloopTimer = new Timer(10, this); // Implement action listener beforehand
		gameloopTimer.start(); // Starts game loop
		
		p = new Player(100, 100);
		c = new Controller();
		addKeyListener(new KeyInput(p));
	}
	
	// Allows us to paint
	public void paint(Graphics g){
		super.paint(g); // Super means superclass which is main class
		
		Graphics2D g2D = (Graphics2D)g; // Converts graphics to Graphics2D because it's better
		g2D.drawImage(getBackgroundImage(), 0, 0, this);
		p.draw(g2D);
		c.draw(g2D);
	}
	
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent ae) { // Runs through this code every 10ms based on gamelooptimer
		repaint(); // In-built method that calls paint method every 10ms
		p.update();
		c.update();
	}
}
