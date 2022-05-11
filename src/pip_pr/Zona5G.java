package pip_pr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Laur
 *	Actiunea de selectare a zonei 5G
 */
public class Zona5G implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
        {
			Harta.zona=1;
        }
        catch(Exception exception)
        {
           
        }
		
	}

}

