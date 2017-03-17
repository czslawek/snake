package snake;

import javax.swing.*;
import java.awt.*;


	public class Frame {
		
		public Frame() {
			JFrame frame = new JFrame("Snake");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 
			
			frame.setSize(800, 700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(dim.width / 4, dim.height / 4 );
			frame.setVisible(true);
			frame.getContentPane().add(new MainPanel());
			
		}

	public static void main(String[] args) {
		new Frame();

	}

}
