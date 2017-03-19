package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Snake {
	int snakeX;
	int snakeY;
	
	public Snake(int snakeX, int snakeY){
		this.snakeX = snakeX;
		this.snakeY = snakeY;
	}
	
	public void drawSnake(Graphics g){
		//g.setColor(Color.WHITE);
		g.fillRect(snakeX, snakeY, Frame.SCALE, Frame.SCALE);
	}
	
	//

	
}
