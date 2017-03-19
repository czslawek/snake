package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	public ArrayList<Snake> snakes = new ArrayList<Snake>();
	
 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.WHITE);
		for (Snake snake : snakes){
			snake.drawSnake(g);
		}
	}
	
	public int getHeadX(){
		return snakes.get(0).snakeX;
	}
	
	public int getHeadY(){
		return snakes.get(0).snakeY;		
	}
	
	public void move(int x, int y){
		snakes.remove(snakes.size() - 1);
		snakes.add(0, new Snake(x, y));
	}
}
