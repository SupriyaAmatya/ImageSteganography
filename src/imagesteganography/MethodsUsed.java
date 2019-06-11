package imagesteganography;

import static imagesteganography.ImageSteganography.layeredPane;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JPanel;

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
}
