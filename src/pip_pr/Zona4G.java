package pip_pr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Laur
 *	Actiunea de selectare a zonei 4G
 */
public class Zona4G implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
        {
			Harta.zona=2;
			Harta.f1.FctCercuri(Harta.map,Harta.zona);
        }
        catch(Exception exception)
        {
           
        }
	}
}
