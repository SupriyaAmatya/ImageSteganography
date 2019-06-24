package imagesteganography;

import Decoder.BASE64Encoder;
import static imagesteganography.EncryptionPanel.imageChooser;
import static imagesteganography.MethodsUsed.ToBinary;
import static imagesteganography.MethodsUsed.keyGeneration;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Encode {

    public static BufferedImage encrypt(String message, String key) throws Exception{
        Key k = keyGeneration(key);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,k);
        byte [] encrypted = cipher.doFinal(message.getBytes());
        String messageCipher = new BASE64Encoder().encode(encrypted);
        BufferedImage img = embed(messageCipher);
        return img;
    }
    
    public static BufferedImage embed(String messageCipher) throws IOException{
        int msglen = messageCipher.length()*2;
        System.out.println(msglen);
        messageCipher = Integer.toString(msglen)+'/'+messageCipher;
        System.out.println(messageCipher);
        
        BufferedImage image;
        image = ImageIO.read(imageChooser.getSelectedFile());
        int width =image.getWidth();
        int height =image.getHeight();

        if ((height*width)<messageCipher.length()*8){
            JOptionPane.showMessageDialog(new JFrame(),"Error! Image too small. Please select another image.");
            return null;
        }  
            Color x =new Color (image.getRGB(0,0));
            System.out.println(ToBinary(x.getRed()));
            System.out.println(ToBinary(x.getGreen()));
            System.out.println(ToBinary(x.getBlue()));
            Color x1 =new Color (image.getRGB(1,0));
            System.out.println(ToBinary(x1.getRed()));
            System.out.println(ToBinary(x1.getGreen()));
            System.out.println(ToBinary(x1.getBlue()));
            Color x2 =new Color (image.getRGB(2,0));
            System.out.println(ToBinary(x2.getRed()));
            System.out.println(ToBinary(x2.getGreen()));
            System.out.println(ToBinary(x2.getBlue()));
            Color x3 =new Color (image.getRGB(3,0));
            System.out.println(ToBinary(x3.getRed()));
            System.out.println(ToBinary(x3.getGreen()));
            System.out.println(ToBinary(x3.getBlue()));
            Color x4 =new Color (image.getRGB(4,0));
            System.out.println(ToBinary(x4.getRed()));
            System.out.println(ToBinary(x4.getGreen()));
            System.out.println(ToBinary(x4.getBlue()));
            Color x5 =new Color (image.getRGB(5,0));
            System.out.println(ToBinary(x5.getRed()));
            System.out.println(ToBinary(x5.getGreen()));
            System.out.println(ToBinary(x5.getBlue()));
            Color x6 =new Color (image.getRGB(6,0));
            System.out.println(ToBinary(x6.getRed()));
            System.out.println(ToBinary(x6.getGreen()));
            System.out.println(ToBinary(x6.getBlue()));
            Color x7 =new Color (image.getRGB(7,0));
            System.out.println(ToBinary(x7.getRed()));
            System.out.println(ToBinary(x7.getGreen()));
            System.out.println(ToBinary(x7.getBlue()));
            
   
            int count = 0;
            char [] msgBit = new char[messageCipher.length()*8];
            for(int i=0; i< messageCipher.length(); i++){
                String charBinary = ToBinary(messageCipher.charAt(i));
                for(int j=0; j<8; j++){
                    msgBit[count++] = charBinary.charAt(j);
                }
            }
            
           System.out.println(Arrays.toString(msgBit));
            
            count = 0;
            int red, green, blue;
            Color c;
            int flag = 0;
            
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    c = new Color(image.getRGB(j,i));
                    red = Integer.parseInt(ToBinary(c.getRed()).substring(0,7)+msgBit[count++],2);
                    if(count>=msgBit.length)
                            { flag = 1;
                            la:
                                {
                                green = c.getGreen();
                                blue = c.getBlue();
                                c = new Color(red,green,blue);
                                image.setRGB(j,i,c.getRGB());
                                }
                            break;
                            }
                    green = Integer.parseInt(ToBinary(c.getGreen()).substring(0,7)+msgBit[count++],2);
                    if(count>=msgBit.length)
                            { flag = 1;
                            la:
                                {
                                blue = c.getBlue();
                                c = new Color(red,green,blue);
                                image.setRGB(j,i,c.getRGB());
                                }
                                break;
                            }
                    blue = Integer.parseInt(ToBinary(c.getBlue()).substring(0,7)+msgBit[count++],2);
                    c = new Color(red,green,blue);
                    image.setRGB(j,i,c.getRGB());
                    if(count>=msgBit.length)
                            { flag = 1;
                              break;
                            }
                }
                if(flag==1){break;}
            }
            
            
            Color a =new Color (image.getRGB(0,0));
            System.out.println(ToBinary(a.getRed()));
            System.out.println(ToBinary(a.getGreen()));
            System.out.println(ToBinary(a.getBlue()));
            Color b =new Color (image.getRGB(1,0));
            System.out.println(ToBinary(b.getRed()));
            System.out.println(ToBinary(b.getGreen()));
            System.out.println(ToBinary(b.getBlue()));
            Color d =new Color (image.getRGB(2,0));
            System.out.println(ToBinary(d.getRed()));
            System.out.println(ToBinary(d.getGreen()));
            System.out.println(ToBinary(d.getBlue()));
            Color e =new Color (image.getRGB(3,0));
            System.out.println(ToBinary(e.getRed()));
            System.out.println(ToBinary(e.getGreen()));
            System.out.println(ToBinary(e.getBlue()));
            Color f =new Color (image.getRGB(4,0));
            System.out.println(ToBinary(f.getRed()));
            System.out.println(ToBinary(f.getGreen()));
            System.out.println(ToBinary(f.getBlue()));
            Color g =new Color (image.getRGB(5,0));
            System.out.println(ToBinary(g.getRed()));
            System.out.println(ToBinary(g.getGreen()));
            System.out.println(ToBinary(g.getBlue()));
            Color h =new Color (image.getRGB(6,0));
            System.out.println(ToBinary(h.getRed()));
            System.out.println(ToBinary(h.getGreen()));
            System.out.println(ToBinary(h.getBlue()));
            Color i =new Color (image.getRGB(7,0));
            System.out.println(ToBinary(i.getRed()));
            System.out.println(ToBinary(i.getGreen()));
            System.out.println(ToBinary(i.getBlue()));
            Color j =new Color (image.getRGB(8,0));
            System.out.println(ToBinary(j.getRed()));
            System.out.println(ToBinary(j.getGreen()));
            System.out.println(ToBinary(j.getBlue()));
            Color k =new Color (image.getRGB(9,0));
            System.out.println(ToBinary(k.getRed()));
            System.out.println(ToBinary(k.getGreen()));
            System.out.println(ToBinary(k.getBlue()));
            Color l =new Color (image.getRGB(10,0));
            System.out.println(ToBinary(l.getRed()));
            System.out.println(ToBinary(l.getGreen()));
            System.out.println(ToBinary(l.getBlue()));
            
        System.out.println("Successful! New cover image created");
      
        return image;
    }
   
}