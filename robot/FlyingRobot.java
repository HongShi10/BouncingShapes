package robot;

public class FlyingRobot extends Robot{
	
	public FlyingRobot() {
		super();
	}
	
	public FlyingRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public FlyingRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	public FlyingRobot(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	public void paintObject(Painter painter) {
		painter.drawOval(_x,_y,_width,_height);
	}
}
