import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	public String word, guessLetter, wrongGuessesList="";
	public int wordLen, height, width, right = 0, wrong = 0;
	public JLabel back,pic=new JLabel(), wrongGuesses= new JLabel();
	public JTextField guess;
	public ArrayList<String> wordArray = new ArrayList<String>(), pics = new ArrayList<String>(
			Arrays.asList("Head.jpg", "Body.jpg", "Arms.jpg", "Legs.jpg", "Eyes.jpg",
					"Mouth.jpg", "Hands.jpg", "Feet.jpg"));

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Sets background
		LoadImage background = new LoadImage("background.jpg");
		back = new JLabel(background);
		width = background.getIconWidth();
		height = background.getIconHeight();
		f.setSize(new Dimension(width, height));
		f.getContentPane().setBackground(Color.WHITE);
		f.setLayout(new GridBagLayout());
		f.add(back);
		
		//Sets up the JLabel for incorrect guesses
		wrongGuesses.setForeground(Color.RED);
		wrongGuesses.setBounds(width-180, 350, 200, 50);
		back.add(wrongGuesses);
		
		// Enter a guess label and construction
		JLabel enterGuess = new JLabel("Enter a guess:");
		enterGuess.setForeground(Color.BLACK);
		enterGuess.setBounds(width - 180, 150, 100, 15);
		back.add(enterGuess);

		// User inputs guess textfield
		guess = new JTextField(wrongGuessesList);
		guess.addActionListener(action);
		guess.setBackground(Color.decode("#F9F28A"));
		guess.setEditable(true);
		guess.setBounds(width - 175, 180, 70, 20);
		back.add(guess);

		// Sets up gameplay
		generateWord();
		drawLines();

		// Errortesting
		JLabel w = new JLabel(word);
		w.setForeground(Color.BLACK);
		w.setBounds(width - 150, 60, 150, 15);
		back.add(w);

		f.setVisible(true);
	}

	public void generateWord() {
		ArrayList dict = new LoadText("dictionary.txt").getWords();
		int size = dict.size();
		int pos = (int) (Math.random() * size);
		String temp = (String) (dict.get(pos));
		word = temp;
		wordLen = temp.length();
		for (int x = 0; x < wordLen; x++) {
			wordArray.add(word.charAt(x) + "");
		}
	}

	public void drawLines() {
		int len = (int) (250 / wordLen);
		for (int x = 0; x < wordLen; x++) {
			LoadImage lineImg = new LoadImage("line.jpg");
			JLabel line = new JLabel(lineImg);
			line.setBounds((int) (width - 250 + x * len), 100, (int) (5 * len / 6), 2);
			back.add(line);
		}
	}

	public void guess(String g) {
		int len = (int) (250 / wordLen);
		if (word.contains(g)) {
			for (int x = 0; x < wordLen; x++) {
				if (wordArray.get(x).equals(g)) {
					// TODO font size doesnt match up
					int fontSize = 360 / wordLen;
					System.out.println(g);
					JLabel c = new JLabel(g);
					c.setForeground(Color.BLACK);
					c.setFont(c.getFont().deriveFont(fontSize));
					c.setVisible(true);
					c.setBounds((int) (width - 250 + x * len), 89, (int) (5 * len / 6), 10);
					back.add(c);
					right++;
				}
			}
			if (right == wordLen) {
				System.out.println("YOU WIN");
			}
		} else {
			if (wrong == pics.size()) {
				System.out.println("YOU LOSE");
			} else {
				wrongGuessesList +=g;
				wrongGuesses.setText(wrongGuessesList);
				LoadImage b = new LoadImage(pics.get(wrong));
				pic.setIcon(b);
				pic.setBounds(135, 120, 300, 300);
				//f.setComponentZOrder(pic, wrong);
				back.add(pic);
				wrong++;
			}
		}

		f.revalidate();
		f.repaint();
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
		// This doesnt do anything
	}
}
