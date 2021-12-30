package com.input.src;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.objects.src.Player;

public class KeyInput extends KeyAdapter{ // Implements keyboard inputs
	
	Player p;
	
	public KeyInput(Player p) { // Constructor
		this.p = p;
	}
	
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
