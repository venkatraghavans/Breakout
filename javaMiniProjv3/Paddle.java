/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMiniProjv3;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
/**
 *
 * @author acer
 */
public class Paddle extends baseImage implements Commons {
    
    String paddle = "resources/paddle.png";

    int dx;

    public Paddle() {

        //Toolkit T = Toolkit.getDefaultToolkit();
        //image = T.getImage(paddle);
      ImageIcon ii = new ImageIcon(this.getClass().getResource(paddle));
        //ImageIcon ii = createImageIcon(paddle);
        image = ii.getImage();

        width = image.getWidth(null);
        heigth = image.getHeight(null);

        resetState();

    }
    /** Returns an ImageIcon, or null if the path was invalid. */
protected ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        //System.err.println("Path found file: " + path);
        return new ImageIcon(imgURL);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

    public void move() {
        x += dx;
        if (x <= 2) 
          x = 2;
        if (x >= Commons.PADDLE_RIGHT)
          x = Commons.PADDLE_RIGHT;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
		//System.out.print(" ");

        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
		//System.out.print(" ");
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
		//System.out.print(" ");
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
		//System.out.print(" ");
        }
    }

    public void resetState() {
        x = 310;
        y = 400;
    }

}
