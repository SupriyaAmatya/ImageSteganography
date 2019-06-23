package client;

import javax.swing.JFrame;
import server.Server;

public class EncryptionFrame{
    JFrame frame;
    EncryptionPanel encryptionPanel;
    EncryptionFrame(){
        frame = new JFrame("Encryption");
        encryptionPanel = new EncryptionPanel();
        frame.add(encryptionPanel);
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);        
    }
}
