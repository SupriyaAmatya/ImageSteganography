package imagesteganography;

import static imagesteganography.StartProgram.layeredPane;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class MethodsUsed {
    
    public static void switchPanels(JPanel panel){
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public static String ToBinary(int a)
    {
        String binary = Integer.toBinaryString(a);
        while(binary.length() !=8){
            binary = "0"+binary;
        }
        return binary;
    }
    
    public static Key keyGeneration(String key) throws UnsupportedEncodingException{
        while(key.length()!=16){
            key = key +"a";
        }
        Key k = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        return k;
    }
    
    public static String hideKey(String s){
        String k = "";
        for(int i=0;i<s.length();i++){
            k = k+"*";
        }
        return k;
    }
    
    public static int networkConnection(){
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return 1;
            }catch (IOException ex) { }
        return 0;
    }
    
    public static boolean validateName(File f) {
        if(f.getName().toLowerCase().endsWith(".jpg")) return false;
        else if(f.getName().toLowerCase().endsWith(".png")) return false;
        else if(f.getName().toLowerCase().endsWith(".bmp")) return false;
        else if(f.getName().toLowerCase().endsWith(".jpeg")) return false;
        else return true;
    }
}