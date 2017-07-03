package team.nwt.warestics.QRCode;

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
        BufferedImage image = QRCode.encodeQRcode("123123", 300, 300);  
        jframe.add(new ImagePanel(image));  
        jframe.setSize(500, 500);  
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jframe.setVisible(true);
        System.out.print(QRCode.decodeQRcode("D:\\test.jpg"));
    }  
}  
  