package robot;

import java.util.ArrayList;
import java.util.List;

public class CarrierRobot extends Robot {

    private List<Robot> _nestedRobots = new ArrayList<Robot>();
    /**
     * Creates a CarrierRobot object with default values for state.
     */
    public CarrierRobot() {
        super();
    }
    /**
     * Creates a CarrierRobot object with specified location values,
     * default values for other state items.
     */
    public CarrierRobot(int x, int y) {
        super(x,y);
    }
    /**
     * Creates a CarrierRobot with specified values for location, velocity
     * and direction. Non-specified state items take on default values.
     */
    public CarrierRobot(int x, int y, int deltaX, int deltaY) {
        super(x,y,deltaX,deltaY);
    }
    /**
     * Creates a CarrierRobot with specified values for location, velocity,
     * direction, width and height.
     */
    public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x,y,deltaX,deltaY,width,height);
    }
    public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
        super(x,y,deltaX,deltaY,width,height,text);
    }
    /**
     * Moves a CarrierRobot object (including its children) within the bounds
     * specified by arguments width and height.
     */
    public void move(int width,int height){
        super.move(width,height);
        for(Robot robot : _nestedRobots) {
            robot.move(this._width,this._height);
        }
    }
    /**
     * Paints a CarrierRobot object by drawing a rectangle around the edge of
     * its bounding box. The CarrierRobot object's children are then painted.
     */
    public void paintObject(Painter painter){
        painter.drawRect(_x, _y,_width, _height);
        painter.translate(_x, _y);//Translates the coordinates by x,y of the carrier shape so stays within carrier
        for(Robot robot : _nestedRobots){
            robot.paint(painter);
        }
        painter.translate(-_x,- _y);//Need to revert back to old coordinates in case any more Carrier robots get made
    }
    /**
     * Attempts to add a Robot to a CarrierRobot object. If successful, a
     * two-way link is established between the CarrierRobot and the newly
     * added Robot. Note that this method has package visibility - for reasons
     * that will become apparent in Robot III.
     * @param robot the robot to be added.
     * @throws IllegalArgumentException if an attempt is made to add a Robot
     * to a CarrierRobot instance where the Robot argument is already a child
     * within a CarrierRobot instance. An IllegalArgumentException is also
     * thrown when an attempt is made to add a Robot that will not fit within
     * the bounds of the proposed CarrierRobot object.
     */
    void add(Robot robot) throws IllegalArgumentException{
        //Statement that checks if the robot being added is smaller then the parent CarrierRobot
        if(robot._width >= this._width || robot._height >= this._height|| robot.parent() != null ||
                (robot._x+robot._width) > this._width || (robot._y+robot._height) > this._height){
            throw new IllegalArgumentException();
        }
        else {
            _nestedRobots.add(robot);
            robot._CarrierRobot = this; //Sets the field in the robot being added to the respective parent CarrierRobot
        }
    }
    /**
     * Removes a particular Robot from a CarrierRobot instance. Once removed,
     * the two-way link between the CarrierRobot and its former child is
     * destroyed. This method has no effect if the Robot specified to remove
     * is not a child of the CarrierRobot. Note that this method has package
     * visibility - for reasons that will become apparent in Robot III.
     * @param robot the robot to be removed.
     */
    void remove(Robot robot){
        _nestedRobots.remove(robot);
        robot._CarrierRobot = null; //Assigns the parent of this instance of robot to have no parent
    }
    /**
     * Returns the Robot at a specified position within a CarrierRobot. If
     * the position specified is less than zero or greater than the number of
     * children stored in the CarrierRobot less one this method throws an
     * IndexOutOfBoundsException.
     * @param index the specified index position.
     */
    public Robot robotAt(int index) throws IndexOutOfBoundsException{
        //Checks if index is valid when calling the method
        if(index>=_nestedRobots.size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        else{
            return _nestedRobots.get(index);
        }
    }
    /**
     * Returns the number of children contained within a CarrierRobot object.
     * Note this method is not recursive - it simply returns the number of
     * children at the top level within the callee CarrierRobot object.
     */
    public int robotCount(){
        return _nestedRobots.size();
    }
    /**
     * Returns the index of a specified child within a CarrierRobot object.
     * If the Robot specified is not actually a child of the CarrierRobot
     * this method returns -1; otherwise the value returned is in the range
     * 0 .. robotCount() - 1.
     * @param robot whose index position within the CarrierRobot is
     * requested.
     */
    public int indexOf(Robot robot) {
        return _nestedRobots.indexOf(robot);
    }
    /**
     * Returns true if the Robot argument is a chlid of the CarrierRobot
     * object on which this method is called, false otherwise.
     */
    public boolean contains(Robot robot) {
        return (_nestedRobots.contains(robot));
    }
}
