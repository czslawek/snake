package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener, KeyListener {
	
	public List<Snake> snakes;
	public static final int SCALE = 20, SIZE = 600;
	String dir = "DOWN";
	Game game;
	JFrame frame;
	Timer timer;
	JLabel score;
	
	
	public MainPanel() {
		frame = new JFrame("Wonsz");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		timer = new Timer(100, this);
		
		frame.setSize(SIZE, SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(dim.width / 4, dim.height / 4 );
		frame.setVisible(true);
		frame.getContentPane().add(this);
		setFocusable(true);
		frame.setResizable(false);
		//requestFocusInWindow();
		addKeyListener(this);
		game = new Game();
		snakes = game.snakes;
		score = new JLabel();
		score.setForeground(Color.WHITE);
		add(score);
		timer.start();	
	}
	
	public static void main(String[] args) {
		new MainPanel();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SIZE, SIZE);

		g.setColor(Color.WHITE);
		for (Snake snake : snakes.subList(1, snakes.size() )) {
			snake.drawSnake(g);
		}
		g.setColor(Color.BLUE);
		snakes.get(0).drawSnake(g);//head
		
		g.setColor(Color.ORANGE);
		g.fillRect(game.apple.getAppleX(), game.apple.getAppleY(), SCALE, SCALE);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		int x = game.getHeadX();
		int y = game.getHeadY();
		
		if (game.checkCollision()) {
			//frame.dispose();
			System.out.println("game over");
			score.setText("SCORE " + game.score + " GAME OVER");
			timer.stop();
		} else {
		game.eatApple();
		score.setText("SCORE " + game.score);
		}
		
		switch (dir) {
			case "DOWN":
				game.move(x, y + SCALE);
				break;
			case "RIGHT":
				game.move(x + SCALE, y);
				break;
			case "UP":
				game.move(x, y - SCALE);
				break;
			case "LEFT":
				game.move(x - SCALE, y);
				break;
		
		}
		repaint();

}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_DOWN: {
				dir = (dir == "UP")?"UP":"DOWN";
				break;
			}
			case KeyEvent.VK_RIGHT: {
				dir = (dir == "LEFT")?"LEFT":"RIGHT";
				break;
			}
			case KeyEvent.VK_LEFT: {
				dir = (dir == "RIGHT")?"RIGHT":"LEFT";
				break;
			}
			case KeyEvent.VK_UP: {
				dir = (dir == "DOWN")?"DOWN":"UP";
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
