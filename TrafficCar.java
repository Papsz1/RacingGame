import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TrafficCar extends JPanel {

    private int carX = 100, carY = 100, carW = 50, carH = 50;
    private Image carPicture;

    public int getCarW() {
        return carW;
    }

    public void setCarW(int carW) {
        this.carW = carW;
    }

    public int getCarH() {
        return carH;
    }

    public void setCarH(int carH) {
        this.carH = carH;
    }

    public void setCarX(int carX) {
        this.carX = carX;
    }

    public void setCarY(int carY) {
        this.carY = carY;
    }

    public int getCarX() {
        return carX;
    }

    public int getCarY() {
        return carY;
    }

    public Image getCarPicture() {
        return carPicture;
    }

    public TrafficCar(int carX, int carY, File kep) {
        this.carX = carX;
        this.carY = carY;

        // Here we set the photo we want for the traffic car
        try {
            File f = kep;
            carPicture = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("The background could not be loaded");
        }
    }


}







