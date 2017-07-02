package team.nwt.warestics;

import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
import javax.imageio.ImageIO;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import team.nwt.warestics.rms.*;
public class QRCodeTest {  
    public static void main(String[] args) throws IOException {  
        JFrame jframe = new JFrame();  
        jframe.add(new ImagePanel());  
        jframe.setSize(500, 500);  
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jframe.setVisible(true);
        System.out.print(QRCode.decodeQRcode("D:\\test.jpg"));
    }  
}  
  
class ImagePanel extends JPanel {  
  
    private BufferedImage image;  
  
    public ImagePanel() throws IOException {  
        image = QRCode.encodeQRcode("徐一泓我爱你", 400, 400);  
    }  
  
    @Override  
    public void paintComponent(Graphics g) {  
        g.drawImage(image, 0, 0, null);   
    }  
  
}  