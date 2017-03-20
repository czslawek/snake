package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	private int appleX;
	private int appleY;
	private Random rand = new Random(); 
	 
	public Apple() {	
		appleX = getRandomXY();
		appleY = getRandomXY();
	}	
		
	public void drawApple(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(appleX, appleY, MainPanel.SCALE, MainPanel.SCALE);
	}
	
	public int getAppleX() {
		return appleX;
	}

	public int getAppleY() {
		return appleY;
	}
	
	public int getRandomXY() {
		return (rand.nextInt(20) + 5) * MainPanel.SCALE;
	}
}