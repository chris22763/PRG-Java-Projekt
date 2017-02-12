package bildbearbeitung01;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MausManager extends window01 implements MouseListener, MouseMotionListener {

	void coordinates (String eventDescription, MouseEvent event) {
        statusbar.append (eventDescription								// z = "Start" -> z.append("le") = "Startle" , z.insert(4, "le")
        				 + " (" + event.getX() 							//
        				 + "," 	+ event.getY() + ")" + " detected on " 	//
        				 + event.getComponent().getClass().getName());
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		statusbar.setText(String.format ( "Clicked at %a,%d", e.getX(), e.getY()));
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		statusbar.setText ( "Du hast die Maus gedrückt.");
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		statusbar.setText ( "Du hast die maus losgelassen.");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		statusbar.setText ( "Du bist im Fenster");
		mousepanel.setBackground (Color.RED);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		coordinates ("Mouse moved", e);
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		coordinates ("Mouse dragged", e);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		coordinates ("Mouse moved", e);
		
	}
}