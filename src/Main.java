import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main extends JFrame implements ActionListener {
	public JFrame f = new JFrame("HANGMAN");
	public String word, guessLetter;
	public int wordLen, height, width, pos = 0;
	public JLabel back;
	public JTextField guess;
	public ArrayList<String> wordArray=new ArrayList<String>(), pics = new ArrayList<String>(Arrays.asList("Head", "Body", "LeftArm","RightArm","Legs","Eyes","Mouth","LeftHand","RightHand","LeftFoot","RightFoot"));

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Sets background
		LoadImage background = new LoadImage("background.jpg");
		back = new JLabel(background);
		width = background.getIconWidth();
		height = background.getIconHeight();
		f.setSize(new Dimension(width + 210, height + 20));
		f.getContentPane().setBackground(Color.WHITE);
		f.add(back);

		// Enter a guess label and construction
		JLabel enterGuess = new JLabel("Enter a guess:");
		enterGuess.setForeground(Color.BLACK);
		enterGuess.setBounds(width + 20, 150, 100, 10);
		back.add(enterGuess);

		// User inputs guess textfield
		guess = new JTextField();
		guess.addActionListener(action);
		guess.setBackground(Color.decode("#F9F28A"));
		guess.setEditable(true);
		guess.setBounds(width + 25, 180, 70, 20);
		back.add(guess);

		// Sets up gameplay
		generateWord();
		drawLines();

		// Errortesting
		JLabel w = new JLabel(word);
		w.setForeground(Color.BLACK);
		w.setBounds(width, 60, 150, 13);
		back.add(w);

		//f.pack();
		f.setVisible(true);
	}

	public void generateWord() {
		ArrayList dict = new LoadText("dictionary.txt").getWords();
		int size = dict.size();
		int pos = (int) (Math.random() * size);
		String temp = (String) (dict.get(pos));
		word = temp;
		wordLen = temp.length();
		for(int x=0;x<wordLen;x++)
		{
			wordArray.add(word.charAt(x)+"");
		}
	}

	public void drawLines() {
		int len = (int) (150 / wordLen - 5);
		for (int x = 0; x < wordLen; x++) {
			LoadImage lineImg = new LoadImage("line.jpg");
			JLabel line = new JLabel(lineImg);
			line.setBounds(width + x * len + x * 50 / len, 100, len, 2);
			back.add(line);
		}
	}

	public void guess(String g) {
		int len = (int) (150 / wordLen - 5);
		if (word.contains(g))
		{
			for(int x=0;x<wordLen;x++)
			{
				if(wordArray.get(x).equals(g))
				{
					System.out.println(g);
					JLabel c = new JLabel(g);
					c.setForeground(Color.BLACK);
					//c.setBounds(10, 10, 80, 80);
					c.setBounds(width + x * len + x * 50 / len, 89, len, 10);
					back.add(c);
				}
			}
		}
		
		//f.setPreferredSize(new Dimension(width + 210, height + 20));
		f.pack();
	}

	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			guessLetter = guess.getText();
			guess.setText("");
			guess(guessLetter);
		}
	};

	public static void main(String[] args) {
		Main game = new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Already have an action listener
	}
}
