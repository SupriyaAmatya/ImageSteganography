package client;

import javax.swing.JFrame;

public class ClientFrame {
    JFrame frame;
    EncryptionPanel encryptionPanel;
    ClientFrame(){
        frame = new JFrame("Encryption");
        encryptionPanel = new EncryptionPanel();
        frame.add(encryptionPanel);
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
