package pip_pr;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;



@SuppressWarnings("serial")
public class Harta extends MapView{
	
	static Map map;
	public static int zona=1;
	static FunctieCercuri f1=new FunctieCercuri();
	
	public Harta(String nName){
  	/**
	 *
	 * @Author Daniel
	 * 
	 */
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
				if(status == MapStatus.MAP_STATUS_OK)
				{
					map = getMap();
					MapOptions mapOptions = new MapOptions();
					MapTypeControlOptions mapControl = new MapTypeControlOptions();
					
					mapOptions.setMapTypeControlOptions(mapControl);
					map.setOptions(mapOptions);
					map.setCenter(new LatLng(47.154279,27.594155));
					map.setZoom(15.2);

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

}