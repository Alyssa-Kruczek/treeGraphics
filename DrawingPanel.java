package DataStructures;
import java.awt.*;

/* class for drawing pictures from the Building Java Programs: Back to Basics book */

import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class DrawingPanel implements ActionListener {

 private static final int DELAY = 100;  // delay between repaints in millis
 private static final boolean PRETTY = false;  // true to anti-alias
 
 private int width, height;    // dimensions of window frame
 private JFrame frame;         // overall window frame
 private JPanel panel;         // overall drawing surface
 private BufferedImage image;  // remembers drawing commands
 private Graphics2D g2;        // graphics context for painting

 
 
 // construct a drawing panel of given width and height enclosed in a window
 public DrawingPanel(int width, int height) {
   this.width = width;
   this.height = height;
   image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
   
  
   panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
   panel.setBackground(Color.WHITE);
   panel.setPreferredSize(new Dimension(width, height));
   panel.add(new JLabel(new ImageIcon(image)));

   g2 = (Graphics2D)image.getGraphics();
   g2.setColor(Color.BLACK);
   if (PRETTY) {
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     g2.setStroke(new BasicStroke(1.1f));
   }
   
   frame = new JFrame("Drawing Panel");
   frame.setResizable(false);
   try {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so that this works in an applet
   } catch (Exception e) {}
   frame.getContentPane().add(panel);
   frame.pack();
   frame.setVisible(true);
   toFront();
   frame.requestFocus();
   
   // repaint timer so that the screen will update
   new Timer(DELAY, this).start();
 }
 
 
 // used for an internal timer that keeps repainting
 public void actionPerformed(ActionEvent e) {
   panel.repaint();
 }
 
 // obtain the Graphics object to draw on the panel
 public Graphics2D getGraphics() {
   return g2;
 }
 
 // set the background color of the drawing panel
 public void setBackground(Color c) {
   panel.setBackground(c);
 }
 
 // show or hide the drawing panel on the screen
 public void setVisible(boolean visible) {
   frame.setVisible(visible);
 }

 
 // close the drawing panel
 public void close() {
   frame.dispose();
 }
 
 // makes drawing panel become the frontmost window on the screen
 public void toFront() {
   frame.toFront();
 }

 // return panel width
 public int getWidth() {
    return width;
 }

 // return panel height
 public int getHeight() {
    return height;
 }
}