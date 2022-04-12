package pip_pr;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;


public class Harta extends MapView{
	
	private Map map;
	
	public Harta(String nName){
		
		JFrame frame= new JFrame(nName);
		
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
					cerc1.setRadius(100.0);
					Circle cerc2 = new Circle(map);
					cerc2.setCenter(mark2.getPosition());
					cerc2.setRadius(500.0);
					Circle cerc3 = new Circle(map);
					cerc3.setCenter(new LatLng(47.156910, 27.604047));
					cerc3.setRadius(300.0);
					/*
					 * Setarile pentru fiecare cerc folosind CircleOption()
					 * si am atribuit fiecarui cerc cate un co(CircleOption)
					 * 
					 */
					
					
					CircleOptions co1 = new CircleOptions();
					co1.setFillColor("#2e7778");
					co1.setFillOpacity(0.50);
					CircleOptions co2 = new CircleOptions();
					co2.setFillColor("#12eaea");
					co2.setFillOpacity(0.30);
					CircleOptions co3 = new CircleOptions();
					co3.setFillColor("#ec1313");
					co3.setFillOpacity(0.35);
					
					
					cerc1.setOptions(co1);
					cerc2.setOptions(co2);
					cerc3.setOptions(co3);
					
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
	
	public static void main(String[] args){
		Harta mapa = new Harta("In fata facultatii");
	}
}