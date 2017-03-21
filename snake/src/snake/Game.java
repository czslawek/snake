package snake;

import java.util.List;
import java.util.ArrayList;

public class Game {
	public static List<Snake> snakes;
	public Apple apple;
	String dir;
	boolean gameOver = false;
	int headX, headY, tailX, tailY, score;

	public Game(){
		apple = new Apple();
		snakes = new ArrayList<Snake>();
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
	
	public boolean checkCollision() {
		
		if (getHeadX() < 0 || getHeadY() < 0 ||
			getHeadX() > MainPanel.SIZE || getHeadY() > MainPanel.SIZE) {
			return true;
			}
		for (int i = 0; i <snakes.size(); i++) {
			for (int j = 0; j < snakes.size(); j++) {
				if (i != j && snakes.get(i).equals(snakes.get(j))){
					return true;
				}
			}
		}
		return false;	
	}
	
	public void eatApple() {
		if (apple.getAppleX() == getHeadX() && apple.getAppleY() == getHeadY()) {
			apple = new Apple();
			tailX = snakes.get(snakes.size() - 1).getSnakeX();
			tailY = snakes.get(snakes.size() - 1).getSnakeY();
			snakes.add(new Snake(tailX, tailY));
			score++;
			
		}
	}
	
	public int getHeadX(){
		return snakes.get(0).getSnakeX();
	}
	
	public int getHeadY(){
		return snakes.get(0).getSnakeY();
	}
	
	public List<Snake> getSnake(){
		return snakes;
	}
}