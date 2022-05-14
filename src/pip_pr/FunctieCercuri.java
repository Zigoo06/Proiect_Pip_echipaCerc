package pip_pr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;

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
   public void FctCercuri(Map map,int zona) throws IOException 
   {     
	   int z=zona;
	   float lat;
       float lang;
       double intensitate=0;
	   try{ 
		   File file=new File("src\\processed_at_ac-depou.csv");
		   String line="";
		   BufferedReader br=new BufferedReader(new FileReader(file));
		   while((line=br.readLine())!=null)
		   {
			   line=br.readLine();
			   String[] values=line.split(",");
		   
			   lat=Float.parseFloat(values[0]);
			   lang=Float.parseFloat(values[2]);
			   Circle cerc = new Circle(map);
			   cerc.setCenter(new LatLng(lat,lang));
			   cerc.setRadius(50.0);
			   if(z==1)
			   {
				   intensitate=Double.parseDouble(values[7]);
			   }
			   else if(z==2)
			   {
				   intensitate=Double.parseDouble(values[5]);
				
			   }
			   new Culoare(cerc,z,intensitate);
			
		   }
		   br.close();
	   }
	   catch(IOException e){
		   System.out.println("Sfarsit flux");
	   } 
	   
   }
}
 



