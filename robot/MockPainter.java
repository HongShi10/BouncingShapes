package robot;

import java.awt.*;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Craig Sutherland
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();
	private Color _color;
	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

    /**
     * Logs the drawHex call
     */
	public void drawHex(int x, int y, int width, int height) {
		if (width < 40) {
			_log.append("(Line " + (x+width/2) + "," + (y+height/2) + "," + (x+width/2) + "," + (y) + ")");
			_log.append("(Line " + (x+width/2) + "," + (y) + "," + (width+x) + "," + (y+height/2) + ")");
			_log.append("(Line " + (width+x) + "," + (y+height/2) + "," + (x+width/2) + "," + (y+height) + ")");
			_log.append("(Line " + (x+width/2) + "," + (y+height) + "," + (x) + "," + (y+height/2) + ")");
		}
		else {
			_log.append("(Line " + (x) + "," + (y+height/2) + "," + (x+20) + "," + (y) + ")");
			_log.append("(Line " + (x+20) + "," + (y) + "," + (width+x-20) + "," + (y) + ")");
			_log.append("(Line " + (width+x-20) + "," + (y) + "," + (width+x) + "," + (y+height/2) + ")");
			_log.append("(Line " + (width+x) + "," + (y+height/2) + "," + (width+x-20) + "," + (y+height) + ")");
			_log.append("(Line " + (width+x-20) + "," + (y+height) + "," + (x+20) + "," + (y+height) + ")");
			_log.append("(Line " + (x+20) + "," + (y+height) + "," + (x) + "," + (y+height/2) + ")");
		}
	}
    /**
     * Logs the fillRect call
     */
		@Override
	public void fillRect(int x, int y, int width, int height) {
		if(width<40) {
			_log.append("Filled(" + x + "," + y + "," + width + "," + height + ")");

		}
	}
    /**
     * Logs the getColour call
     */
	@Override
	public void getColour() {
		_log.append("(Colour found is " + _color +")");
	}
    /**
     * Logs the setColour call
     */
	public void setColour(Color color) {
		_color = color;
		_log.append("(Colour set is " + _color + ")");
	}
    /**
     * Logs the drawImage call
     */
	public void drawImage(Image img,int x,int y,int width,int height){
		_log.append("(Image " + x + "," + y + "," + width + "," + height + ","+ img +")");

	}

	public void translate(int x,int y){

	}
	public void drawCentredText(int x, int y, int width,int height,String text){

	}
}