package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of classes Robot and WheeledRobot.
 * 
 * @author Craig Sutherland
 * 
 */
public class TestRobot {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Robot's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		WheeledRobot robot = new WheeledRobot(100, 20, 12, 15);
		robot.paint(_painter);
		robot.move(500, 500);
		robot.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Robot's position after the movement is correct.
	 */
	@Test
	public void testRobotMoveWithBounceOffRight() {
		WheeledRobot robot = new WheeledRobot(100, 20, 12, 15);
		robot.paint(_painter);
		robot.move(135, 10000);
		robot.paint(_painter);
		robot.move(135, 10000);
		robot.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", _painter.toString());
	}
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Robot's position after the movement is correct.
	 */
	@Test
	public void testRobotMoveWithBounceOffLeft() {
		WheeledRobot robot = new WheeledRobot(10, 20, -12, 15);
		robot.paint(_painter);
		robot.move(10000, 10000);
		robot.paint(_painter);
		robot.move(10000, 10000);
		robot.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", _painter.toString());
	}
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Robot's position after the movement is correct.
	 */
	@Test
	public void testRobotMoveWithBounceOffBottomAndRight() {
		WheeledRobot robot = new WheeledRobot(90, 90, 12, 15);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		assertEquals("(rectangle 90,90,25,35)(rectangle 100,100,25,35)"
				+ "(rectangle 88,85,25,35)", _painter.toString());
	}
	/**
	 * Test to check whether the shape of the FLyingRobot is made correctly
	 */
	@Test
	public void testFlyingRobotPaint() {
		FlyingRobot robot = new FlyingRobot(10, 10, 20, 20, 25, 25);
		robot.paint(_painter);
		assertEquals("(oval 10,10,25,25)", _painter.toString());
	}
	/**
	 * Test to check if a regular Tracked Robot is painted correctly by checking if each line contains the right x and
	 * y coordinates.
	 */
	@Test
	public void testRegTrackedRobotPaint() {
		TrackedRobot robot = new TrackedRobot(10, 90, 25, 30, 65, 45);
		robot.paint(_painter);
		assertEquals("(Line 10,112,30,90)(Line 30,90,55,90)(Line 55,90,75,112)(Line 75,112,55,135)" +
				"(Line 55,135,30,135)(Line 30,135,10,112)", _painter.toString());
	}
	/**
	 * Test to check if a small Tracked Robot is painted correctly by checking if each line contains the right x and
	 * y coordinates.
	 */
	@Test
	public void testSmallTrackedRobotPaint() {
		TrackedRobot robot = new TrackedRobot(10, 90, 25, 30, 20, 45);
		robot.paint(_painter);
		assertEquals("(Line 20,112,20,90)(Line 20,90,30,112)(Line 30,112,20,135)(Line 20,135,10,112)"
				, _painter.toString());
	}

	/**
	 * Test to check if the imageRobot shows the correct image
	 */
	@Test
	public void testImageRobotWithImage() {
		ImageRobot robot = new ImageRobot(10, 90, 25, 30, 20, 45,
				"IMG_6455.JPG");
		robot.paint(_painter);
		assertEquals("(Image 10,90,20,45,IMG_6455.JPG)"
				, _painter.toString());
	}
	/**
	 * Test to check that a ImageRobot is not made when no image is available
	 */
	@Test
	public void testImageRobotWithoutImage() {
		ImageRobot robot = new ImageRobot(10, 90, 25, 30, 20, 45);
		robot.paint(_painter);
		assertEquals("(Image 10,90,20,45,null)"
				, _painter.toString());
	}
}
