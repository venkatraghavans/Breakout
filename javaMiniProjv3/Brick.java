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
public class Brick extends baseImage{
    
     //String brick = "resources/brick4.png";

    boolean destroyed;
	int k;


    public Brick(int x, int y,String ibrick,int w) {
      this.x = x;
      this.y = y;
	k=w;
      //Toolkit T = Toolkit.getDefaultToolkit();
      //image = T.getImage(brick);
     //ImageIcon ii = new ImageIcon(this.getClass().getResource(brick));
      ImageIcon ii = createImageIcon(ibrick);
      image = ii.getImage();

      width = image.getWidth(null);
      heigth = image.getHeight(null);
      destroyed = false;
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

    public boolean isDestroyed()
    {
      return destroyed;
    }

    public void setDestroyed(boolean destroyed)
    {
      this.destroyed = destroyed;
    }


}
