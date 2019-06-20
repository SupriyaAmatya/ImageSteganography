package imagesteganography;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread{
    @Override
    public void run(){
        new client.Client();
    }
}