import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* @author  Michael Kolling and David J. Barnes
* recursiveTriangle method by Lode Vandevenne:
* http:lodev.org/cgtutor/sierpinski.html
*/
public class SierpinskiTriangle extends JPanel {

	private Dimension screenSize;
	private int screenHeight;
	private int screenWidth;
	private int depth = 7;

	public void paint(Graphics g) {

		screenSize = this.getSize();
		screenHeight = (int) screenSize.getHeight();
		screenWidth = (int) screenSize.getWidth();

		if(screenWidth > screenHeight){
			screenWidth = screenHeight;
		}
		else if (screenHeight > screenWidth){
			screenHeight = screenWidth;
		}
		
		int[] xcoords = { 0, screenWidth, (screenWidth) / 2 };
		int[] ycoords = { screenHeight, screenHeight, 0 };
		g.setColor(Color.LIGHT_GRAY);
		g.fillPolygon(xcoords, ycoords, xcoords.length);

	    recursiveTriangle
	    (
	      1, 
	      (0 + screenWidth) / 2,
	      (screenHeight + screenHeight) / 2, 
	      (0 + (screenWidth / 2)) / 2,
	      (screenHeight + 0) / 2, 
	      (screenWidth + (screenWidth / 2)) / 2, 
	      (screenHeight + 0) / 2, 
	      g,
	      Color.YELLOW
	    );
		

	}

	public SierpinskiTriangle() {
		screenSize = null;
		screenHeight = 0;
		screenWidth = 0;
	}
	
	public void recursiveTriangle(int n, float x1, float y1, float x2, float y2, float x3, float y3, Graphics g, Color colour)
	{
	  
		int[] xcoords = { (int) x1, (int) x2, (int) x3 };
		int[] ycoords = { (int) y1, (int) y2, (int) y3 };
		g.setColor(colour);
		g.fillPolygon(xcoords, ycoords, xcoords.length);

	  if(n < depth)
	  {
	    
	    recursiveTriangle
	    (
	      n+1, 
	      (x1 + x2) / 2 + (x2 - x3) / 2, 
	      (y1 + y2) / 2 + (y2 - y3) / 2, 
	      (x1 + x2) / 2 + (x1 - x3) / 2, 
	      (y1 + y2) / 2 + (y1 - y3) / 2, 
	      (x1 + x2) / 2, 
	      (y1 + y2) / 2, 
	      g,
	      colour.darker()
	    );
	    
	    recursiveTriangle
	    (
	      n+1, 
	      (x3 + x2) / 2 + (x2 - x1) / 2, 
	      (y3 + y2) / 2 + (y2 - y1) / 2, 
	      (x3 + x2) / 2 + (x3 - x1) / 2, 
	      (y3 + y2) / 2 + (y3 - y1) / 2, 
	      (x3 + x2) / 2, 
	      (y3 + y2) / 2, 
	      g,
	      colour.darker()
	      
	    );
	    
	    recursiveTriangle
	    (
	      n+1, 
	      (x1 + x3) / 2 + (x3 - x2) / 2, 
	      (y1 + y3) / 2 + (y3 - y2) / 2, 
	      (x1 + x3) / 2 + (x1 - x2) / 2, 
	      (y1 + y3) / 2 + (y1 - y2) / 2, 
	      (x1 + x3) / 2, 
	      (y1 + y3) / 2,  
	      g,
	      colour.darker()
	    );
	  }
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SierpinskiTriangle());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.setVisible(true);
	}

}