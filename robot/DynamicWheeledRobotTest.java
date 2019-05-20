package robot;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class DynamicWheeledRobotTest {

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

    @Test
    public void testDynamicWheeledRobotBounceOffRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 20, 12, 15,Color.cyan);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        robot.move(135, 10000);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 100,20,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 110,35,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=255,b=255])Filled(98,50,25,35)(rectangle 98,50,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])"
                , _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is filled with the correct colour when bouncing off the left wall
     */
    @Test
    public void testDynamicWheeledRobotBounceOffLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 20, -12, 15,Color.red);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])" +
                        "(rectangle 10,20,25,35)(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 0,35,25,35)" +
                        "(Colour set is java.awt.Color[r=255,g=0,b=0])Filled(12,50,25,35)(rectangle 12,50,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is not filled when bouncing off the top wall
     */
    @Test
    public void testDynamicWheeledRobotBounceOffTop() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 50, -12, -50,Color.orange);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 100,50,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 88,0,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 76,50,25,35)",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is not filled when bouncing off the top wall
     */
    @Test
    public void testDynamicWheeledRobotBounceOffBottom() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(50, 390, 1, 10,Color.green);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 50,390,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 51,365,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 52,355,25,35)",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is filled when bouncing off the bottom wall and left wall at the same time
     */
    @Test
    public void testDynamicWheeledRobotBounceOffBottomAndLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 390, -15, 15,Color.red);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 10,390,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 0,365,25,35)" +
                        "(Colour set is java.awt.Color[r=255,g=0,b=0])Filled(15,350,25,35)" +
                        "(rectangle 15,350,25,35)(Colour set is java.awt.Color[r=0,g=0,b=0])",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is filled when bouncing off the bottom wall and left wall at the same time
     */
    @Test
    public void testDynamicWheeledRobotBounceOffBottomAndRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(90, 390, 15, 15,Color.red);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        robot.move(100, 400);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 90,390,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 75,365,25,35)" +
                        "(Colour set is java.awt.Color[r=255,g=0,b=0])Filled(60,350,25,35)(rectangle 60,350,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is filled when bouncing off the top wall and left wall at the same time
     */
    @Test
    public void testDynamicWheeledRobotBounceOffTopAndLeft() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(20, 20, -30, -30,Color.orange);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        robot.move(10000, 10000);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 20,20,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 0,0,25,35)" +
                        "(Colour set is java.awt.Color[r=255,g=200,b=0])Filled(30,30,25,35)" +
                        "(rectangle 30,30,25,35)(Colour set is java.awt.Color[r=0,g=0,b=0])",
                _painter.toString());
    }
    /**
     * Test to check if a DynamicWheeledRobot is filled when bouncing off the top wall and right wall at the same time
     */
    @Test
    public void testDynamicWheeledRobotBounceOffTopAndRight() {
        DynamicWheeledRobot robot = new DynamicWheeledRobot(60, 10, 30, 30,Color.orange);
        robot.paint(_painter);
        robot.move(100, 10000);
        robot.paint(_painter);
        robot.move(100, 10000);
        robot.paint(_painter);
        assertEquals("(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 60,10,25,35)" +
                        "(Colour set is java.awt.Color[r=0,g=0,b=0])(rectangle 75,40,25,35)" +
                        "(Colour set is java.awt.Color[r=255,g=200,b=0])Filled(45,70,25,35)" +
                        "(rectangle 45,70,25,35)(Colour set is java.awt.Color[r=0,g=0,b=0])",
                _painter.toString());
    }

}
