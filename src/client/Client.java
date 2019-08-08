package client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;
//import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

public class Client extends javax.swing.JFrame {
    Socket con;
    ObjectOutputStream output;
    ObjectInputStream input;
    String message="1", serverIP="127.0.0.1";
    int port;
    static Client client;
    static JFrame frame;
    EncryptionPanel encryptionPanel;
//    static int flag=0;
    static BufferedImage image;
    
    public Client(){
        initComponents();
//        setLocationRelativeTo(null);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        port = Integer.parseInt(JOptionPane.showInputDialog(new JFrame("Port"), "Enter port number of server."));
        try
        {
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Attempting Connection ...",null);
            try
            {
                con = new Socket(InetAddress.getByName(serverIP),port);
            }catch(IOException e){
                JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not connect to Server.");
                setVisible(false);
            }
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Connected to: " + con.getInetAddress().getHostName(),null);
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
   
    public void whileChatting() throws IOException, ClassNotFoundException, BadLocationException
    {
        while(true){
//            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Server: "+input.readObject().toString(),null);
            try{
//                message = (String) input.readObject();
//                if(input.readObject().toString().charAt(0)=='0'){
//                        clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Server: "+input.readObject().toString().substring(1),null);
//                }
//                else{
//                    BufferedImage receivedImage = ImageIO.read(con.getInputStream());
                ByteArrayInputStream bis = new ByteArrayInputStream((byte[]) input.readObject());
                BufferedImage receivedImage = ImageIO.read(bis);
//                    BufferedImage receivedImage = (BufferedImage) input.readObject();
                    clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Server: Image",null);
                    new ImageDialog(receivedImage).setLocationRelativeTo(null);
//                }
            }
            catch(OptionalDataException | StreamCorruptedException e){ e.printStackTrace(); }
        }
    }
    
    public void sendMessage(String message) throws BadLocationException
    {
        try
        {
            output.writeObject(message);
            output.flush();
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Client: "+message,null);
        }
        catch(IOException ioException){ 
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Unable to Send Message.",null);
        }
    }
    
    public void sendImage() throws BadLocationException{
        try
        {
//            ImageIO.write(image, "png", con.getOutputStream());
//            con.getOutputStream().flush();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", bos );
            byte [] data = bos.toByteArray();
            output.writeObject(data);
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Client: Image Sent.",null);
    //        JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Connection lost");
    //        this.dispose();
        }
        catch(IOException ioException){ 
            clientDisplay.getDocument().insertString(clientDisplay.getDocument().getLength(),"\n  Unable to Send Image. Server inactive.",null);
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        clientDisplay = new javax.swing.JTextPane();
        clientDisplay.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Client");
        setLocation(new java.awt.Point(690, 50));

        clientText.setColumns(20);
        clientText.setLineWrap(true);
        clientText.setRows(5);
        clientText.setWrapStyleWord(true);
        clientText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        clientText.setEnabled(false);
        jScrollPane6.setViewportView(clientText);

        jButton11.setText("Encrypt");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        clientSend.setText("Send");
        clientSend.setEnabled(false);
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

        clientDisplay.setContentType("text/html");
        clientDisplay.setEditorKit(new HTMLEditorKit());
        jScrollPane2.setViewportView(clientDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(clientSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
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
        frame = new JFrame("Encryption");
        encryptionPanel = new EncryptionPanel();
        frame.add(encryptionPanel);
        frame.setSize(910,710);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false); 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void clientSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSendActionPerformed
//        if(flag==0){
//            try {
//                sendMessage(clientText.getText());
//                clientText.setText("");
//            } catch (BadLocationException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else if(flag==1){
            try {
                sendImage();
//                flag=0;
                clientText.setText("");
                clientSend.setEnabled(false);
//                clientText.setEditable(true);
            } catch (BadLocationException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }
    }//GEN-LAST:event_clientSendActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try{
            con.close();
            this.dispose();
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
    private javax.swing.JTextPane clientDisplay;
    public static javax.swing.JButton clientSend;
    public static javax.swing.JTextArea clientText;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
