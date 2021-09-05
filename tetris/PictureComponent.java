import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class PictureComponent extends JComponent
{
  public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;

    // I Block
    g2.setColor(Color.CYAN);
    Rectangle rectangleone = new Rectangle(0, 20, 20, 20);
    g2.fill(rectangleone);
    Rectangle rectangletwo = new Rectangle(0,40 , 20, 20);
    g2.fill(rectangletwo);
    Rectangle rectangle3 = new Rectangle(0, 60, 20, 20);
    g2.fill(rectangle3);
    Rectangle rectangle4 = new Rectangle(0,80 , 20, 20);
    g2.fill(rectangle4);
   
    //j Block
    g2.setColor(Color.BLUE);
    Rectangle rectangle5 = new Rectangle(20, 60, 20, 20);
    g2.fill(rectangle5);
    Rectangle rectangle6 = new Rectangle(20, 80, 20, 20);
    g2.fill(rectangle6);
    Rectangle rectangle7 = new Rectangle(20, 100, 20, 20);
    g2.fill(rectangle7);
    Rectangle rectangle8 = new Rectangle(0, 100, 20, 20);
    g2.fill(rectangle8);
   
    //L Block
    g2.setColor(Color.ORANGE);
    Rectangle rectangle9 = new Rectangle(40, 60, 20, 20);
    g2.fill(rectangle9);
    Rectangle rectangle10 = new Rectangle(40, 80, 20, 20);
    g2.fill(rectangle10);
    Rectangle rectangle11 = new Rectangle(40, 100, 20, 20);
    g2.fill(rectangle11);
    Rectangle rectangle12 = new Rectangle(60, 100, 20, 20);
    g2.fill(rectangle12);
   
    //O Block
    g2.setColor(Color.YELLOW);
    Rectangle rectangle13 = new Rectangle(80, 60, 20, 20);
    g2.fill(rectangle13);
    Rectangle rectangle14 = new Rectangle(60, 80, 20, 20);
    g2.fill(rectangle14);
    Rectangle rectangle15 = new Rectangle(60, 60, 20, 20);
    g2.fill(rectangle15);
    Rectangle rectangle16 = new Rectangle(80, 80, 20, 20);
    g2.fill(rectangle16);
   

    //S Block
    g2.setColor(Color.GREEN);
    Rectangle rectangle17 = new Rectangle(80, 120, 20, 20);
    g2.fill(rectangle17);
    Rectangle rectangle18 = new Rectangle(100, 140, 20, 20);
    g2.fill(rectangle18);
    Rectangle rectangle19 = new Rectangle(100, 120, 20, 20);
    g2.fill(rectangle19);
    Rectangle rectangle20 = new Rectangle(80, 100, 20, 20);
    g2.fill(rectangle20);
    
    //Z block
    g2.setColor(Color.RED);
    Rectangle rectangle21 = new Rectangle(100, 100, 20, 20);
    g2.fill(rectangle21);
    Rectangle rectangle22 = new Rectangle(120, 100, 20, 20);
    g2.fill(rectangle22);
    Rectangle rectangle23 = new Rectangle(120, 120, 20, 20);
    g2.fill(rectangle23);
    Rectangle rectangle24 = new Rectangle(140, 120, 20, 20);
    g2.fill(rectangle24);
    
    //T Block
    g2.setColor(Color.MAGENTA);
    Rectangle rectangle25 = new Rectangle(180, 100, 20, 60);
    g2.fill(rectangle25);
    Rectangle rectangle26 = new Rectangle(160, 120, 20, 20);
    g2.fill(rectangle26);
    

  }
}
