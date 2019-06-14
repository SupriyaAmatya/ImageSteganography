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
    int port, totalClients=100;
    
    public Server() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        port = Integer.parseInt(JOptionPane.showInputDialog(new JFrame("Port"), "Enter port number to assign."));
    }
    
    public void startRunning()
    {
        try
        {
            s=new ServerSocket(port, totalClients);
            while(true)
            {
                try
                {
                    serverDisplay.append("\n  Waiting for Someone to Connect...");
                    cs=s.accept();
                    serverDisplay.append("\n  Connected to "+cs.getInetAddress().getHostName());
                    output = new ObjectOutputStream(cs.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(cs.getInputStream());
                    whileChatting();
                }catch(EOFException eofException){
                    JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not start Server.");
                    setVisible(false);
                }
            }
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public void whileChatting() throws IOException
    {
        String message="";
        do{
            try
            {
//                Object o = input.readObject();
//                if("String".equals(typeof(o))){
                    message = (String) input.readObject();
                    serverDisplay.append("\n  "+message);
//                }
//                else{
//                    BufferedImage image = ImageIO.read(cs.getInputStream());
//                    serverDisplay.append("\n  Client: ");
//                    serverDisplay.add(new JLabel(new ImageIcon(image)), BorderLayout.CENTER);
//                }
            }catch(ClassNotFoundException classNotFoundException){ }
        }while(!message.equals("Client: END"));
    }
    
    public void sendMessage(String message)
    {
        try
        {
            output.writeObject("Server: " + message);
            output.flush();
            serverDisplay.append("\n  Server: "+message);
        }
        catch(IOException ioException)
        {
            serverDisplay.append("\n  Unable to Send Message");
        }
    }
    
    public void sendImage() throws IOException{
        ImageIO.write(EncryptionPanel.img, "PNG", cs.getOutputStream());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        serverDisplay = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        serverText = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        serverSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Server");

        serverDisplay.setBackground(new java.awt.Color(246, 245, 245));
        serverDisplay.setColumns(20);
        serverDisplay.setRows(5);
        serverDisplay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        serverDisplay.setEnabled(false);
        jScrollPane1.setViewportView(serverDisplay);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverSend))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addGap(71, 71, 71)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new EncryptionFrame();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void serverSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSendActionPerformed
        sendMessage(serverText.getText());
	serverText.setText("");
    }//GEN-LAST:event_serverSendActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(s!=null){
            try{
                s.close();
                setVisible(false);
                JOptionPane.showMessageDialog(new JFrame("Message"), "Server closed.");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame("Message"), "Server not started yet.");  
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String[] args) 
    {
        Server server=new Server();
        server.startRunning();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea serverDisplay;
    private javax.swing.JButton serverSend;
    private javax.swing.JTextArea serverText;
    // End of variables declaration//GEN-END:variables
}
