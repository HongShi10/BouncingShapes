package robot;

public class TrackedRobot extends Robot {
	
	public TrackedRobot() {
		super();
	}
	
	public TrackedRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public TrackedRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	public TrackedRobot(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	public void paintObject(Painter painter) {
		painter.drawHex(_x, _y,_width, _height); //Calls method to draw a hexagon in GraphicsPainter
		
	}
}

