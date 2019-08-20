package imagesteganography;

import Decoder.BASE64Decoder;
import static imagesteganography.MethodsUsed.ToBinary;
import static imagesteganography.MethodsUsed.keyGeneration;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.imageio.ImageIO;

public class Decode {
    
    public static char lsb(int col)
    {
        String colBinary = ToBinary(col);
        return colBinary.charAt(7);
    }

    public static String extract(BufferedImage image) throws Exception{
        int width =image.getWidth();
        int height = image.getHeight();
        int count = 0, msgLen=0;
        char [] messageBits = new char [height*width*3];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Color c = new Color(image.getRGB(j,i));
                messageBits[count++] = lsb(c.getRed());
                messageBits[count++] = lsb(c.getGreen());
                messageBits[count++] = lsb(c.getBlue());
            }
        }

//        System.out.print(Arrays.toString(messageBits));
        count = 0;
        StringBuilder length = new StringBuilder("");
        StringBuilder letterBinary;
        for(int i=0; i<messageBits.length; i++){
            letterBinary = new StringBuilder("");
            for(int j=0; j<8; j++){
                letterBinary.append(messageBits[count++]);
            }
            if((char) Integer.parseInt(letterBinary.toString(),2)=='/'){
                msgLen = (Integer.parseInt(length.toString()))/2;
                break;
            }
            length.append((char) Integer.parseInt(letterBinary.toString(),2));   
        }
        
//        System.out.println(msgLen);

        StringBuilder msg = new StringBuilder("");
        for(int i=0; i<msgLen; i++){
            letterBinary = new StringBuilder("");
            for(int j=0; j<8; j++){
                letterBinary.append(messageBits[count++]);
            }
            msg.append((char) Integer.parseInt(letterBinary.toString(),2));
        }
        
        String messageCipher = msg.toString();
//        System.out.println(messageCipher);
        String message = decrypt(messageCipher);
      
        return message;
    }
    
    public static String decrypt(String messageCipher) throws Exception{
//        long startTime = System.nanoTime();
//        long startTime = System.currentTimeMillis();
        String key = DecryptionPanel.key;
        Key k = keyGeneration(key);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, k);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(messageCipher);
        byte[] original = cipher.doFinal(decodedValue);
        String message = new String(original);
//        System.out.println(message);
//        long endTime = System.currentTimeMillis();
//        long endTime = System.nanoTime();
//        long timeElapsed = endTime - startTime;
//        System.out.println("Execution time in nanoseconds: " + timeElapsed);
//        System.out.println("Execution time in milliseconds: " + timeElapsed);
        return message;
    }
}