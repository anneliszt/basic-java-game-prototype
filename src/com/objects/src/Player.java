package com.objects.src;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.input.src.Controller;
import com.tutorial.src.GlobalPosition;

public class Player extends GlobalPosition{

	private String playerImage = "/res/player.png";
	
	int velX = 0; // Velocity x
	int velY = 0;
	
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	
	public Player(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		x += velX;
		y += velY;
		
		// Collision with outside
		if(x < 0) {
			x = 0;
		}
		
		if(y < 0) {
			y = 0;
		}
		
		if(x > 592) { // 640 - 32 (width of image) = 640
			x = 592;
		}
		
		if(y > 409) {
			y = 409;
		}
		
		Collision();
	}
	
	public void Collision() {
		
		for(int i=0; i<e.size(); i++) {
			if(getBounds().intersects(e.get(i).getBounds())) {
				System.out.println("COLLISION");
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_D) {
			velX = 5;
		} else if (key==KeyEvent.VK_A) {
			velX = -5;
		} else if (key==KeyEvent.VK_W) {
			velY = -5;
		} else if (key==KeyEvent.VK_S) {
			velY = 5;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_D) {
			velX = 0;
		} else if (key==KeyEvent.VK_A) {
			velX = 0;
		} else if (key==KeyEvent.VK_W) {
			velY = 0;
		} else if (key==KeyEvent.VK_S) {
			velY = 0;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), x, y, null);
	}
	
	public Image getPlayerImage() {
		ImageIcon i =  new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
	}

}
