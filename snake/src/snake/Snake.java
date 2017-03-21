package snake;

import java.awt.Graphics;

public class Snake {
	private int snakeX;
	private int snakeY;
	
	public Snake(int snakeX, int snakeY){
		this.snakeX = snakeX;
		this.snakeY = snakeY;
	}
	
	public void drawSnake(Graphics g){
		g.fillRect(snakeX, snakeY, MainPanel.SCALE, MainPanel.SCALE);
	}

	public int getSnakeX() {
		return snakeX;
	}

	public int getSnakeY() {
		return snakeY;
	}
	
	public boolean equals(Snake s) {
		if (snakeX == s.getSnakeX() && snakeY == s.getSnakeY()){
			return true;
		}
		return false;
	}
}
