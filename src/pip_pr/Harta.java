package pip_pr;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;


/**
 * Clasa Harta utilizeaza un API pentru a afisa google maps
 * Clasa Harta extinde MapView
 * @author Laur
 *
 */
@SuppressWarnings("serial")
public class Harta extends MapView{
	
	static Map map;
	public static int zona=1;
	static FunctieCercuri f1=new FunctieCercuri();
	/**
	 * Constructorul creeaza un nou frame pentru aplicatie si adauga menu-urile
	 * Menu pentru ScreenShot care foloseste clasa ScreenShot
	 * Menu pentru zone de unde putem selecta afisarea zonei 5G sau 4G
	 *
	 * @Author Daniel
	 * 
	 * @param nName numele Hartii
	 */
	public Harta(String nName){
		JFrame frame= new JFrame(nName);
		JMenu meniu1;
		JMenuBar mb1 = new JMenuBar();
	    meniu1 = new JMenu("Screen");
	    
	    mb1.add(meniu1);
	    frame.setJMenuBar(mb1);

        JMenuItem screenshot =new JMenuItem("Screenshot");

        meniu1.add(screenshot);
        screenshot.addActionListener(new ScreenShot(frame));
        JMenu menu2 = new JMenu("Zone");
        mb1.add(menu2);
        JMenuItem zona5G= new JMenuItem("Zona 5G");
        menu2.add(zona5G);
        JMenuItem zona4G= new JMenuItem("Zona 4G");
        menu2.add(zona4G);
        frame.setJMenuBar(mb1);
        
        zona5G.addActionListener(new Zona5G());
        zona4G.addActionListener(new Zona4G());
        
		setOnMapReadyHandler(new MapReadyHandler() {
			
			@Override
			public void onMapReady(MapStatus status) {
				/**
				 * Setare optiuni si centru pentru Harta
				 *
				 */
				if(status == MapStatus.MAP_STATUS_OK)
				{
					map = getMap();
					MapOptions mapOptions = new MapOptions();
					MapTypeControlOptions mapControl = new MapTypeControlOptions();
					
					mapOptions.setMapTypeControlOptions(mapControl);
					map.setOptions(mapOptions);
					map.setCenter(new LatLng(47.154279,27.594155));
					map.setZoom(15);

				}
			}
		});
		 // Creare frame, dimensiuni si setare vizibilitate
		 
		frame.add(this,BorderLayout.CENTER);
		frame.setSize(900,700);
		frame.setVisible(true);
	}
}