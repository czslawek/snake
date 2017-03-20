package snake;

import java.util.ArrayList;

public class Game {
	public static ArrayList<Snake> snakes = new ArrayList<Snake>();
	public Apple apple = new Apple();
	String dir;
	boolean gameOver = false;

	public Game(){
		snakes.add(new Snake(40,80));
		snakes.add(new Snake(40,60));
	}
	
	public void addSnake(int x, int y){
		snakes.add(new Snake(x, y));
	}
	
	public void move(int x, int y){
		snakes.remove(snakes.size() - 1);
		snakes.add(0, new Snake(x, y));
	}
	
	public boolean checkCollision(){
		if (getHeadX() < 0)
			return true;
		if (getHeadX() > MainPanel.SIZE)
			return true;
		if (getHeadY() < 0)
			return true;
		if (getHeadY() > MainPanel.SIZE)
			return true;
		return false;	
		
	}
	
	public int getHeadX(){
		return snakes.get(0).getSnakeX();
	}
	
	public int getHeadY(){
		return snakes.get(0).getSnakeY();
	}
	
	public ArrayList<Snake> getSnake(){
		return snakes;
	}
}