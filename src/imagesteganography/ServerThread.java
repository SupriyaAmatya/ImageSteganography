package imagesteganography;

import client.*;

public class ServerThread extends Thread {
    @Override
    public void run(){
        Client client = new client.Client();
    }
}
