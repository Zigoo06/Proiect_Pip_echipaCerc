package pip_pr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Actiunea de selectare a zonei 5G si apelare a functiei de creare cercuri
 * @author Laur
 *	
 */
public class Zona5G implements ActionListener {

	/**
	 * Modifica parametrul zona pentru 5G
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try
        {
			Harta.zona=1;
			Harta.f1.FctCercuri(Harta.map,Harta.zona);
        }
        catch(Exception exception)
        {
           
        }
		
	}

}

