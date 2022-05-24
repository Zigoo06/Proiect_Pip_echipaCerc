package pip_pr_test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.LatLng;
import pip_pr.Harta;

public class FunctieCercuriTest {

	@Test
	public void testFctCercuri() throws IOException 
	{
		float lat;
	       float lang;
	       try{
	    	   Harta map=new Harta(null);
	    	   
		   String line="47.15453357,N,27.59607237,E,185,12,105,2.5";
		   String[] values=line.split(",");
		   lat=Float.parseFloat(values[0]);
		   lang=Float.parseFloat(values[2]);
		   
		   Circle cerc = new Circle(map.getMap());
		   cerc.setCenter(new LatLng(lat,lang));
		   cerc.setRadius(30.0);
		   
		   Circle cercdorit=new Circle(map.getMap());
		   cercdorit.setCenter(new LatLng(47.15453357,27.59607237));
		   cercdorit.setRadius(30.0);
		   
		   assertNotNull(cerc);
		   assertEquals(cercdorit,cerc);
		   assertEquals(cercdorit.getBounds(), cerc.getBounds());
		   
		   }catch(Exception e){ }	   
	}
	
}
