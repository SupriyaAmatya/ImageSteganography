package imagesteganography;

import javax.swing.*;
import java.awt.*;

public class ImageSteganography{
    JFrame frame;
    Image icon;
    static JLayeredPane layeredPane;
    HomePanel homePanel;
    EncryptionPanel encryptionPanel;
    DecryptionPanel decryptionPanel;
    JDialog d; JTextArea textArea; JButton b;
    ImageSteganography(){
        frame = new JFrame("Image Steganography");
        ImageIcon ImageIcon = new ImageIcon("src\\icon.jpeg");
        frame.setIconImage(ImageIcon.getImage());
        layeredPane = new JLayeredPane();
        homePanel = new HomePanel();
        encryptionPanel = new EncryptionPanel();
        decryptionPanel = new DecryptionPanel();
        
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        layeredPane.setSize(910,710);
        frame.add(layeredPane);
        layeredPane.setLayout(new CardLayout());
        frame.setVisible(true);
        layeredPane.add(homePanel);
        layeredPane.add(encryptionPanel);
        layeredPane.add(decryptionPanel);
        layeredPane.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
    }    
        
    public static void main(String [] args){
        ImageSteganography imageSteganography = new ImageSteganography();
    }
}