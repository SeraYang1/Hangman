import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main extends JFrame {
	public JFrame f = new JFrame("HANGMAN");
	public String word;
	public int wordLen, height, width;

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Sets background
		LoadImage background = new LoadImage("background.jpg"); 
		JLabel back = new JLabel(background);
		width = background.getIconWidth()+150;
		height = background.getIconHeight()+20;
		f.setPreferredSize(new Dimension(width, height));
		f.getContentPane().setBackground(Color.WHITE);
		f.add(back);

		//Enter a guess label and construction
		JLabel enterGuess = new JLabel("Enter a guess:");
		enterGuess.setForeground(Color.BLACK);
		back.add(enterGuess);
		enterGuess.setBounds(width-150, 100, 100, 30);
		
		
		JTextField guess = new JTextField(1);
		guess.setBackground(Color.decode("#F9F28A"));
		guess.setEditable(true);
		guess.setBounds(width-150, 130, 70, 20);
		back.add(guess);
		
		f.setVisible(true);
		f.pack();
		
		
		// Sets up gameplay
		generateWord();
		

	}

	public void generateWord() {
		ArrayList dict = new LoadText("dictionary.txt").getWords();
		int size = dict.size();
		int pos = (int) (Math.random()*size);
		String temp = (String)(dict.get(pos));
		this.word = temp;
		this.wordLen = temp.length();
	}

	public static void main(String[] args) {
		Main game = new Main();
	}
}
