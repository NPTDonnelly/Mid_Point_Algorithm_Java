package midPointAlgorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Board {
	
	private int size, cs;
	
	public Board(int s, int c) {
		size=s;
		cs=c;
	}
	


	public void draw(Graphics2D g2) {
		int xLeft, yTop, row, col;
		ArrayList<Integer> xDB = new ArrayList<Integer>(); // Create an ArrayList object x value
		ArrayList<Integer> yDB = new ArrayList<Integer>();//  Create an ArrayList object y value
		
		int x_centre =cs/2;
		int y_centre=cs/2;
		int r=(cs-1)/2;
		int x = r, y = 0;
		
			xDB.add(x + x_centre);
			yDB.add(y + y_centre);
		    if (r > 0) {
			xDB.add(-x + x_centre);
			yDB.add(-y + y_centre);
			xDB.add(y + x_centre);
			yDB.add(x + y_centre);
			xDB.add(-y + x_centre);
			yDB.add(-x + y_centre);
		    }

		    // Initialising the value of P
		    int P = 1 - r;
		    while (x > y) {
		    	y++;
		    	// Mid-point is inside or on the perimeter
		    	if (P <= 0)
		    		P = P + 2 * y + 1;
		    	// Mid-point is outside the perimeter
		    	else {
		    		x--;
		    		P = P + 2 * y - 2 * x + 1;
		    	}
		    	// All the perimeter points have already been printed
		    	if (x < y)
		    	break;
		    	// Printing the generated point and its reflection in the other octants after translation
				xDB.add(x + x_centre);
				yDB.add(y + y_centre);
				xDB.add(-x + x_centre);
				yDB.add(y + y_centre);
				xDB.add(x + x_centre);
				yDB.add(-y + y_centre);
				xDB.add(-x + x_centre);
				yDB.add(-y + y_centre);
		    	// If the generated point is on the line x = y then the perimeter points have already been printed
		    	if (x != y) {
				xDB.add(y + x_centre);
				yDB.add(x + y_centre);
				xDB.add(-y + x_centre);
				yDB.add(x + y_centre);
				xDB.add(y + x_centre);
				yDB.add(-x + y_centre);
				xDB.add(-y + x_centre);
				yDB.add(-x + y_centre);
		    	}
		    }
		
		//generate columns and rows to create circle
		for(row=0; row<cs; row++) {
			for(col=0;col<cs;col++) {
				//generate empty square use col and row value
				xLeft =col*size;
				yTop=row*size;
				g2.setColor(Color.black);
				g2.drawLine(xLeft, yTop, xLeft+size, yTop+0);
				g2.drawLine(yTop,xLeft, yTop+0, xLeft+size);
				//loop through each value of xDB and yDB
		        for (int counter = 0; counter < xDB.size(); counter++) { 
		        	//match for correct xy coordinates for circle  
		            if(xDB.get(counter)==row&&yDB.get(counter)==col) {
						g2.setColor(Color.red);	
						g2.fillRect(xLeft, yTop, size, size);
		            }	
		        }  
			}
		}
		//clear arrays new user input 
        yDB.clear();
        xDB.clear();
	}

}
