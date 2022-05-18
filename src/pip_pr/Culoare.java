package pip_pr;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
/**
 * Clasa coloreaza fiecare cerc creat in functie de zona stabilita
 * 
 * @author Ecaterina

 */
public class Culoare {
	public int zona=0;
	double intens;
	Circle cerc;
	/**
	 *   Constructorul primeste fiecare cerc creat si in functie de zona stabilita
	 * 	acesta va schimba culoarea si opacitatea
	 *
	 * @param c  Cercul primit
	 * @param zon Zona ceruta
	 */
	Culoare(Circle c,int zon,double intensitate){
		cerc=c;
		zona=zon;
		intens=intensitate;
		CircleOptions co = new CircleOptions();
		if(zona==1){
			if(intens>30){
				co.setFillColor("#064074");
				co.setFillOpacity(0.85);
				}
			else if(intens>20 && intens<30){
				co.setFillColor("#7db0dd");
				co.setFillOpacity(0.50);
			}
			else if(intens>10 && intens<20){
				co.setFillColor("#619cd2");
				co.setFillOpacity(0.50);
			}
			
			else{
				co.setFillColor("#cce3f7");
				co.setFillOpacity(0.20);
			}
		}
		else if(zona==2){
			

			if(intens>20){
				co.setFillColor("#7e0707");
				co.setFillOpacity(0.85);
				}
			else if(intens>10 && intens<20){
				co.setFillColor("#ec9f4e");
				co.setFillOpacity(0.60);
			}
			else{
				co.setFillColor("#f1c232");
				co.setFillOpacity(0.30);
			}
		}
		cerc.setOptions(co);
	}
	
}
