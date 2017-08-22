/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMiniProjv3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;
/**
 *
 * @author acer
 */
public class baseImage{
    
    protected int x;
    protected int y;
    protected int width;
    protected int heigth;
    protected Image image;


    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return heigth;
    }

    Image getImage()
    {
      return image;
    }

    public void changeImg(String ss)
    {
      image = new ImageIcon(this.getClass().getResource(ss)).getImage();
    }

    Rectangle getRect()
    {
        Rectangle R = new Rectangle(x, y,image.getWidth(null), image.getHeight(null));
       //System.out.println("in sprite "+image.getWidth(null) + " " + image.getHeight(null)+" "+R);
       
      return R;
    }
}
