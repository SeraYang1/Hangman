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
	public JLabel back;

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Sets background
		LoadImage background = new LoadImage("background.jpg");
		back = new JLabel(background);
		width = background.getIconWidth();
		height = background.getIconHeight();
		f.setPreferredSize(new Dimension(width + 200, height + 20));
		f.getContentPane().setBackground(Color.WHITE);
		f.add(back);

		// Enter a guess label and construction
		JLabel enterGuess = new JLabel("Enter a guess:");
		enterGuess.setForeground(Color.BLACK);
		enterGuess.setBounds(width+20, 150, 100, 30);
		back.add(enterGuess);

		//User inputs guess textfield
		JTextField guess = new JTextField();
		guess.setColumns(1);
		guess.setBackground(Color.decode("#F9F28A"));
		guess.setEditable(true);
		guess.setBounds(width+25, 180, 70, 20);
		back.add(guess);


		// Sets up gameplay
		generateWord();
		drawLines();
		
	
		

		//Errortesting
		JLabel w = new JLabel(word);
		w.setForeground(Color.BLACK);
		w.setBounds(width, 60, 100, 20);
		back.add(w);
		

		f.setVisible(true);
		f.pack();

	}

	public void generateWord() {
		ArrayList dict = new LoadText("dictionary.txt").getWords();
		int size = dict.size();
		int pos = (int) (Math.random() * size);
		String temp = (String) (dict.get(pos));
		this.word = temp;
		this.wordLen = temp.length();
	}
	
	public void drawLines(){
		int len = (int) (150 / wordLen-5);
		for (int x = 0; x < wordLen; x++) {
			LoadImage lineImg = new LoadImage("line.jpg");
			JLabel line = new JLabel(lineImg);
			line.setBounds(width+x*len+x*50/len, 100, len, 2);
			back.add(line);
		}
	}

	public static void main(String[] args) {
		Main game = new Main();
	}
}
