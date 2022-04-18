import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;

public class Car extends JPanel implements KeyListener {
    private int xPoz = 800;
    private int yPoz = 800;
    private BufferedImage img;

    public int getxPoz() {
        return xPoz;
    }

    public int getyPoz() {
        return yPoz;
    }

    public Car() {
        try {
            File f = new File("src/car.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("The photo could not be loaded");
        }
        ;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, xPoz, yPoz, 300, 300, this);
    }

    // Key listener, we can use the left and right arrow keys
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (xPoz < 1400)
                xPoz += 170;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (xPoz > 200)
                xPoz -= 170;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
