package robot;

import java.awt.*;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Craig Sutherland
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	public void drawHex(int x1, int y1, int x2, int y2);

	public void fillRect(int x, int y, int width, int height);

	public void getColour();

	public void setColour(Color color);

	public void drawImage(Image img,int x,int y,int width,int height);

	void translate( int x, int y );

	public void drawCentredText(int x,int y,int width,int height,String text);


}
