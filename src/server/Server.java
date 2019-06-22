package server;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
//import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

public class Server extends javax.swing.JFrame {
    ServerSocket s;
    Socket cs;
    ObjectOutputStream output;
    ObjectInputStream input;
    int port;
    String message;
    static Server server;
    
    public Server() throws ClassNotFoundException{
        initComponents();
        setLocationRelativeTo(null);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        port = Integer.parseInt(JOptionPane.showInputDialog(new JFrame("Port"), "Enter port number to assign."));
        try
        {
            s=new ServerSocket(port, 10);
            while(true)
            {
                try
                {
                    serverDisplay.setText(serverDisplay.getText()+"\n  Waiting for Someone to Connect...");
                    cs=s.accept();
                    serverDisplay.setText(serverDisplay.getText()+"\n  Connected to "+cs.getInetAddress().getHostName());
                    output = new ObjectOutputStream(cs.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(cs.getInputStream());
                    whileChatting();
                }catch(EOFException eofException){
                    serverDisplay.setText(serverDisplay.getText()+"\n  Connection to client lost.\n");
                }
            }
        } catch (IOException ex) {
            if(s==null)
                JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not start Server.");
            setVisible(false);
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void whileChatting() throws IOException, ClassNotFoundException
    {
      while(true){
//          Object o = input.readObject();
//          if("String".equals(o.getClass().getSimpleName())){
              message = (String) input.readObject();
              serverDisplay.setText(serverDisplay.getText()+"\n  Client: "+message);
//          }
//          else{
//              BufferedImage image = (BufferedImage)input.readObject();
//              serverDisplay.setText(serverDisplay.getText()+("\n  Client:"));
//              serverDisplay.add(new JLabel((Icon) image));
//          }
      }
    }
    
    public void sendMessage(String message)
    {
        try
        {
            output.writeObject(message);
            output.flush();
            serverDisplay.setText(serverDisplay.getText()+"\n  Server: "+message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendImage() throws IOException{
        output.writeObject(EncryptionPanel.img);
        output.flush();
        serverDisplay.setText(serverDisplay.getText()+"\n  Server: ");
        serverDisplay.add(new JLabel((Icon) EncryptionPanel.img));
//        ImageIO.write(EncryptionPanel.img, "PNG", cs.getOutputStream());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        serverText = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        serverSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serverDisplay = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Server");

        serverText.setColumns(20);
        serverText.setRows(5);
        jScrollPane3.setViewportView(serverText);

        jButton6.setText("Encrypt");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        serverSend.setText("Send");
        serverSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SERVER SIDE...");

        jButton2.setText("Stop Server");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        serverDisplay.setBackground(new java.awt.Color(255, 255, 255));
        serverDisplay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        serverDisplay.setEnabled(false);
        jScrollPane1.setViewportView(serverDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serverSend))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new EncryptionFrame();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void serverSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSendActionPerformed
        try{
            sendMessage(serverText.getText());
            serverText.setText("");
        }catch (Exception e){
            serverDisplay.setText(serverDisplay.getText()+"\n  Unable to Send Message");
        }
    }//GEN-LAST:event_serverSendActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            cs.close();
            s.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                this.dispose();
                JOptionPane.showMessageDialog(new JFrame("Message"), "Server closed.");
            }   
    }//GEN-LAST:event_jButton2ActionPerformed
   
    public static void main(String[] args) throws ClassNotFoundException, IOException 
    {
        server=new Server();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane serverDisplay;
    private javax.swing.JButton serverSend;
    private javax.swing.JTextArea serverText;
    // End of variables declaration//GEN-END:variables
}
