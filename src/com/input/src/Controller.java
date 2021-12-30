package com.input.src;

import java.awt.Graphics2D;
import java.util.LinkedList;

import com.objects.src.Enemy;

public class Controller {
	
	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	Enemy TempEnemy;
	
	public Controller() { // Constructor
		addEnemy(new Enemy(100, 200));
		addEnemy(new Enemy(400, 300));
		addEnemy(new Enemy(200, 400));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			
			TempEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			TempEnemy.update();
		}
	}
	
	public void addEnemy(Enemy enemy) {
		e.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		e.remove(enemy);
	}
	
	public static LinkedList<Enemy> getEnemyBounds(){
		return e;
	}
}
