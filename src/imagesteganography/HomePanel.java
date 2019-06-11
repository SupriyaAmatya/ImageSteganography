package imagesteganography;

import static imagesteganography.MethodsUsed.switchPanels;

public class HomePanel extends javax.swing.JPanel {
    
    public HomePanel() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encryptionButton = new javax.swing.JButton();
        decryptionButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(900, 680));
        setMinimumSize(new java.awt.Dimension(900, 680));
        setPreferredSize(new java.awt.Dimension(900, 680));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encryptionButton.setBackground(new java.awt.Color(255, 255, 255));
        encryptionButton.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        encryptionButton.setForeground(new java.awt.Color(25, 125, 135));
        encryptionButton.setText("Encrypt and Embed");
        encryptionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        encryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionButtonActionPerformed(evt);
            }
        });
        add(encryptionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 290, 60));

        decryptionButton.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        decryptionButton.setForeground(new java.awt.Color(25, 125, 135));
        decryptionButton.setText("Extract and Decrypt");
        decryptionButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        decryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionButtonActionPerformed(evt);
            }
        });
        add(decryptionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 290, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void decryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionButtonActionPerformed
        DecryptionPanel d = new DecryptionPanel();
        switchPanels(d);
    }//GEN-LAST:event_decryptionButtonActionPerformed

    private void encryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionButtonActionPerformed
       switchPanels(new EncryptionPanel());
    }//GEN-LAST:event_encryptionButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptionButton;
    private javax.swing.JButton encryptionButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
