package pip_pr;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
/**
 * 
 * @author Cati

 */
public class Culoare {
	public int zona=0;
	Circle cerc;
	/**
	 *   Constructorul primeste fiecare cerc creat si in functie de zona stabilita
	 * 	acesta va schimba culoarea si opacitatea
	 *
	 * @param c  -cerccul primit
	 * @param zon -zona ceruta
	 */
	Culoare(Circle c,int zon){
		cerc=c;
		zona=zon;
		CircleOptions co = new CircleOptions();
		if(zona==1){
			co.setFillColor("#14ef3a");
			co.setFillOpacity(0.75);
		}
		else if(zona==2){
			co.setFillColor("#1aab7a");
			co.setFillOpacity(0.30);
		}
		cerc.setOptions(co);
	}
	
}
