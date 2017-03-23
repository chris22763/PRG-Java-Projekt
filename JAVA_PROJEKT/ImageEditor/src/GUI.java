

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;






public class GUI extends JFrame {

    private JMenuBar menuBar = new JMenuBar();  //panel für menu
    private JMenu fileMenu = new JMenu("File"); //file menupunkt
    private JMenuItem openMenuItem = new JMenuItem("Open"); //menupunkt
    private JMenuItem saveMenuItem = new JMenuItem("Save");

    private JPanel mainPanel = new JPanel();
    private JPanel naviPanel = new JPanel(); // paint navigationspanel
    private JPanel colorPanel = new JPanel(); // panel für Farbauswahl

    private JButton colorChooserButton = new JButton("Choose Color"); //Farbwahl Button
    private JButton filterChooserButton = new JButton("Choose Filter"); //Filterauswahl Button
    private JFileChooser fileChooser = new JFileChooser(); // Filechooser
    private JFileChooser saveChooser = new JFileChooser(); // Savechooser

    private int xFrom,yFrom;                    // X & Y Koordinaten für z.B. g.drawline(von x1,y1, nach x2,y2)
    private int xTo,yTo;                        // X & Y Koordinaten 
    private int pinsel_init = 1;                //pinsel _init/_min/_max sind für den slider wichtig.           
    private int pinsel_min = 1;                 
    private int pinsel_max = 20;                //Max Pinsel Größe empfehlung : nicht mehr als 20
    private int BI_heigth = 600;                //Globale Variablen für Höhe und breite vom MainPanel
    private int BI_width = 800;                 //und Bufferedimage, damit diese auch gleich groß sind
    private Color farbe;                        //Zum Globalen speichern der farbe vom JColorChooser
    private JSlider pinselSlider;       
    private JTextArea tPinsel;                  //Ausgabe der Pinsel größe
    private Graphics g = null;                  //initialisierung von Graphics, für "getGraphics()"
    private Graphics2D g2D = null;              //initialisierung von Graphics2D für "setStroke()" 
    private BufferedImage image = new BufferedImage(BI_width, BI_heigth, BufferedImage.TYPE_INT_RGB);
    private int border = 100;                   //Rand zum malen um nicht die UI voll zu kritzeln.
    //private draw mainPanel = new draw();


    public static void main(String[] args) {
        GUI frame = new GUI("Painto");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Schließen
    }

    public GUI(String title) {
        super(title);
        
        
        
      //menu Init
        add(menuBar, BorderLayout.NORTH);   //Menubar Oben
        menuBar.add(fileMenu);              //File Menu in MenuBar integriert
        fileMenu.add(openMenuItem);         //Open und Save in FileMenu integriert
        fileMenu.add(saveMenuItem);


        add(mainPanel);                                             // MainPanel hinzugefügt, dient als Zeichenfläche/Bildfläche
        
       // mainPanel.add(image);
        MouseMotion mm = new MouseMotion();                         // initialisiert MouseMotion
        mainPanel.addMouseListener(mm);                             // fügt ML & MML hinzu
        mainPanel.addMouseMotionListener(mm);
        


        add(naviPanel, BorderLayout.WEST);                          // NaviPanel hinzugefügt, dient als Naviagationsleiste, links angeordnet
        naviPanel.add(colorChooserButton, BorderLayout.NORTH);      // ColorchooserButton in NaviPanel integriert, Farbauswahl
   
        


        colorChooserButton.addActionListener( new ActionListener() {            // Farbauswahl Treffen
            public void actionPerformed(ActionEvent event) {
                farbe = JColorChooser.showDialog(colorPanel, "Choose a color", Color.blue); // mit "color" weiter benutzen
            }


        });
        
        openMenuItem.addActionListener( new ActionListener() {        //Datei Öffnen
            public void actionPerformed(ActionEvent event) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Filechooser startet im home-Verzeichnis des Users
                int result = fileChooser.showOpenDialog(openMenuItem);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = saveChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    setVisible(true);
                }
            }


        });
        
        pinselSlider = new JSlider(pinsel_min, pinsel_max, pinsel_init);    // Initialisierung des sliders und das hinzufügen
        pinselSlider.addChangeListener(new ChangeListener() {               // des ChangeListeners um tPisnel bei veränderungen
                                        // direkt zu übernehmen.
            public void stateChanged(ChangeEvent e) {
                tPinsel.setText(String.valueOf(pinselSlider.getValue()));
                
            }
        });
        
        
        saveMenuItem.addActionListener( new ActionListener() {        //Datei Speichern
            public void actionPerformed(ActionEvent event) {
                saveChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Filechooser sucht speicherort im home-Verzeichnis des Users
                int result = saveChooser.showOpenDialog(saveMenuItem);
                JFileChooser saveChooser = new JFileChooser();
                if (saveChooser.showSaveDialog(saveMenuItem) == JFileChooser.APPROVE_OPTION) {
                    File save = saveChooser.getSelectedFile();
                    // save to file
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
            }
        });
 
        naviPanel.add(filterChooserButton, BorderLayout.NORTH); // FilterChooserButton in NaviPanel integriert, Filterauswahl
      



       
        tPinsel = new JTextArea(String.valueOf(pinselSlider.getValue()));
        pinselSlider.setPreferredSize(new Dimension(100, 20));
        naviPanel.add(pinselSlider, BorderLayout.NORTH);
        naviPanel.add(tPinsel);
        
        
        naviPanel.setPreferredSize(new Dimension(150, BI_heigth)); // Größe der Navigation


        mainPanel.setPreferredSize(new Dimension(BI_width,BI_heigth)); // Größe der Zeichenfläche eingestellt
        mainPanel.setBackground(Color.WHITE);                   // Hintergrundfarbe für Zeichenfläche
        setVisible(true);
        pack();                                                 // Setzt das Fenster dass alle Komponenten angepasst sichtbar sind.


    }
 
    
    
    
    
    //MouseMotion Class implementiert ML und MML, es ist notwendig das alle Funktionen aufgeschrieben werden,
    //sonnst funktioniert es nicht. Aber daran arbeite ich es gibt nähmlich noch MouseAdapter, aber das hat grad nicht funktioniert
    public class MouseMotion extends MouseAdapter{
        
        public void mouseDragged(MouseEvent event) {
            
            int offsetX = 149;
            int offsetY = 41;
            
            Graphics g = getGraphics();
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(farbe);
            g2D.setStroke(new BasicStroke(pinselSlider.getValue()));
            
            
            xFrom = xFrom+offsetX;
            yFrom = yFrom+offsetY;
            xTo = event.getX()+offsetX;
            yTo = event.getY()+offsetY;
            
            if ((xFrom >= border)&&(yFrom >= border)){ 			//Stellt sicher das man das UI nicht voll malt 
                if ((pinselSlider.getValue())<=10){				// Ab der Pinselstärke 10 werden nur noch kreise anstatt
                    g2D.drawLine(xFrom, yFrom, xTo, yTo);		// Rechteckigen linien gemalt.
                }else {
                    g2D.drawOval(xTo, yTo, pinselSlider.getValue(), pinselSlider.getValue());
                }
            }
            
            xFrom = event.getX();
            yFrom = event.getY();

            g2D.dispose();
        }
    
        public void mousePressed(MouseEvent event){                 //hier passiert das selbe wie in mouseDragged
           xFrom = event.getX();
           yFrom = event.getY();
        }
        public void mouseReleased(MouseEvent event){
        }
    }
}
    
