package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Frame implements ActionListener, KeyListener {
	MainPanel mainpanel;
	String dir = " ";
	
	
	public static final int SCALE = 15;
	
	public Frame() {
		JFrame frame = new JFrame("Snake");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Timer timer = new Timer(100, this);
		
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(dim.width / 4, dim.height / 4 );
		frame.setVisible(true);
		frame.getContentPane().add(mainpanel = new MainPanel());
		frame.addKeyListener(this);
		mainpanel.snakes.add(new Snake(45,60));
		mainpanel.snakes.add(new Snake(45,45));
		//System.out.println(mainpanel.snakes.size());;
		timer.start();
		
	}

	public static void main(String[] args) {
		new Frame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainpanel.repaint();
		
		int x = mainpanel.getHeadX();
		int y = mainpanel.getHeadY();
		
		switch (dir) {
		
		case "DOWN":
			mainpanel.move(x, y + SCALE);
			break;
		case "RIGHT":
			mainpanel.move(x + SCALE, y);
			break;
		case "UP":
			mainpanel.move(x, y - SCALE);
			break;
		case "LEFT":
			mainpanel.move(x - SCALE, y);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			dir = "DOWN";
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			dir = "RIGHT";
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			dir = "LEFT";
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			dir = "UP";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
