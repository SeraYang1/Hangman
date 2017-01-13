import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;

public class Main extends JFrame {
	public JFrame f = new JFrame("HANGMAN");

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LoadImage back = new LoadImage("background.jpg");
		f.setVisible(true);
		f.setContentPane(back);
		f.pack();
	}

	public static void main(String[] args) {
		Main game = new Main();
	}
}
