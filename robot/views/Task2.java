package robot.views;

import robot.*;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
public class Task2 extends Task1 implements RobotModelListener {

    public Task2(RobotModel model) {
        super(model);
    }


    @Override
    public void update(RobotModelEvent event) {
        Robot[] child = new Robot[1];
        int[] _index = new int[1];
        Object[] _path;
        if(event.parent()==null){
            _path = null; //Means root robot
        }
        else{
            _path = event.parent().path().toArray(new Robot[event.parent().path().size()]);//Finds the path from the root to its parent
        }
        child[0] = event.operand();
        RobotModel _source = event.source();
        _index[0] = event.index();


        if (event.eventType().equals(RobotModelEvent.EventType.RobotAdded)) {
              for (TreeModelListener l : _treeModelListener) {
                l.treeNodesInserted(new TreeModelEvent(_source, _path, _index, child));
            }
        } else if (event.eventType().equals(RobotModelEvent.EventType.RobotRemoved)) {
            for (TreeModelListener l : _treeModelListener) {
                l.treeNodesRemoved(new TreeModelEvent(_source, _path, _index, child));
            }
        }
    }
}
