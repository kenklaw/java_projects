import javax.swing.JFrame;

public class PictureViewer
{
   public static void main(String[] args)
   {
// creates the from for the picture to be displayed on.
      JFrame frame = new JFrame();
// sets frame to 200 by 200
      frame.setSize(300, 300);
      frame.setTitle("Tetris");
// allows program to be terminated.
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PictureComponent picture = new PictureComponent();
      frame.add(picture);

      frame.setVisible(true);
   }
}
