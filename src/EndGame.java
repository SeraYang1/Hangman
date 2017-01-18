import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndGame implements ActionListener {
	/**
	 * New JFrame that tells user they won or lost. Has a button to restart the
	 * game.
	 * 
	 * @param str
	 *            Lose or Win
	 * @param c
	 *            Color of background
	 */
	public EndGame(String str, Color c) {
		JFrame j = new JFrame(str);
		j.setLayout(null);
		j.getContentPane().setBackground(c);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton startOver = new JButton("Start Over");
		startOver.setSize(new Dimension(80, 40));
		startOver.setLocation(160, 250);
		startOver.addActionListener(this);
		j.add(startOver);

		JLabel s = new JLabel(str);
		s.setSize(new Dimension(80, 40));
		s.setLocation(170, 125);
		j.add(s);

		j.setPreferredSize(new Dimension(400, 400));
		j.setVisible(true);
		j.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Main();
	}

}
