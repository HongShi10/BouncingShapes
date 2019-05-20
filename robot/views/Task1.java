package robot.views;


import robot.CarrierRobot;
import robot.Robot;
import robot.RobotModel;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class Task1 implements TreeModel {

    protected RobotModel _robotModelAdaptee;
    protected List<TreeModelListener>  _treeModelListener = new ArrayList<TreeModelListener>();

        Task1(RobotModel robot){
        _robotModelAdaptee =  robot;
    }
    public void addTreeModelListener(TreeModelListener l){
            _treeModelListener.add(l);
    }
    public void removeTreeModelListener(TreeModelListener l){
            _treeModelListener.remove(l);
    }

    @Override
    public Object getRoot() {
        return  _robotModelAdaptee.root();
    }
    public Object getChild(Object parent,int Index){
        if(parent instanceof CarrierRobot) {
            try {
                return ((CarrierRobot) parent).robotAt(Index);
            } catch (IndexOutOfBoundsException e){//If out of bounds it will catch the error and return null
                return null;
            }
        }
        else{
            return null;
            }
    }
    public int getChildCount(Object parent){
        if(parent instanceof CarrierRobot){
            return ((CarrierRobot) parent).robotCount();
        }
        else{
            return 0;
        }
    }
    public boolean isLeaf(Object node){
        if(node instanceof CarrierRobot){
            return false;
        }
        else{
            return true;
        }
    }
    public void valueForPathChanged(TreePath path,Object newValue){

    }

    public int getIndexOfChild(Object parent,Object child){
        if(parent instanceof CarrierRobot){
            return ((CarrierRobot) parent).indexOf((Robot)child);
        }
        else {
            return -1;
        }
    }
}
