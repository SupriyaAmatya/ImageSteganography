package server;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
//import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

public class Server extends JFrame{
    static ServerSocket s;
    static Socket cs;
    ObjectOutputStream output;
    ObjectInputStream input;
    int port;
    String message;
    static Server server;
    static JFrame frame;
    EncryptionPanel encryptionPanel;
    static int flag=0;
    static BufferedImage image;
    
    public Server() throws ClassNotFoundException, BadLocationException{
        initComponents();
//        setLocationRelativeTo(null);
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
                    serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Waiting for Someone to Connect...",null);
                    cs=s.accept();
                    serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Connected to "+cs.getInetAddress().getHostName(),null);
                    output = new ObjectOutputStream(cs.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(cs.getInputStream());
                    whileChatting();
                }catch(EOFException eofException){
                    serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Connection to client lost.\n",null);
                }
            }
        } catch (IOException ex) {
            if(s==null)
                JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not start Server.");
            setVisible(false);
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void whileChatting() throws IOException, ClassNotFoundException, BadLocationException
    {
      while(true){
//          Object o = input.readObject();
//          System.out.println(o.getClass().getSimpleName());
//          if("String".equals(o.getClass().getSimpleName())){
              message = (String) input.readObject();
              serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Client: "+message,null);
//          }
//          else{
//              BufferedImage image = (BufferedImage)input.readObject();
//              serverDisplay.setText(serverDisplay.getText()+("\n  Client: Image Sent."));
//              new ImageDialog(image);
//          }
      }
    }
    
    public void sendMessage(String message) throws BadLocationException
    {
        try
        {
            output.writeObject(message);
            output.flush();
            serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Server: "+message,null);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendImage() throws IOException, BadLocationException{
//        output.writeObject(image);
//        output.flush();
        serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Server: Image Sent.",null);
        new ImageDialog(image);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        serverDisplay = new javax.swing.JTextPane();
        serverDisplay.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Server");
        setLocation(new java.awt.Point(50, 50));

        serverText.setColumns(20);
        serverText.setLineWrap(true);
        serverText.setRows(5);
        serverText.setWrapStyleWord(true);
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

        serverDisplay.setContentType("text/html");
        serverDisplay.setEditorKit(new HTMLEditorKit());
        jScrollPane2.setViewportView(serverDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
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
        frame = new JFrame("Encryption");
        encryptionPanel = new EncryptionPanel();
        frame.add(encryptionPanel);
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void serverSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSendActionPerformed
        if(flag==0){
        try{
            sendMessage(serverText.getText());
            serverText.setText("");
        }catch (Exception e){
            try {
                serverDisplay.getDocument().insertString(serverDisplay.getDocument().getLength(),"\n  Unable to Send Message",null);
            } catch (BadLocationException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(flag==1){
            try {
                sendImage();
                flag=0;
                serverText.setText("");
                serverText.setEditable(true);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadLocationException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
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
   
    public static void main(String[] args) throws ClassNotFoundException, IOException, BadLocationException 
    {
        server=new Server();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane serverDisplay;
    private javax.swing.JButton serverSend;
    public static javax.swing.JTextArea serverText;
    // End of variables declaration//GEN-END:variables
}
