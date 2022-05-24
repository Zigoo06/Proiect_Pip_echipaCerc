package pip_pr_test;

import static org.junit.Assert.*;

import org.junit.Test;

import pip_pr.Culoare;
import pip_pr.Harta;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;

public class CuloareTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testCuloare() {
		int z=1;
	       try{
	    	   Harta map=new Harta(null);
		   
	       double intensitate=0;
	       
	       Circle cerc = new Circle(map.getMap());
		   Culoare cul= new Culoare(cerc,z,intensitate);
		   
		   Circle cercdorit=new Circle(map.getMap());
		   
		   CircleOptions co = new CircleOptions();
		   co.setFillColor("#cce3f7");
		   co.setFillOpacity(0.20);
		   cercdorit.setOptions(co);
		   
		   assertNotNull(cerc);
		   assertNotNull(cul);
		   assertEquals(co.getFillColor(), cul.co.getFillColor());
		   assertEquals(co.getFillOpacity(), cul.co.getFillOpacity());
		   
		   }catch(Exception e){
	    	   
	       }
	}

}
