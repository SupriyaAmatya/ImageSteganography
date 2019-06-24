package server; 

import imagesteganography.ExtensionFileFilter;
import static imagesteganography.MethodsUsed.*;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import static server.Server.server;

public class EncryptionPanel extends javax.swing.JPanel{
    
    static File textFile, imageFile;
    static JFileChooser imageChooser, textFileChooser, saveFileChooser;
    static String message, key;
    static JLabel coverImgLabel;
    static JScrollPane coverImgPane;
    static BufferedImage img;
    
    public EncryptionPanel() {
        initComponents();
        originalImagePane.setVisible(false);
        stegoImagePane.setVisible(false);
        sendButton.setVisible(false);
        saveButton.setVisible(false); 
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

        buttonGroup = new javax.swing.ButtonGroup();
        imageTextField = new javax.swing.JTextField();
        imageButton = new javax.swing.JButton();
        fileButton = new javax.swing.JButton();
        keyTextField = new javax.swing.JTextField();
        keyButton = new javax.swing.JButton();
        embedButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        originalImagePane = new javax.swing.JScrollPane();
        originalImageLabel = new javax.swing.JLabel();
        stegoImagePane = new javax.swing.JScrollPane();
        stegoImageLabel = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 39, 45));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(900, 680));
        setMinimumSize(new java.awt.Dimension(900, 680));
        setPreferredSize(new java.awt.Dimension(900, 680));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageTextField.setBackground(new java.awt.Color(240, 240, 240));
        imageTextField.setText("Load Image ");
        imageTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        imageTextField.setEnabled(false);
        imageTextField.setSelectionColor(new java.awt.Color(51, 51, 51));
        add(imageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 420, 30));

        imageButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        imageButton.setForeground(new java.awt.Color(0, 39, 45));
        imageButton.setText("Browse");
        imageButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });
        add(imageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 110, 30));

        fileButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fileButton.setForeground(new java.awt.Color(0, 39, 45));
        fileButton.setText("Open");
        fileButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });
        add(fileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 110, 30));

        keyTextField.setBackground(new java.awt.Color(240, 240, 240));
        keyTextField.setText("Enter secret key (upto 16 characters)");
        keyTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        keyTextField.setEnabled(false);
        keyTextField.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        keyTextField.setSelectionColor(new java.awt.Color(51, 51, 51));
        add(keyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 420, 30));

        keyButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        keyButton.setForeground(new java.awt.Color(0, 39, 45));
        keyButton.setText("Enter Key");
        keyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        keyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyButtonActionPerformed(evt);
            }
        });
        add(keyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 110, 30));

        embedButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        embedButton.setForeground(new java.awt.Color(0, 39, 45));
        embedButton.setText("Encrypt and Embed");
        embedButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        embedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embedButtonActionPerformed(evt);
            }
        });
        add(embedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 190, 30));

        sendButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sendButton.setForeground(new java.awt.Color(0, 39, 45));
        sendButton.setText("Ok");
        sendButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 640, 90, 30));

        originalImagePane.setBackground(new java.awt.Color(0, 39, 45));
        originalImagePane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 204), null), "Original Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(8, 177, 206))); // NOI18N
        originalImagePane.setForeground(new java.awt.Color(220, 201, 161));

        originalImageLabel.setBackground(new java.awt.Color(204, 204, 204));
        originalImageLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 185, 154), 1, true));
        originalImageLabel.setOpaque(true);
        originalImagePane.setViewportView(originalImageLabel);

        add(originalImagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 440, 390));

        stegoImagePane.setBackground(new java.awt.Color(0, 39, 45));
        stegoImagePane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 204), null), "Stego Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(8, 177, 206))); // NOI18N
        stegoImagePane.setForeground(new java.awt.Color(8, 177, 206));

        stegoImageLabel.setBackground(new java.awt.Color(204, 204, 204));
        stegoImageLabel.setForeground(new java.awt.Color(8, 177, 206));
        stegoImageLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 185, 154), 1, true));
        stegoImageLabel.setOpaque(true);
        stegoImagePane.setViewportView(stegoImageLabel);

        add(stegoImagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 440, 390));

        rb1.setBackground(new java.awt.Color(0, 39, 45));
        buttonGroup.add(rb1);
        rb1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rb1.setForeground(new java.awt.Color(8, 177, 206));
        rb1.setSelected(true);
        rb1.setText("Enter Text");
        rb1.setIconTextGap(10);
        add(rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, 30));

        rb2.setBackground(new java.awt.Color(0, 39, 45));
        buttonGroup.add(rb2);
        rb2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rb2.setForeground(new java.awt.Color(8, 177, 206));
        rb2.setText("Select File");
        rb2.setIconTextGap(10);
        add(rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 110, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 177, 206));
        jLabel1.setText("Select Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, 30));

        saveButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 39, 45));
        saveButton.setText("Save");
        saveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void keyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyButtonActionPerformed
        key = JOptionPane.showInputDialog(new JFrame("Key"), "Enter key (upto 16 characters)");
        keyTextField.setText(hideKey(key));
    }//GEN-LAST:event_keyButtonActionPerformed

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        imageChooser = new JFileChooser();
        FileFilter filter1 = new ExtensionFileFilter("Image files (png, jpg, jpeg, bmp)", new String[] { "JPG", "JPEG", "PNG", "BMP" });
        imageChooser.setFileFilter(filter1);
        int result = imageChooser.showOpenDialog(this);
        imageFile = imageChooser.getSelectedFile();
        imageTextField.setText(imageFile.getAbsolutePath());
       
        //Display original image
        if(result == JFileChooser.APPROVE_OPTION){
            try {   
                BufferedImage sourceImage;
                sourceImage = ImageIO.read(imageChooser.getSelectedFile());
                originalImageLabel = new JLabel(new ImageIcon(sourceImage));
                originalImagePane.getViewport().add(originalImageLabel);
                this.validate();
                originalImagePane.setVisible(true);
            } catch(Exception e) {  }
        }
    }//GEN-LAST:event_imageButtonActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        //for dialog text message
        if(rb1.isSelected()== true){
            Window parentWindow = SwingUtilities.windowForComponent(this);
            Frame parentFrame = null;
            if (parentWindow instanceof Frame) {
             parentFrame = (Frame)parentWindow;
            }
            final JDialog dialog = new JDialog(parentFrame,"Dialog");
            final JTextArea textMessage = new JTextArea();
            JButton b = new JButton("OK");
            b.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(e.getActionCommand().equals("OK")){
                        message = textMessage.getText();
                        dialog.setVisible(false);
                    }
                }
            });
            
            JScrollPane scrollPane = new JScrollPane(textMessage);
            dialog.getContentPane().add(scrollPane);
            dialog.getContentPane().add(BorderLayout.SOUTH,b);
            dialog.setSize(400, 400);
            dialog.setLocationRelativeTo(parentFrame);
            dialog.setVisible(true);
            
        }
        
        //for text file
        else if(rb2.isSelected()== true){
            textFileChooser = new JFileChooser();
            FileFilter filter = new ExtensionFileFilter("Text Files (.txt)", new String [] {"txt"});
            textFileChooser.setFileFilter(filter);
            textFileChooser.showOpenDialog(this);
            StringBuilder msg = new StringBuilder("");
            try {
                //textFile = textFileChooser.getSelectedFile();
                FileInputStream fi = new FileInputStream(textFileChooser.getSelectedFile());
                int i;
                while((i=fi.read())!= -1){
                    msg.append((char)i);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(msg.toString());
            message = msg.toString();
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void embedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embedButtonActionPerformed
        try {
            img = Encode.encrypt(message, key);
            stegoImageLabel.setIcon(new ImageIcon(img));
            stegoImagePane.getViewport().add(stegoImageLabel);
            stegoImagePane.setVisible(true);
            sendButton.setVisible(true);
            saveButton.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame("Error!!"), "ERROR!! Please enter/re-check all input data.");
        }
    }//GEN-LAST:event_embedButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
//        try {
            server.flag = 1;
            server.image = img;
            server.serverText.setText("(Stego-Image)");
            server.serverText.setEditable(false);
            server.frame.setVisible(false);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
//        RenderedImage im = (RenderedImage) img;
//        saveFileChooser = new JFileChooser("Save File");
//        saveFileChooser.setFileFilter(new ExtensionFileFilter("Image Files (png, jpg, jpeg, bmp)", new String[] { "JPG", "JPEG", "PNG", "BMP" }));
//        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = saveFileChooser.getSelectedFile();
//            String filename = file.getName().toLowerCase();
//            if (file == null) {
//              return;
//            }
//            else if(validateName(filename)){
//              file = new File(file.getParentFile(), file.getName() + ".jpg");
//            }
//            try {
//                ImageIO.write(im, filename, file);
//            } catch (IOException ex) {
//                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        RenderedImage im = (RenderedImage) img;
        saveFileChooser = new JFileChooser();
        saveFileChooser.setFileFilter(new ExtensionFileFilter("Image Files (png, jpg, jpeg, bmp)", new String[] { "JPG", "JPEG", "PNG", "BMP" }));
        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File embedFile = saveFileChooser.getSelectedFile();
            try {
                ImageIO.write(im, "png", embedFile);
            } catch (IOException ex) {
                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton embedButton;
    private javax.swing.JButton fileButton;
    private javax.swing.JButton imageButton;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton keyButton;
    private javax.swing.JTextField keyTextField;
    private javax.swing.JLabel originalImageLabel;
    private javax.swing.JScrollPane originalImagePane;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel stegoImageLabel;
    private javax.swing.JScrollPane stegoImagePane;
    // End of variables declaration//GEN-END:variables
}


