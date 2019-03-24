/*
Assignment 4
Date: 3/25/19
Names: Armando Valdez
 */

package motionparallaxmain;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MotionParallaxMain extends JFrame {
   private int currentX = 0 ; // Mouse cursor's X position
   private int currentY = 0 ; // Mouse cursor's Y position 
   private int delay = 25;
   protected Timer timer;
   MotionParallaxMain()
   {
       setTitle("Draw Boxes");
       setSize(500,500);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       addMouseListener(new MyMouseListener());
       addMouseMotionListener(new MyMouseMotionListener());
   }
   /**
      init method
   */
   
   public void init()
   {
      // Add a mouse listener and a mouse motion listener.
      
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      int darkGrayMountainX[] = {56, 250, 520};
      int darkGreyMountainY[] = {550, 80, 550};
      int lightGrayMountainX[] = {-450, 50, 450};
      int lightGrayMountainY[] = {550, 150, 550};
      int blackMountainX[] = {135, 450, 600};
      int blackMountainY[] = {550, 150, 550};
      int grassX = -200;
      int grassY = 350;
      int treeTrunkX;
      
      for (int i = 0; i < 3; i++)
      {
          darkGrayMountainX[i] += currentX * .2;
          darkGreyMountainY[i] += currentY * .2;
          lightGrayMountainX[i] += currentX * .3; 
          lightGrayMountainY[i] += currentY * .3;
          blackMountainX[i] += currentX * .4;
          blackMountainY[i] += currentY * .4;        
      }
      
      grassX += currentX *.5;
      grassY += currentY *.5;
      treeTrunkX += currentX *.5;
      
      
      //Sets background for the sky
      g.setColor(Color.blue);
      g.fillRect(0, 0, 500, 500);
      
      //Draws the mountains 
      g.setColor(Color.darkGray);
      g.fillPolygon(darkGrayMountainX, darkGreyMountainY, 3);
      g.setColor(Color.LIGHT_GRAY);
      g.fillPolygon(lightGrayMountainX, lightGrayMountainY, 3);
      g.setColor(Color.black);
      g.fillPolygon(blackMountainX, blackMountainY, 3);
      
      //Draws the grass
      g.setColor(Color.GREEN);
      g.fillRect(grassX, grassY, 1500, 350);
      
      //draw tree trunk
      g.setColor(Color.BLACK);
      g.fillRect(400, 400, 30, 80);
      //draw tree leafs
      g.setColor(Color.GRAY);
      g.fillOval(375, 363, 80, 80);
      
   }


   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      { 
      }
      public void mouseClicked(MouseEvent e)
      {
      }

      public void mouseReleased(MouseEvent e)
      {
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
      }
   }
 
   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
      }
      
      public void mouseMoved(MouseEvent e)
      {
          currentX = e.getX() - 250;
          currentY = e.getY() - 250;
          try 
          {
              TimeUnit.MILLISECONDS.sleep(15);
    	  }
          catch (InterruptedException e1)
          {
	      e1.printStackTrace();
    	  }
    	  repaint();
      }
   }

    public static void main(String[] args) {
        new MotionParallaxMain();
    }
    
}

