package pip_pr_test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;

import pip_pr.Culoare;
import pip_pr.FunctieCercuri;
import pip_pr.Harta;
import pip_pr.ScreenShot;

public class FunctieCercuriTest {

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

	
	@SuppressWarnings("deprecation")
	@Test


	public void FunctieCercuriTest() throws IOException 
	{
		   int z=1;
		   float lat;
	       float lang;
		  
	       
	       try{
	    	   Harta map=new Harta(null);
		   
	       double intensitate=0;
	       
		   String line="47.15453357,N,27.59607237,E,185,12,105,2.5";
		   String[] values=line.split(",");
		   lat=Float.parseFloat(values[0]);
		   lang=Float.parseFloat(values[2]);
		   Circle cerc = new Circle(new Harta(null).getMap());
		   cerc.setCenter(new LatLng(lat,lang));
		   cerc.setRadius(30.0);
		   if(z==1)
		   {
			   intensitate=Double.parseDouble(values[7]);
		   }
		   else if(z==2)
		   {
			   intensitate=Double.parseDouble(values[5]);
			
		   }
		   new Culoare(cerc,z,intensitate);
		   
		   
		   Circle cercdorit=new Circle(map.getMap());
		   cercdorit.setCenter(new LatLng(47.15453357,27.59607237));
		   cercdorit.setRadius(30.0);
		   new Culoare(cercdorit,1,2.5);
		   
		   assertEquals(cercdorit, cerc);
		   
		   }catch(Exception e){
	    	   
	       }
		   
	}
	
	


	

}
