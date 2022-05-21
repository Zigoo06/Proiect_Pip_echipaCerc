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
* Clasa pentru efectuarea unei capturi de fereastra
* 
*/
public class ScreenShot implements ActionListener {
	public JFrame frame;
	/**
	 * 
	 * @param frame1 fereastra - GUI - pentru care se doreste efectuarea unei capturi
	 */
	public ScreenShot(JFrame frame1){
		frame=frame1;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/**
			 * alegerea locatiei de catre utilizator in care va fi salvata captura
			 * file1 va contine locatia 
			 */
			JFileChooser file1 = new JFileChooser();
		      file1.setMultiSelectionEnabled(true);
		      file1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		      file1.setFileHidingEnabled(false);
		      if (file1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		         File f = file1.getSelectedFile();
		         System.out.println(f.getPath());
		      }
		      
		      /**
		       * destinatie va fi path ul ales convertit la string
		       */
		    String destinatie = file1.getSelectedFile().getPath().toString();
            DisplayMode displayMode = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode();
            Rectangle screenRectangle = new Rectangle(displayMode.getWidth(), displayMode.getHeight());
            BufferedImage screenShot = new Robot().createScreenCapture(screenRectangle);
            
            /**
             * r va contine dimensiunile ferestrei
             */
            Rectangle r = frame.getBounds();
            BufferedImage dst = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_ARGB);
            
            /**
             * dst - ne folosim de un screenshot la tot ecanul, din care decupam in functie de dimensiunilor ferestrei doar continutul ei
             */
            dst.getGraphics().drawImage(screenShot, 0, 0, r.width, r.height, r.x+10, r.y+60, r.x + r.width-60, r.y + r.height-40, null);
            File filec = new File(destinatie+".png");
            ImageIO.write(dst, "png", filec);
 
        } catch ( AWTException | IOException ex) {
            System.err.println(ex);
        }
		
	}

}
