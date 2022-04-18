import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private Image hatter;
    private Image jatekVege;
    private boolean gameState = true;
    TrafficCar auto1, auto2, auto3;
    private int car1X = 100, car1Y = 100, car2X = 100, car2Y = 100, car3X = 100, car3Y = 100, messageX = 370, messageY = 0;


    // Getters for the 3 traffic cars
    public int getCar1X() {
        return auto1.getCarX();
    }

    public int getCar1Y() {
        return auto1.getCarY();
    }

    public int getCar2X() {
        return auto2.getCarX();
    }

    public int getCar2Y() {
        return auto2.getCarY();
    }

    public int getCar3X() {
        return auto3.getCarX();
    }

    public int getCar3Y() {
        return auto3.getCarY();
    }

    public BackgroundPanel() {
        // We load the background and gameover pictures
        try {
            File f = new File("src/background.png");
            hatter = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("The background could not be loaded");
        }
        try {
            File f = new File("src/gameover.png");
            jatekVege = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("The game over image could not be loaded");
        }

        File kep1 = new File("src/trafficCar1.png");
        File kep2 = new File("src/carTraffic2.png");
        File kep3 = new File("src/carTraffic3.png");

        auto1 = new TrafficCar(850, 0, kep1);
        auto2 = new TrafficCar(950, -1000, kep2);
        auto3 = new TrafficCar(950, -2000, kep3);
    }

    public void setGameState() {
        this.gameState = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (gameState == false)
            // If the game's over, we display the gameover picture
            g.drawImage(jatekVege, 700, 300, null);
        else {

            super.paintComponent(g);
            g.drawImage(hatter, 0, 0, null);

            if (messageY > -3000)
                messageY -= 20;

            //The cars' movement is set manually for every coordinate, height, width and positioning
            if (auto1.getCarY() > 1000) {
                auto1.setCarH(50);
                auto1.setCarW(50);
                auto1.setCarY(-500);
                auto1.setCarX(850);
            } else if (auto1.getCarY() >= 600) {
                auto1.setCarW(auto1.getCarW() + 15);
                auto1.setCarH(auto1.getCarH() + 15);
                auto1.setCarX(auto1.getCarX() - 30);
                g.drawImage(auto1.getCarPicture(), auto1.getCarX(), auto1.getCarY(), auto1.getCarW(), auto1.getCarH(), null);
            }
            auto1.setCarY(auto1.getCarY() + 15);


            if (auto2.getCarY() > 1000) {
                auto2.setCarH(50);
                auto2.setCarW(50);
                auto2.setCarY(-500);
                auto2.setCarX(950);
            } else if (auto2.getCarY() >= 600) {
                auto2.setCarW(auto2.getCarW() + 15);
                auto2.setCarH(auto2.getCarH() + 15);
                auto2.setCarX(auto2.getCarX() - 5);
                g.drawImage(auto2.getCarPicture(), auto2.getCarX(), auto2.getCarY(), auto2.getCarW(), auto2.getCarH(), null);
            }
            auto2.setCarY(auto2.getCarY() + 15);


            if (auto3.getCarY() > 1000) {
                auto3.setCarH(50);
                auto3.setCarW(50);
                auto3.setCarY(-500);
                auto3.setCarX(850);
            } else if (auto3.getCarY() >= 600) {
                auto3.setCarW(auto3.getCarW() + 15);
                auto3.setCarH(auto3.getCarH() + 15);
                auto3.setCarX(auto3.getCarX() + 30);
                g.drawImage(auto3.getCarPicture(), auto3.getCarX(), auto3.getCarY(), auto3.getCarW(), auto3.getCarH(), null);
            }
            auto3.setCarY(auto3.getCarY() + 15);


        }
    }
}