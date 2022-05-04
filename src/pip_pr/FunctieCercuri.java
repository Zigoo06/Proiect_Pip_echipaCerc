package pip_pr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.swing.MapView;
 
/**
 *  Creare functie cercuri
 *  
 * @author larie
 *
 */
public class FunctieCercuri 
{
	/**
	 * Larisa- Creare cercuri cu LatLng
	 * @param map
	 */
 
   public void FctCercuri(Map map) 
   {
	  float lat=(float) 47.154063;
      float lng=(float) 27.594217 ;

   
   while(true)
   { 
   
	Circle cerc = new Circle(map);
	cerc.setCenter(new LatLng(lat, lng));
	cerc.setRadius(120.0);

	CircleOptions co = new CircleOptions();
	co.setFillColor("#2e7778");
	co.setFillOpacity(0.50);
     
	cerc.setOptions(co);
	
   
  } 
  }


  
}
