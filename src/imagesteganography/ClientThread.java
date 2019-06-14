package imagesteganography;

import server.*;

public class ClientThread extends Thread{
    @Override
    public void run(){
        Server server = new server.Server();
    }
}