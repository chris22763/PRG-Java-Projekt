package ImageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*


public class GUI extends JFrame {

    private JMenuBar menuBar = new JMenuBar();  //panel für menu
    private JMenu fileMenu = new JMenu("File"); //file menupunkt
    private JMenuItem openMenuItem = new JMenuItem("Open"); //menupunkt
    private JMenuItem saveMenuItem = new JMenuItem("Save");

    private JPanel mainPanel = new JPanel(); // panel für das bild
    private JPanel naviPanel = new JPanel(); // paint navigationspanel
    private JPanel colorPanel = new JPanel(); // panel für Farbauswahl

    private JButton colorChooserButton = new JButton("Choose Color"); //Farbwahl Button
    private JButton filterChooserButton = new JButton("Choose Filter"); //Filterauswahl Button
    
    private double x,y; 			// Koordinaten sind immer Double ...



    public GUI(String title) {
        super(title);

        //menu Init
        add(menuBar, BorderLayout.NORTH);   //Menubar Oben
        menuBar.add(fileMenu);              //File Menu in MenuBar integriert
        fileMenu.add(openMenuItem);         //Open und Save in FileMenu integriert
        fileMenu.add(saveMenuItem);


        add(mainPanel);                                             //MainPanel hinzugefügt, dient als Zeichenfläche/Bildfläche

        add(naviPanel, BorderLayout.WEST);                          // NaviPanel hinzugefügt, dient als Naviagationsleiste, links angeordnet
        naviPanel.add(colorChooserButton, BorderLayout.NORTH);      // ColorchooserButton in NaviPanel integriert, Farbauswahl



        colorChooserButton.addActionListener( new ActionListener() {        // Farbauswahl Treffen
            public void actionPerformed(ActionEvent event) {
                Color color = JColorChooser.showDialog(colorPanel, "Choose a color", Color.blue); // mit "color" weiter benutzen
            }


        });
        naviPanel.add(filterChooserButton, BorderLayout.NORTH); // FilterChooserButton in NaviPanel integriert, Filterauswahl
        naviPanel.setPreferredSize(new Dimension(150, 600)); // Größe der Navigation


        mainPanel.setPreferredSize(new Dimension(800,600)); // Größe der Zeichenfläche eingestellt
        mainPanel.setBackground(Color.WHITE);                   // Hintergrundfarbe für Zeichenfläche
        setVisible(true);
        pack();                                                 // Setzt das Fenster dass alle Komponenten angepasst sichtbar sind.



    }

    public static void main(String[] args) {
        GUI frame = new GUI("Painto");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Schließen
    }


    
    // MouseMotion Class implementiert ML und MML, es ist notwendig das alle Funktionen aufgeschrieben werden, 
    //sonnst funktioniert es nicht. Aber daran arbeite ich es gibt nähmlich noch MouseAdapter, aber das hat grad nicht funktioniert 
    
    public class MouseMotion implements MouseListener, MouseMotionListener{
        
       
		@Override
		public void mouseDragged(MouseEvent e) {
			x = e.getX();											// bekommt e von der Methode und gibt X aus
            y = e.getY();											// bekommt e von der Methode und gibt X aus
            System.out.println("Dragged  : " + x + " , " + y);		// schreibt den wert in die Konsole
		}

		@Override
		public void mouseMoved(MouseEvent e){
            
        }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e){                 //hier passiert das selbe wie in mouseDragged
            x = e.getX();                                       //nur halt beim kurzen drücken.
            y = e.getY();
            System.out.println("Pressed  : " + x + " , " + y);
        }

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
        
    }
}
