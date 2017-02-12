package bildbearbeitung01;
 
 import java.awt.Color;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.awt.event.MouseMotionListener;

 import javax.swing.JButton;
 import javax.swing.JFileChooser;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JTextArea;
 
 public class window01 {
 
 	public static void main(String[] args) {
 		// TODO Auto-generated method stub
 		
 		// Window
 		JFrame frame = new JFrame("Bildbearbeitungsprogramm");
 		frame.setSize (450,300);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		JPanel Mousepanel = new JPanel();
 		Mousepanel.setBackground(Color.BLUE);
 		
 		//Button
 		JButton button0 = new JButton("Neue Seite");
 		button0.setSize(300,10); // (geschätzte x,y Koordinaten, funktioniert nicht ?!)
 		
 		JButton button1 = new JButton("Datei Oeffnen");
		button1.setSize(300,10);
		
		
		//Text
 		JTextArea statusbar = new JTextArea("test lorem ipsum");
 		statusbar.setSize(100,20);
 		statusbar.setLocation(0, 280);
 		
 		
 		frame.add(Mousepanel);
 		frame.setVisible(true);
 		Mousepanel.add(button0);
 		Mousepanel.add(button1);
 		Mousepanel.add(statusbar);
 	
 	}
 	
 	public void ButtonEvent1 () {
		button1.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
			}
		});
		
		
 	}
 }