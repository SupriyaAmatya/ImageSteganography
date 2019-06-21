package client;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

public class Client extends javax.swing.JFrame {
    Socket con;
    ObjectOutputStream output;
    ObjectInputStream input;
    String message="", serverIP="127.0.0.1";
    int port;
    static Client client;
    
    public Client(){
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        port = Integer.parseInt(JOptionPane.showInputDialog(new JFrame("Port"), "Enter port number of server."));
        try
       {
            clientDisplay.setText(clientDisplay.getText()+"\n  Attempting Connection ...");
            try
            {
                con = new Socket(InetAddress.getByName(serverIP),port);
            }catch(IOException e){
                JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not connect to Server.");
                setVisible(false);
            }
            
            clientDisplay.setText(clientDisplay.getText()+"\n  Connected to: " + con.getInetAddress().getHostName());
            output = new ObjectOutputStream(con.getOutputStream());
            output.flush();
            input = new ObjectInputStream(con.getInputStream());
            whileChatting();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
   
    private void whileChatting() throws IOException, ClassNotFoundException
    {
      while(true){
//          Object o = input.readObject();
//          if("String".equals(o.getClass().getSimpleName())){
              message = (String) input.readObject();
              clientDisplay.setText(clientDisplay.getText()+"\n  Server: "+message);
//          }
//          else{
//              BufferedImage image = (BufferedImage) input.readObject();
//              clientDisplay.setText(clientDisplay.getText()+("\n  Server"));
//              clientDisplay.add(new JLabel((Icon) image));
//          }
      }
    }
    
    private void sendMessage(String message)
    {
        try
        {
            output.writeObject(message);
            output.flush();
            clientDisplay.setText(clientDisplay.getText()+"\n  Client: "+message);
        }
        catch(IOException ioException)
        {
            clientDisplay.setText(clientDisplay.getText()+"\n  Unable to Send Message.");
        }
    }
    
    public void sendImage() throws IOException{
        output.writeObject(EncryptionPanel.img);
        output.flush();
        clientDisplay.setText(clientDisplay.getText()+"\n  Client: ");
        clientDisplay.add(new JLabel((Icon) EncryptionPanel.img));
//        ImageIO.write(EncryptionPanel.img, "PNG", con.getOutputStream());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        clientText = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        clientSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientDisplay = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Client");

        clientText.setColumns(20);
        clientText.setRows(5);
        jScrollPane6.setViewportView(clientText);

        jButton11.setText("Encrypt");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        clientSend.setText("Send");
        clientSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CLIENT SIDE...");

        jButton12.setText("Stop Connection");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        clientDisplay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        clientDisplay.setEnabled(false);
        jScrollPane1.setViewportView(clientDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(clientSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGap(95, 95, 95)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(clientSend)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(535, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new EncryptionFrame();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void clientSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSendActionPerformed
        sendMessage(clientText.getText());
        clientText.setText("");
    }//GEN-LAST:event_clientSendActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try{
            this.dispose();
            con.close();
            JOptionPane.showMessageDialog(new JFrame("Message"), "Connection to server closed.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame("Message"), "Connection not established yet.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed
    
    public static void main(String[] args) throws ClassNotFoundException 
    {
        client=new Client();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane clientDisplay;
    private javax.swing.JButton clientSend;
    private javax.swing.JTextArea clientText;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
