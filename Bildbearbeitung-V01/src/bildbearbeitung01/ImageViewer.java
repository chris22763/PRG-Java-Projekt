import javax.swing.*;

public class ImageViewer
{
  public static void main( String[] args )
  {
    JFrame frame = new JFrame( "Bildbetrachter" );

    ImageComponent imageComponent = new ImageComponent();
    frame.add( new JScrollPane(imageComponent) );
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu( "Datei" );
    JMenu menuFilter = new JMenu ("Filter");
    menu.setMnemonic( 'D' );
    menuFilter.setMnemonic('F');
    menu.add( new JMenuItem( new FileOpenAction(imageComponent) ) );
    menuBar.add( menu );
    frame.setJMenuBar( menuBar );

    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 600, 400 );
    frame.setVisible( true );
  }
}
