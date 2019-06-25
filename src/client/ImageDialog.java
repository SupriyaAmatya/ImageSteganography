package client;

import imagesteganography.ExtensionFileFilter;
import static imagesteganography.MethodsUsed.validateName;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ImageDialog extends javax.swing.JDialog {
    BufferedImage image;
    static JFrame frame;

    public ImageDialog(BufferedImage img) {
        image = img;
        initComponents();
        ImageIcon imgIcon = new ImageIcon(img);
        imageLabel.setIconTextGap(Image.SCALE_SMOOTH);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Received Stego-Image");

        jButton1.setText("Extract and Decrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        imageLabel.setAutoscrolls(true);
        imageLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setViewportView(imageLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jButton1)
                        .addGap(55, 55, 55)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame = new JFrame("Decryption");
        DecryptionPanel decryptionPanel = new DecryptionPanel(image);
        frame.add(decryptionPanel);
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        RenderedImage im = (RenderedImage) image;
//        JFileChooser saveFileChooser = new JFileChooser("Save File");
//        saveFileChooser.setFileFilter(new ExtensionFileFilter("Image Files (png, jpg, jpeg, bmp))", new String[] { "JPG", "JPEG", "PNG", "BMP" }));
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
//                ImageIO.write(im, "jpg", file);
//            } catch (IOException ex) {
//                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        RenderedImage im = (RenderedImage) image;
        JFileChooser saveFileChooser = new JFileChooser();
        saveFileChooser.setFileFilter(new ExtensionFileFilter("Image Files (png, jpg, jpeg, bmp)", new String[] { "JPG", "JPEG", "PNG", "BMP" }));
        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File embedFile = saveFileChooser.getSelectedFile();
            try {
                ImageIO.write(im, "png", embedFile);
            } catch (IOException ex) {
                Logger.getLogger(EncryptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
