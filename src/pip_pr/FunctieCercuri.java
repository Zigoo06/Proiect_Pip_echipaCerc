package pip_pr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.swing.MapView;
 /**
  *  clasa creaza cercuri
  * @author Otilia si Larisa
  *
  */
public class FunctieCercuri 
{
  /**
   * Larisa-creare cercuri
   *  Otilia-crearea lat,lang prin citire din fisier
   * @param map
   * @throws IOException
   */
   public void FctCercuri(Map map) throws IOException 
   {      float lat;
          float lang;
	   try{
		   
	    File file=new File("D:\\eclipse\\PIP-PRR\\Proiect_Pip_echipaCerc\\citireCoord.txt");
	    Scanner scan=new Scanner(file);
	   
	   String fileContent="";
	   while(scan.hasNext()){
		   
		   
		   lat=Float.parseFloat(scan.next());
		   lang=Float.parseFloat(scan.next());
		   Circle cerc = new Circle(map);
			cerc.setCenter(new LatLng(lat,lang));
			cerc.setRadius(50.0);

			CircleOptions co = new CircleOptions();
			co.setFillColor("#2e7778");
			co.setFillOpacity(0.50);
		     
			cerc.setOptions(co);
			fileContent=fileContent.concat(scan.nextLine()+"\n");
	   }
		   scan.close();
	   }
	   catch(IOException e){
		   System.out.println("Sfarsit flux");
	   } 
	   
   }
}
      
