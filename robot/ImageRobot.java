package robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * Class to represent a ImageRobot where it displays a picture that is provided.
 *
 * @author Hong Shi
 *
 */
public class ImageRobot extends Robot {
    private Image _img;
    private String _imagePath;
    ;

    //Constructors for different input parameters *overloads
    public ImageRobot() {
        super();
    }

    public ImageRobot(String imagePath) {
        super();
        this.setImagePath(imagePath);
    }

    public ImageRobot(int x, int y, int deltaX, int deltaY, String imagePath) {
        super(x, y, deltaX, deltaY);
        //Will call setImagePath method that sets the file path to _imagePath and converts the file path into a image
        //object
        this.setImagePath(imagePath);
    }

    public ImageRobot(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    public ImageRobot(int x, int y, int deltaX, int deltaY, int width, int height, String imagePath) {
        super(x, y, deltaX, deltaY, width, height);
        this.setImagePath(imagePath);
    }

    public ImageRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);

    }

    public void setImagePath(String imagePath) {
        File file = new File(imagePath);//Creates a file type for the image path
        try {//Try catch statement to catch IOException if it occurs
            _img = ImageIO.read(file);//Reads the file type and converts it into a image
        } catch (IOException e) {
            System.out.println("File not found");
        }
        _imagePath = imagePath;//Sets the field
    }


    public void paintObject(Painter painter) {
        painter.drawImage(_img, _x, _y, _width, _height); //Calls the drawImage function in graphics painter
    }
}

