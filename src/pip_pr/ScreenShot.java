package pip_pr;

import java.awt.AWTException;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
*
* @Author Daniel
* @param c
*/
public class ScreenShot implements ActionListener {
	JFrame frame;
	ScreenShot(JFrame frame1){
		frame=frame1;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JFileChooser file1 = new JFileChooser();
		      file1.setMultiSelectionEnabled(true);
		      file1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		      file1.setFileHidingEnabled(false);
		      if (file1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		         File f = file1.getSelectedFile();
		         System.out.println(f.getPath());
		         
		      }
		      //destinatie va fi path ul ales convertit la string
		    String destinatie = file1.getSelectedFile().getPath().toString();
            DisplayMode displayMode = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode();
            Rectangle screenRectangle = new Rectangle(displayMode.getWidth(), displayMode.getHeight());
            BufferedImage screenShot = new Robot().createScreenCapture(screenRectangle);
            //File file = new File(destinatie+"\\screen-capture.png");
            //ImageIO.write(screenShot, "png", file);
            
            Rectangle r = frame.getBounds();

            BufferedImage dst = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_ARGB);
            dst.getGraphics().drawImage(screenShot, 0, 0, r.width, r.height, r.x+10, r.y+60, r.x + r.width-60, r.y + r.height-40, null);

            		
            //File filec = new File(destinatie+"\\screen-capture-cropped.png");
            File filec = new File(destinatie+".png");

            ImageIO.write(dst, "png", filec);
  
 
        } catch ( AWTException | IOException ex) {
            System.err.println(ex);
        }
		
	}

}
