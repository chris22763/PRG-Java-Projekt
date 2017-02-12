package bildbearbeitung01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public interface button1 {

	static void addActionListener(ActionListener actionListener) {
		public actionPerformed(ActionEvent event);
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
	}
}
