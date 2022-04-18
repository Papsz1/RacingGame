import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class GameFrame extends JFrame {

    public GameFrame() {

        BackgroundMusic backgroundMusic = new BackgroundMusic();

        this.setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920, 1000);

        // We create a background panel on which we place the player's car as well as the traffic cars
        JPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        Car car = new Car();
        car.setOpaque(false);

        backgroundPanel.add(car);
        // The car class contains the key listener
        addKeyListener(car);
        add(backgroundPanel);


        Runnable Forgalom = new Runnable() {
            public void run() {

                // Check whether the player's car touched another car

                if (car.getxPoz() - ((BackgroundPanel) backgroundPanel).getCar1X() < 150 && car.getyPoz() - ((BackgroundPanel) backgroundPanel).getCar1Y() < 10) {
                    ((BackgroundPanel) backgroundPanel).setGameState();
                }
                if (((BackgroundPanel) backgroundPanel).getCar2X() - car.getxPoz() < 150 && ((BackgroundPanel) backgroundPanel).getCar2X() - car.getxPoz() > 0 && car.getyPoz() - ((BackgroundPanel) backgroundPanel).getCar2Y() < 20) {
                    ((BackgroundPanel) backgroundPanel).setGameState();

                }

                if (((BackgroundPanel) backgroundPanel).getCar3X() - car.getxPoz() < 150 && car.getyPoz() - ((BackgroundPanel) backgroundPanel).getCar3Y() < 10) {
                    ((BackgroundPanel) backgroundPanel).setGameState();
                }
                backgroundPanel.repaint();


            }
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(Forgalom, 0, 70, TimeUnit.MILLISECONDS);

        setVisible(true);
    }

}


