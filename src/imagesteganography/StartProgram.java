package imagesteganography;

import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class StartProgram{
    JFrame frame;
    Image icon;
    static JLayeredPane layeredPane;
    HomePanel homePanel;
    EncryptionPanel encryptionPanel;
    DecryptionPanel decryptionPanel;
    JDialog d; JTextArea textArea; JButton b;
    
    StartProgram(){
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
}
        
