package ImageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Cem on 17.03.17.
 */


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
}