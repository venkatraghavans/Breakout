/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMiniProjv3;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
/**
 *
 * @author acer
 */
public class Ball extends baseImage implements Commons{
    
     private int xdir;
   private int ydir;

   protected String ball = "resources/ball2.png";

   public Ball() {

     xdir = 1;
     ydir = -1;

    // Toolkit T = Toolkit.getDefaultToolkit();
     //image = T.getImage(ball);
     ImageIcon ii = new ImageIcon(this.getClass().getResource(ball));
     //ImageIcon ii = createImageIcon(ball);
     image = ii.getImage();

     //System.out.println("in ball.java");
    // System.out.println("image " + image);
     width = image.getWidth(null);
     heigth = image.getHeight(null);
    // System.out.println("width "+width+" height "+heigth);

     resetState();
    }

   protected ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

    public void move()
    {
      x += xdir;
      y += ydir;

      if (x == 0) {
        setXDir(1);
      }

      if (x == BALL_RIGHT) {
        setXDir(-1);
      }

      if (y == 0) {
        setYDir(1);
      }
    }

    public void resetState() 
    {
      x = 340;
      y = 395;
    }

    public void setXDir(int x)
    {
      xdir = x;
    }

    public void setYDir(int y)
    {
      ydir = y;
    }

    public int getYDir()
    {
      return ydir;
    }

}
