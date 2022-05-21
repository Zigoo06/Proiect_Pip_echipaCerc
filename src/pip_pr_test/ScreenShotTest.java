package pip_pr_test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pip_pr.ScreenShot;
/**
 * 
 * @author Daniel
 *
 */
public class ScreenShotTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScreenShot() {
		JFrame frame = null;
		assertEquals((new ScreenShot(frame)).frame,null);
	}

	@Test
	public void testActionPerformed() throws IOException {
		String destinatie ="D:\\";
		@SuppressWarnings("unused")
		BufferedImage screenShot = null;
		DisplayMode displayMode = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode();
        Rectangle screenRectangle = new Rectangle(displayMode.getWidth(), displayMode.getHeight());
		
		try {
			screenShot = new Robot().createScreenCapture(screenRectangle);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage dst = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		File filec = new File(destinatie+".png");
		ImageIO.write(dst, "png", filec);
			
		assertNotNull(ImageIO.write(dst, "png", filec));
		assertNotNull(filec.getAbsolutePath());
		assertEquals("D:\\.png", filec.getAbsolutePath().toString());
       
	}

}
