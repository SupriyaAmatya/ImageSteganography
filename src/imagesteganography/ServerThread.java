package imagesteganography;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {
    @Override
    public void run(){
        try {
            new server.Server();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
