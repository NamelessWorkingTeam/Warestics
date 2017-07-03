package team.nwt.warestics.QRCode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {  
	  
    private BufferedImage image;  
  
    public ImagePanel(BufferedImage image) throws IOException {  
    	this.image = image;
    }  
  
    public void setImage(BufferedImage image){
    	this.image = image;
    	repaint();
    }
    
    @Override  
    public void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, null);   
    }  
  
}  