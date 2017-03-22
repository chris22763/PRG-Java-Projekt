

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class GUI_WorkedOnce extends JFrame {

    private JMenuBar menuBar = new JMenuBar();  //panel für menu
    private JMenu fileMenu = new JMenu("File"); //file menupunkt
    private JMenuItem openMenuItem = new JMenuItem("Open"); //menupunkt
    private JMenuItem saveMenuItem = new JMenuItem("Save");

    private JPanel mainPanel = new JPanel();
    private JPanel naviPanel = new JPanel(); // paint navigationspanel
    private JPanel colorPanel = new JPanel(); // panel für Farbauswahl

    private JButton colorChooserButton = new JButton("Choose Color"); //Farbwahl Button
    private JButton filterChooserButton = new JButton("Choose Filter"); //Filterauswahl Button

    int xFrom,yFrom;
    int xTo,yTo;
    private int pinsel_init = 1;
    private int pinsel_min = 1;
    private int pinsel_max = 100;
    private int BI_heigth = 600;
    private int BI_width = 800;
    private Color farbe; 
    private JSlider pinselSlider;
    private JTextArea tPinsel;
    private Graphics g = null;
    private Graphics2D g2D = null;
    private BufferedImage image = new BufferedImage(BI_width, BI_heigth, BufferedImage.TYPE_INT_RGB);
    private int border = 100;
    //private draw mainPanel = new draw();


    public static void main(String[] args) {
        GUI_WorkedOnce frame = new GUI_WorkedOnce("Painto");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Schließen
    }

    public GUI_WorkedOnce(String title) {
        super(title);
        
        
        
        //menu Init
        add(menuBar, BorderLayout.NORTH);   //Menubar Oben
        menuBar.add(fileMenu);              //File Menu in MenuBar integriert
        fileMenu.add(openMenuItem);         //Open und Save in FileMenu integriert
        fileMenu.add(saveMenuItem);


        add(mainPanel);                                             //MainPanel hinzugefügt, dient als Zeichenfläche/Bildfläche
        
       // mainPanel.add(image);
        MouseMotion mm = new MouseMotion();                         // initialisiert MouseMotion
        
        mainPanel.addMouseListener(mm);                             // fügt ML & MML hinzu
        mainPanel.addMouseMotionListener(mm);
        


        add(naviPanel, BorderLayout.WEST);                          // NaviPanel hinzugefügt, dient als Naviagationsleiste, links angeordnet
        naviPanel.add(colorChooserButton, BorderLayout.NORTH);      // ColorchooserButton in NaviPanel integriert, Farbauswahl
   
        


        colorChooserButton.addActionListener( new ActionListener() {        // Farbauswahl Treffen
            public void actionPerformed(ActionEvent event) {
                farbe = JColorChooser.showDialog(colorPanel, "Choose a color", Color.blue); // mit "color" weiter benutzen
            }


        });
        
        pinselSlider = new JSlider(pinsel_min, pinsel_max, pinsel_init);
        pinselSlider.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				tPinsel.setText(String.valueOf(pinselSlider.getValue()));
				
			}
		});
        
        
        
        
        naviPanel.add(filterChooserButton, BorderLayout.NORTH); // FilterChooserButton in NaviPanel integriert, Filterauswahl
       
        tPinsel = new JTextArea(String.valueOf(pinselSlider.getValue()));
        pinselSlider.setPreferredSize(new Dimension(100, 20));
        naviPanel.add(pinselSlider, BorderLayout.NORTH);
        naviPanel.add(tPinsel);
        
        
        naviPanel.setPreferredSize(new Dimension(BI_width/4, BI_heigth)); // Größe der Navigation


        mainPanel.setPreferredSize(new Dimension(BI_width,BI_heigth)); // Größe der Zeichenfläche eingestellt
        mainPanel.setBackground(Color.WHITE);                   // Hintergrundfarbe für Zeichenfläche
        setVisible(true);
        pack();                                                 // Setzt das Fenster dass alle Komponenten angepasst sichtbar sind.


    }
    
    
    /*public class draw extends JPanel{
        private int xFrom,yFrom,xTo,yTo;

            public void drawing(int xFirst, int yFirst, int xSecond, int ySecond){
                xFrom = xFirst;
                yFrom = yFirst;
                xTo = xSecond;
                yTo = ySecond;
                System.out.println("test");
                repaint();
            }
            
            public void paintComponent(Graphics g){
                super.paintComponents(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setColor(farbe);
                g2D.setStroke(new BasicStroke(pinselSlider.getValue()));
                g.drawLine(xFrom, yFrom, xTo, yTo);
                System.out.print("-------");
            }
        	

    }*/
    //MouseMotion Class implementiert ML und MML, es ist notwendig das alle Funktionen aufgeschrieben werden,
    //sonnst funktioniert es nicht. Aber daran arbeite ich es gibt nähmlich noch MouseAdapter, aber das hat grad nicht funktioniert
    public class MouseMotion /*extends JFrame*/ implements MouseListener, MouseMotionListener{

  
    	
    	
    	
    	
        public void mouseDragged(MouseEvent event) {
        	
        	Graphics g = getGraphics();
        	Graphics2D g2D = (Graphics2D) g;
            //(Graphics2D g2D = image.createGraphics();
            g2D.setColor(farbe);
            g2D.setStroke(new BasicStroke(pinselSlider.getValue()));
            if ((xFrom >= border)&&(yFrom >= border)){
            	g2D.drawLine(xFrom+BI_width/4, yFrom+40, event.getX()+BI_width/4, event.getY()+40);
            }
            
        	
            //mainPanel.drawing(xFrom,yFrom,event.getX(),event.getY());
            xFrom = event.getX();
            yFrom = event.getY();
            

            
        }
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
        @Override
        public void mousePressed(MouseEvent event){                 //hier passiert das selbe wie in mouseDragged
           xFrom = event.getX();
           yFrom = event.getY();
        }
    }
}
    
    
    
    
    

