package robot.forms;

import robot.CarrierRobot;
import robot.CustomRobot;
import robot.RobotModel;
import robot.forms.util.Form;
import robot.forms.util.FormHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomRobotFormHandler implements FormHandler {

    private RobotModel _model;
    private CarrierRobot _parentOfNewRobot;
    private File imageFile;
    private int width;
    private int deltaX;
    private int deltaY;
    private Worker worker = new Worker();

    public CustomRobotFormHandler(RobotModel model, CarrierRobot parent) {
        _model = model;
        _parentOfNewRobot = parent;
    }
    private class Worker extends SwingWorker<BufferedImage,Void> {
        @Override
        protected BufferedImage doInBackground() throws Exception {
            // Load the original image (ImageIO.read() is a blocking call).
            BufferedImage fullImage = null;
            try {
                fullImage = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.out.println("Error loading image.");
            }

            int fullImageWidth = fullImage.getWidth();
            int fullImageHeight = fullImage.getHeight();

            BufferedImage scaledImage = fullImage;

            // Scale the image if necessary.
            if (fullImageWidth > width) {
                double scaleFactor = (double) width / (double) fullImageWidth;
                int height = (int) ((double) fullImageHeight * scaleFactor);
                scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = scaledImage.createGraphics();

                // Method drawImage() scales an already loaded image. The
                // ImageObserver argument is null because we don't need to monitor
                // the scaling operation.
                g.drawImage(fullImage, 0, 0, width, height, null);
            }
            return scaledImage;
        }

        public void done() {
            try {
                BufferedImage scaledImage = get();
                // Create the new Robot and add it to the model.
                CustomRobot imageRobot = new CustomRobot(deltaX, deltaY, scaledImage);
                _model.add(imageRobot, _parentOfNewRobot);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void processForm(Form form) {
        // Read field values from the form.
        imageFile = (File)form.getFieldValue(File.class, ImageFormElement.IMAGE);
        width = form.getFieldValue(Integer.class, RobotFormElement.WIDTH);
        deltaX = form.getFieldValue(Integer.class, RobotFormElement.DELTA_X);
        deltaY = form.getFieldValue(Integer.class, RobotFormElement.DELTA_Y);
        worker.execute();
    }

}
