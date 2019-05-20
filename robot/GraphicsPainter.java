package robot;

import java.awt.*;


/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Craig Sutherland
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;
	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see robot.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see robot.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	public void drawHex(int _x, int _y, int _width, int _height) {
		if (_width<40) {
			//top left and top right
				int x1 = _x+_width/2; 
				int y1 = _y; 
			//bottom left and bottom right
				int x2 = _x+_width/2; 
				int y2 = _y+_height; 
			//left most vertex
				int x3 = _x;
				int y3 = _y+_height/2;
			//Right most vertex
				int x4 = _width+_x;
				int y4 =  _y+_height/2;
            _g.drawLine(x3, y3, x1, y1); //Draws from left to top vertex
            _g.drawLine(x1, y1, x4, y4); //Draws from top vertex to right vertex
			_g.drawLine(x4, y4, x2, y2); //Draws right to bottom vertex
			_g.drawLine(x2, y2, x3, y3); //Draws from bottom to left
		}
		else {
		//top left
			//Top and bottom x coordinate
			int x1 = _x+20; //Since the top left must be 20 pixels to the right of bounding box
			//Top left and right vertices y coordinate
			int y1 = _y;
			//Top right and bottom right x coordinate
			int x2 = _width+_x-20; //Since the top right must be 20 pixels to the left of bounding box
			//Middle left x coordinate
			int x3 = _x;
			//Middle left and right y coordinate
			int y3 = _y+_height/2; //The middle of the bounding box must be half the height and from where the point starts
			//middle right x coordinate
			int x4 = _width+_x;
			//Bottom left and right y coordinate
			int y5 = _y+_height; //Bottom vertices must be at the lowest height

            _g.drawLine(x3, y3, x1, y1);//middle left to top left
			_g.drawLine(x1, y1, x2, y1);//Top left to top right
			_g.drawLine(x2, y1, x4, y3);//top right to middle right
			_g.drawLine(x4, y3, x2, y5);//middle right to bottom right
			_g.drawLine(x2, y5, x1, y5);//bottom right to bottom left
			_g.drawLine(x1, y5, x3, y3);//bottom left to middle left

		}
		
	}

	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x,  y, width, height);
	}

	public void getColour() {
		 _g.getColor();
	}
	public void setColour(Color color) {
	    _g.setColor(color);
	}

	public void drawImage(Image img,int x,int y,int width,int height){
			_g.drawImage(img,x,y,width,height,null);//Calls the draw image function on the Graphics object
	}
	public void translate(int x,int y){
		_g.translate(x,y);
	}

	public void drawCentredText(int x,int y,int width, int height,String text){
		int adjust = 0;
		setColour(Color.black);//Makes the text black
		FontMetrics fontMetrics = _g.getFontMetrics();//Gets the fontMetric details
		//Finds the y position to start the text```
		if(fontMetrics.getAscent() > fontMetrics.getDescent()) {//If Ascent is greater then Descent
			 adjust = (fontMetrics.getAscent()-fontMetrics.getDescent())/2;
		}
		else if(fontMetrics.getAscent() < fontMetrics.getDescent()) {//If Descent is greater then Ascent
			 adjust = (fontMetrics.getDescent() - fontMetrics.getAscent())/2;
		}
        int xPos= x+(width- fontMetrics.stringWidth(text)) / 2; //positions where to start from the x axis
        int yPos = adjust + y + (height / 2);
		_g.drawString(text,xPos,yPos);
	}
}
