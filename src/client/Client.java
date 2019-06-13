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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

public class Client extends javax.swing.JFrame {
    Socket con;
    ObjectOutputStream output;
    ObjectInputStream input;
    String message="", serverIP="127.0.0.1";
    int port;
    
    public Client(){
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        port = Integer.parseInt(JOptionPane.showInputDialog(new JFrame("Port"), "Enter port number of server."));
//        try{
//            con=new Socket("localHost", port);
//            clientDisplay.append("  Connected to server...\n");
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not connect to Server.");
//            setVisible(false);
//        }
    }
   
    public void startRunning()
    {
       try
       {
            clientDisplay.append("\n  Attempting Connection ...");
            try
            {
                con = new Socket(InetAddress.getByName(serverIP),port);
            }catch(IOException e){ }
            
            clientDisplay.append("\n  Connected to: " + con.getInetAddress().getHostName());
            output = new ObjectOutputStream(con.getOutputStream());
            output.flush();
            input = new ObjectInputStream(con.getInputStream());
            whileChatting();
       }
       catch(IOException ioException)
       {
           JOptionPane.showMessageDialog(new JFrame("Error!"), "Sorry, Could not connect to Server.");
           setVisible(false);
           ioException.printStackTrace();
       }
    }
    
    private void whileChatting() throws IOException
    {
      do{
            try
            {
                Object o = input.readObject();
                if("String".equals(typeof(o))){
                    message = (String) input.readObject();
                    clientDisplay.append("\n  "+message);
                }
                else{
                    BufferedImage image = ImageIO.read(con.getInputStream());
                    clientDisplay.append("\n  Server: ");
                    clientDisplay.add(new JLabel(new ImageIcon(image)), BorderLayout.CENTER);
                }
            }
            catch(ClassNotFoundException classNotFoundException) { }
      }while(!message.equals("Server: END"));
    }
    
    private void sendMessage(String message)
    {
        try
        {
            output.writeObject("Client: " + message);
            output.flush();
            clientDisplay.append("\n  Client: "+message);
        }
        catch(IOException ioException)
        {
            clientDisplay.append("\n  Unable to Send Message.");
        }
    }
    
    public void sendImage() throws IOException{
        ImageIO.write(EncryptionPanel.img, "PNG", con.getOutputStream());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        clientDisplay = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        clientText = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        clientSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        clientDisplay.setBackground(new java.awt.Color(246, 245, 245));
        clientDisplay.setColumns(20);
        clientDisplay.setRows(5);
        clientDisplay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        clientDisplay.setEnabled(false);
        jScrollPane5.setViewportView(clientDisplay);

        clientText.setColumns(20);
        clientText.setRows(5);
        jScrollPane6.setViewportView(clientText);

        jButton11.setText("jButton6");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(clientSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 138, Short.MAX_VALUE)))
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(clientSend)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(535, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new EncryptionPanel();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void clientSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSendActionPerformed
        sendMessage(clientText.getText());
        clientText.setText("");
    }//GEN-LAST:event_clientSendActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea clientDisplay;
    private javax.swing.JButton clientSend;
    private javax.swing.JTextArea clientText;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
