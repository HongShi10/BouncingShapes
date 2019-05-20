package robot;

import java.awt.*;

public class DynamicWheeledRobot extends Robot {
    private Color _color = Color.black; //Default colour is black
    private boolean _fillRect;
    private int _deltaX = super._deltaX;
    private int _deltaY = super._deltaY;



    public DynamicWheeledRobot() {
        super();
    }

    public DynamicWheeledRobot(Color color) {
        super();
        _color = color;
    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);

    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, Color color) {
        super(x,y,deltaX,deltaY);
        _color = color;

    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }

    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x,y,deltaX,deltaY,width,height);
        _color = color;
    }
    public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height,String text,Color color) {
        super(x,y,deltaX,deltaY,width,height,text);
        _color = color;
    }

    @Override
    public void move(int width, int height) {
        if(_deltaX == -super._deltaX ){ //When the horizontal velocity changes it means it has bounced of left or right wall
            _fillRect = true;//Sets the boolean to true means  when paint is called it fills the shape with the colour
        }
        else if(_deltaY == -super._deltaY){//When the vertical velocity changes that means that the top and bottom walls
            _fillRect = false;//When top and bottom walls are hit that means the shape gets unfilled so sets to false
        }
        _deltaX = super._deltaX;
        _deltaY = super._deltaY;
        super.move(width, height);
    }

    @Override
    public void paintObject(Painter painter) {
        if (_fillRect){
            painter.setColour(_color);//Sets the colour specified during construction
            painter.fillRect(_x, _y, _width, _height);//Calls the fillRect method in GraphicsPainter and fills the shape
            painter.drawRect(_x, _y, _width, _height);
            painter.setColour(Color.black);//Sets the colour back to black
        }
        else{
            painter.setColour(Color.black);//Reverts back to black outline since default
            painter.drawRect(_x, _y, _width, _height);
        }
    }
}
