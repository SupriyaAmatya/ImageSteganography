package client;

import imagesteganography.*;
import static imagesteganography.MethodsUsed.hideKey;
import static imagesteganography.MethodsUsed.switchPanels;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DecryptionPanel extends javax.swing.JPanel {
    static JFileChooser imageChooser, saveFileChooser;
    static String key;
    BufferedImage image;

    public DecryptionPanel(BufferedImage img) {
        image = img;
        initComponents();
        stegoImageLabel = new JLabel(new ImageIcon(img));
        stegoImagePane.getViewport().add(stegoImageLabel);
        stegoImagePane.setVisible(true);
        messagePane.setVisible(false);
        saveFileButton.setVisible(false);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coverImageButton = new javax.swing.JButton();
        keyButton = new javax.swing.JButton();
        keyField = new javax.swing.JTextField();
        imageTextField = new javax.swing.JTextField();
        stegoImagePane = new javax.swing.JScrollPane();
        stegoImageLabel = new javax.swing.JLabel();
        messagePane = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        saveFileButton = new javax.swing.JButton();
        decodeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 39, 45));
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coverImageButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        coverImageButton.setText("Browse");
        coverImageButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        coverImageButton.setEnabled(false);
        add(coverImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 100, 30));

        keyButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        keyButton.setText("Enter Key");
        keyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        keyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyButtonActionPerformed(evt);
            }
        });
        add(keyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 100, 30));

        keyField.setForeground(new java.awt.Color(137, 137, 137));
        keyField.setText("Enter Secret Key");
        keyField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        keyField.setEnabled(false);
        add(keyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 420, 30));

        imageTextField.setForeground(new java.awt.Color(137, 137, 137));
        imageTextField.setText("Received Image Inserted");
        imageTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        imageTextField.setEnabled(false);
        add(imageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 420, 30));

        stegoImagePane.setBackground(new java.awt.Color(0, 39, 45));
        stegoImagePane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 204), null), "Stego Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(8, 177, 206))); // NOI18N
        stegoImagePane.setViewportView(stegoImageLabel);

        add(stegoImagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 420, 360));

        messagePane.setBackground(new java.awt.Color(0, 39, 45));
        messagePane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 204), null), "Hidden Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(8, 177, 206))); // NOI18N
        messagePane.setForeground(new java.awt.Color(8, 177, 206));

        messageArea.setColumns(20);
        messageArea.setLineWrap(true);
        messageArea.setRows(5);
        messageArea.setWrapStyleWord(true);
        messagePane.setViewportView(messageArea);

        add(messagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 420, 360));

        saveFileButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        saveFileButton.setText("Save File");
        saveFileButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileButtonActionPerformed(evt);
            }
        });
        add(saveFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 610, 110, 30));

        decodeButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        decodeButton.setText("Extract and Decrypt");
        decodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeButtonActionPerformed(evt);
            }
        });
        add(decodeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void keyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyButtonActionPerformed
        key = JOptionPane.showInputDialog(new JFrame("Key"), "Enter key (upto 16 characters)");
        keyField.setText(hideKey(key));
    }//GEN-LAST:event_keyButtonActionPerformed

    private void decodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeButtonActionPerformed
        try {
            String message = Decode.extract(image);
            messageArea.setText(message);
            messagePane.getViewport().add(messageArea);
            messagePane.setVisible(true);
            saveFileButton.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame("Error!!"), "ERROR!! Please re-check Stego Image and Key");
        }
    }//GEN-LAST:event_decodeButtonActionPerformed

    private void saveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileButtonActionPerformed
        String originalMessage = messageArea.getText();
        saveFileChooser = new JFileChooser("Save File");
        saveFileChooser.setFileFilter(new ExtensionFileFilter("Text File (.txt)", "txt"));
        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = saveFileChooser.getSelectedFile();
            if (file == null) {
              return;
            }
            else if (!file.getName().toLowerCase().endsWith(".txt")){
              file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                FileWriter saveFile;
                saveFile = new FileWriter(file);
                saveFile.write(originalMessage);
                saveFile.close();
            } catch (IOException ex) {
                Logger.getLogger(DecryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveFileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coverImageButton;
    private javax.swing.JButton decodeButton;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JButton keyButton;
    private javax.swing.JTextField keyField;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JScrollPane messagePane;
    private javax.swing.JButton saveFileButton;
    private javax.swing.JLabel stegoImageLabel;
    private javax.swing.JScrollPane stegoImagePane;
    // End of variables declaration//GEN-END:variables
}
