/*
Assignment 4
Date: 3/25/19
Names: Armando Valdez and Max Nelson
 */

package motionparallaxmain;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MotionParallaxMain extends JFrame {
   private int currentX = 0 ; // Mouse cursor's X position
   private int currentY = 0 ; // Mouse cursor's Y position 
   private int delay = 10;
   Random rand = new Random();
   Color randomColor1 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
   Color randomColor2 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
   Color randomColor3 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
   Color backgroundColor = new Color(0,191,245);
   int birdX = 20;
   int birdX2 = 35;
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
      
   }
   
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
       int treeTrunkX = 400;
       int treeTrunkY = 400;
       int treeLeafsX = 379; 
       int treeLeafsY = 352;
       int sunX = 150;
       int sunY = 100;
       


      for (int i = 0; i < 3; i++)
      {
          sunX += currentX * 0.01;
          sunY += currentY * 0.01;
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
      treeTrunkY += currentY * .5;
      treeLeafsX += currentX * .5;
      treeLeafsY += currentY * .5;
      
      
      //Sets background for the sky
      g.setColor(backgroundColor);
      g.fillRect(0, 0, 500, 500);
      
      //draws the sun
      g.setColor(Color.YELLOW);
      g.fillOval(sunX, sunY, 50,50);
      
      //Draws the mountains 
      g.setColor(randomColor1);
      g.fillPolygon(darkGrayMountainX, darkGreyMountainY, 3);
      g.setColor(randomColor2);
      g.fillPolygon(lightGrayMountainX, lightGrayMountainY, 3);
      g.setColor(randomColor3);
      g.fillPolygon(blackMountainX, blackMountainY, 3);
      

      g.setColor(Color.BLACK);
      g.drawLine(birdX, 85, birdX2, 95);
      g.drawLine(birdX + 15,95, birdX2 + 15, 85);

      
      //Draws the grass
      g.setColor(Color.GREEN);
      g.fillRect(grassX, grassY, 1500, 350);
      
      //draw tree trunk
      g.setColor(Color.BLACK);
      g.fillRect(treeTrunkX, treeTrunkY, 30, 80);
      //draw tree leafs
      g.setColor(Color.GRAY);
      g.fillOval(treeLeafsX, treeLeafsY, 70, 100);
      
   }


   private class MyMouseListener implements MouseListener
   {
      // when the mouse is pressed and held down, the sky will turn to nighttime 
      public void mousePressed(MouseEvent e)

      {
            backgroundColor = new Color(0,0,128);
            repaint();
       }
      
      
      // when the mouse is clicked and released, the mountains will change color
        
      

      public void mouseClicked(MouseEvent e)
      {
        randomColor1 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        randomColor2 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        randomColor3 = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        repaint();
      }

       // when the mouse is released after being held, it will change back to nighttime
      public void mouseReleased(MouseEvent e)
      {
          backgroundColor = new Color(0,191,245);
      }

      public void mouseEntered(MouseEvent e)
      {
          birdX += 100;
          birdX2 += 100;
          repaint();
      }

      public void mouseExited(MouseEvent e)
      {


          currentX = 0;
          currentY = 0;
          repaint();

      }
   }
 
   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
          currentX = e.getX() - 250;

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

