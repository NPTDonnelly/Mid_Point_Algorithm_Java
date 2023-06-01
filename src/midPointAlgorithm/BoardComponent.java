package midPointAlgorithm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class BoardComponent extends JComponent {
	private int pixelSize,circleSize;
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		Board b1= new Board(pixelSize,circleSize);
		b1.draw(g2);
	}
	
	public BoardComponent(int p, int c){
		pixelSize=p;
		circleSize=c;
	}



}