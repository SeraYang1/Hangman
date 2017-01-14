import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class LoadImage extends JComponent implements Icon {
	BufferedImage img;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public LoadImage(String name) {
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
		}
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(img.getWidth(), img.getHeight());
		}
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public int getIconWidth() {
		return img.getWidth();
	}

	@Override
	public int getIconHeight() {
		return img.getHeight();
	}

}
