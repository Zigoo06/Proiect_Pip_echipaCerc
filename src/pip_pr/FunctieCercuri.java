package pip_pr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;

 /**
  * 
  *  Clasa pentru crearea zonelor
  * @author Otilia si Larisa
  *
  */
public class FunctieCercuri 
{
  /**
   * Larisa- Functia creeaza cercuri pe baza coordonatelo primite
   *  Otilia- citirea  dintr-un  fisier  csv  a coordonatelor 
   *  si a intensitatilor  in functie  de  semnalul  ales  5G/4G
   * @param map
   * @throws IOException
   */
   public void FctCercuri(Map map,int zona) throws IOException 
   {     
	   int z=zona;
	   float lat;
       float lang;
       double intensitate=0;
	   try{ /*
	   
	   *pe baza functiei create de Larisa am  facut citirea coordonatelor din fisier
	   *
	   *in  primul rand  am indicat sursa fisier 
	   * 
	   */
		   File file=new File("src\\processed_at_ac-depou.csv");
		   String line="";
		   /*
		    * citirea  se  face linie cu linie 
		    * 
		    * astfel  la  intalnirea caracterului  ","  pe  prima pozitie [0]  va  fi  lotitudinea  iar  pe  pozitia [2]  longitudinea
		    *  punctele cardinale nelundu-le in considerare 
		    * 
		    * */
		   BufferedReader br=new BufferedReader(new FileReader(file));
		   while((line=br.readLine())!=null)
		   {
			   line=br.readLine();
			   String[] values=line.split(",");
		   
			   lat=Float.parseFloat(values[0]);
			   lang=Float.parseFloat(values[2]);
			   Circle cerc = new Circle(map);
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
			
		   }
		   br.close();
	   }
	   catch(IOException e){
		   System.out.println("Sfarsit flux");
	   } 
	   
   }
}
 



