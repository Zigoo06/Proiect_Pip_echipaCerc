package pip_pr;
import java.awt.BorderLayout;
import java.awt.AWTException;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;



@SuppressWarnings("serial")
public class Harta extends MapView{
	
	private Map map;
	public int zona=1;
	/*
	int zona=0;
	
	public void setColor(Circle c){
		CircleOptions co1 = new CircleOptions();
		if(zona==1){
		co1.setFillColor("#9a0000");
		co1.setFillOpacity(0.50);
		}
		else if(zona==2){
				co1.setFillColor("#1aab7a");
				co1.setFillOpacity(0.30);
			}
		c.setOptions(co1);
		

	}*/
	
	
	public Harta(String nName){
  	/**
	 *
	 * @Author Daniel
	 * @param c
	 */
		JFrame frame= new JFrame(nName);
		JMenu meniu1;
		JMenuBar mb1 = new JMenuBar();
	    meniu1 = new JMenu("Screen");
	    
	    mb1.add(meniu1);
	    frame.setJMenuBar(mb1);

        JMenuItem screenshot =new JMenuItem("Screenshot");

        meniu1.add(screenshot);
        screenshot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)  {
				
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
		            
		            Rectangle r = frame.getBounds( );

		            BufferedImage dst = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_ARGB);
		            dst.getGraphics().drawImage(screenShot, 0, 0, r.width, r.height, r.x+10, r.y+60, r.x + r.width-60, r.y + r.height-40, null);

		            		
		            //File filec = new File(destinatie+"\\screen-capture-cropped.png");
		            File filec = new File(destinatie+".png");

		            ImageIO.write(dst, "png", filec);
          
		 
		        } catch ( AWTException | IOException ex) {
		            System.err.println(ex);
		        }
			}
		});
		
		setOnMapReadyHandler(new MapReadyHandler() {
			
			@Override
			public void onMapReady(MapStatus status) {
				if(status == MapStatus.MAP_STATUS_OK)
				{
					map = getMap();
					
					MapOptions mapOptions = new MapOptions();
					MapTypeControlOptions mapControl = new MapTypeControlOptions();
					/*
					 * Am setat centrul hartii cu LatLng() unde introducem coordonatele 
					 */
					mapOptions.setMapTypeControlOptions(mapControl);
					map.setOptions(mapOptions);
					map.setCenter(new LatLng(47.154279,27.594155));
					map.setZoom(15.2);
					
					/***
					 * Am creat 3 markere pentru exemplu
					 * Acestora le-am dat coordonatele astfel mk1 a folosit getCenter() de mai sus
					 * Iar pentru celelalte am folosit LatLng()
					 */
					
					Marker mark1 = new Marker(map);
					mark1.setPosition(map.getCenter());
					Marker mark2 = new Marker(map);
					mark2.setPosition(new LatLng(47.156323, 27.587552));
					//Marker mark3 = new Marker(map);
					//mark3.setPosition(new LatLng(47.156910, 27.604047));
					
					/*
					 * Cate 1 cerc pentru fiecare marcaj si am folosit getPosition pentru a
					 * seta centrul cercului, urmat de raza sa
					 * Pt cerc3 am folosit new LatLng in loc de getPosition si recomand pt functii
					 */
					
					Circle cerc1 = new Circle(map);
					cerc1.setCenter(mark1.getPosition());
					cerc1.setRadius(50.0);
					/*
					Circle cerc2 = new Circle(map);
					cerc2.setCenter(mark2.getPosition());
					cerc2.setRadius(100.0);
					Circle cerc3 = new Circle(map);
					cerc3.setCenter(new LatLng(47.156910, 27.604047));
					cerc3.setRadius(70.0);
				
					/*
					 * Setarile pentru fiecare cerc folosind CircleOption()
					 * si am atribuit fiecarui cerc cate un co(CircleOption)
					 * 
					 */
					
					
					/*CircleOptions co1 = new CircleOptions();
					co1.setFillColor("#2e7778");
					co1.setFillOpacity(0.50);
					CircleOptions co2 = new CircleOptions();
					co2.setFillColor("#12eaea");
					co2.setFillOpacity(0.30);
					CircleOptions co3 = new CircleOptions();
					co3.setFillColor("#ec1313");
					co3.setFillOpacity(0.35);
					
		
					*/
					
					//cerc1.setOptions(co1);
					//cerc2.setOptions(co2);
					//cerc3.setOptions(co3);
					
					FunctieCercuri f1=new FunctieCercuri();
					
					try {
						f1.FctCercuri(map,zona);
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*
					cerc2.setOptions(co2);
					cerc3.setOptions(co3);
					
					setColor(cerc1);
					setColor(cerc2);
					setColor(cerc3);
					
					FunctieCercuri f1=new FunctieCercuri();
					f1.FctCercuri(map);*/
				
				}
			}
		});
		/*
		 * Creare frame, dimensiuni si vizibilitate
		 */
		frame.add(this,BorderLayout.CENTER);
		frame.setSize(900,700);
		frame.setVisible(true);
		
		
	}
	/***
	 * Initializare Harta
	 * @param args
	 */
	
	
	public static void main(String[] args)
	{
		new Harta("In fata facultatii");
		
	}
}