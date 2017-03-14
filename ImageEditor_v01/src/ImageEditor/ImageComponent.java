package ImageEditor;


import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class ImageComponent extends JComponent
{
    private static final long serialVersionUID = 8055865896136562197L;

    private BufferedImage image;

    public void setImage( BufferedImage image )
    {
        this.image = image;
        setPreferredSize( new Dimension(image.getWidth(), image.getHeight()) );
        repaint();
        invalidate();
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        if ( image != null )
            g.drawImage( image, 0, 0, this );
    }
}
