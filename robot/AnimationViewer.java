package robot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of robots. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimized, and maximized. The state of an
 * AnimationViewer object comprises a list of Robots and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Robots requesting that each Robot paints and moves itself.
 * 
 * @author Craig Sutherland
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Robots to animate.
	private List<Robot> _robots;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Robot objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		_robots = new ArrayList<Robot>();
	
		// Populate the list of Robots.
//        		_robots.add(new WheeledRobot(0, 0, 2, 3));
//				_robots.add(new WheeledRobot(10, 10, 5, 7));
//				_robots.add(new FlyingRobot(0,0,11,1,30,98));
//				_robots.add(new TrackedRobot(10,10,2,2,100,100));
//				_robots.add(new TrackedRobot(10,10,50,5,30,30));
//				_robots.add(new DynamicWheeledRobot(200,200,1,1,250,250,Color.green));
//				_robots.add(new DynamicWheeledRobot(50, 0, 3, 10,100,100, Color.pink));
//				_robots.add(new DynamicWheeledRobot(10,10,2,2,70,40));
//        _robots.add(new ImageRobot(100,230,3,10,180,200,"IMG_6455.JPG"));//Nisa

//		Robot tester = new DynamicWheeledRobot(0, 0, 8, 2,100,100);
 		Robot tester2 = new  DynamicWheeledRobot(3,10,7,5,15,15,Color.blue);
//     	Robot tester3 = new ImageRobot(30,30,3,10,140,150,"IMG_6478.JPG");
      Robot tester4 = new DynamicWheeledRobot(0, 0, 2, 1,40,40, Color.yellow);
//      Robot tester5 = new ImageRobot(30,30,3,10,40,40,"IMG_6455.JPG");
		//Creates new CarrierRobots
        CarrierRobot carrier = new CarrierRobot(0,0,4,2,350,350);
        CarrierRobot carrierNested = new CarrierRobot(40,40,2,2,150,150);
        CarrierRobot carrierNestedNested = new CarrierRobot(0,0,4,4,75,75);
		//Adds text to the carrierRobots
        carrier.addText("CarrierRobot");
		carrierNested.addText("CarrierRobot within CarrierRobot");
		carrierNestedNested.addText("CarrierRobot within CarrierRobot within CarrierRobot yay");
		carrierNestedNested.add(tester4);
		//Adds CarrierRobots to CarrierRobots
		 carrier.add(carrierNested);
		carrierNested.add(carrierNestedNested);
		carrierNested.add(tester2);
        _robots.add(carrier);
//Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Robot objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Robot robot : _robots) {
			robot.paint(painter);
			robot.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}

	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 522);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
