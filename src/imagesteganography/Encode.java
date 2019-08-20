package imagesteganography;

import Decoder.BASE64Encoder;
import static imagesteganography.MethodsUsed.ToBinary;
import static imagesteganography.MethodsUsed.keyGeneration;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Key;
import java.util.concurrent.*;
import javax.crypto.Cipher;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Encode {
    public static BufferedImage encrypt(String message, String key) throws Exception{ 
        long startTime = System.nanoTime();
        Key k = keyGeneration(key);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,k);
        byte [] encrypted = cipher.doFinal(message.getBytes());
        String messageCipher = new BASE64Encoder().encode(encrypted);
        BufferedImage img = embed(messageCipher);
//        System.out.println(messageCipher);
//        TimeUnit.SECONDS.sleep(5);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        return img;	
    }
    
    public static BufferedImage embed(String messageCipher) throws IOException{
        int msglen = messageCipher.length()*2;
//        System.out.println(msglen);
        messageCipher = Integer.toString(msglen)+'/'+messageCipher;
//        System.out.println(messageCipher);
        
        BufferedImage image;
        image = ImageIO.read(EncryptionPanel.imageChooser.getSelectedFile());
        int width =image.getWidth();
        int height =image.getHeight();

        if ((height*width)<messageCipher.length()*8){
            JOptionPane.showMessageDialog(new JFrame(),"Error! Image too small. Please select another image.");
            return null;
        }  
   
            int count = 0;
            char [] msgBit = new char[messageCipher.length()*8];
            for(int i=0; i< messageCipher.length(); i++){
                String charBinary = ToBinary(messageCipher.charAt(i));
                for(int j=0; j<8; j++){
                    msgBit[count++] = charBinary.charAt(j);
                }
            }
            
//           System.out.println(Arrays.toString(msgBit));
//            System.out.println("Given message: "+messageCipher);
//            System.out.print("Message's bits: "+Arrays.toString(msgBit));
//            System.out.println();
//            System.out.print("Original Image pixel bits: ");
//            Color x =new Color (image.getRGB(0,0));
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x.getBlue()));
//            System.out.print(" ");
//            Color x1 =new Color (image.getRGB(1,0));
//            System.out.print(ToBinary(x1.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x1.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x1.getBlue()));
//            System.out.print(" ");
//            Color x2 =new Color (image.getRGB(2,0));
//            System.out.print(ToBinary(x2.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x2.getGreen()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x2.getBlue()));
//            System.out.print(" ");
//            Color x3 =new Color (image.getRGB(3,0));
//            System.out.print(ToBinary(x3.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x3.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x3.getBlue()));
//            System.out.print(" ");
//            Color x4 =new Color (image.getRGB(4,0));
//            System.out.print(ToBinary(x4.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x4.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x4.getBlue()));
//            System.out.print(" ");
//            Color x5 =new Color (image.getRGB(5,0));
//            System.out.print(ToBinary(x5.getRed()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x5.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x5.getBlue()));
//            System.out.print(" ");
//            Color x6 =new Color (image.getRGB(6,0));
//            System.out.print(ToBinary(x6.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x6.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x6.getBlue()));
//            System.out.print(" ");
//            Color x7 =new Color (image.getRGB(7,0));
//            System.out.print(ToBinary(x7.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x7.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x7.getBlue()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            Color x8 =new Color (image.getRGB(8,0));
//            System.out.print(ToBinary(x8.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x8.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x8.getBlue()));
//            System.out.print(" ");
//            Color x9 =new Color (image.getRGB(9,0));
//            System.out.print(ToBinary(x9.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x9.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x9.getBlue()));
//            System.out.print(" ");
//            Color x10=new Color (image.getRGB(10,0));
//            System.out.print(ToBinary(x10.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x10.getGreen()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x10.getBlue()));
//            System.out.print(" ");
//            Color x11=new Color (image.getRGB(11,0));
//            System.out.print(ToBinary(x11.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x11.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x11.getBlue()));
//            System.out.print(" ");
//            Color x12=new Color (image.getRGB(12,0));
//            System.out.print(ToBinary(x12.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x12.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x12.getBlue()));
//            System.out.print(" ");
//            Color x13=new Color (image.getRGB(13,0));
//            System.out.print(ToBinary(x13.getRed()));
//            System.out.println(" ");
            
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
//                            la:
//                                {
                                green = c.getGreen();
                                blue = c.getBlue();
                                c = new Color(red,green,blue);
                                image.setRGB(j,i,c.getRGB());
//                                }
                            break;
                            }
                    green = Integer.parseInt(ToBinary(c.getGreen()).substring(0,7)+msgBit[count++],2);
                    if(count>=msgBit.length)
                            { flag = 1;
//                            la:
//                                {
                                blue = c.getBlue();
                                c = new Color(red,green,blue);
                                image.setRGB(j,i,c.getRGB());
//                                }
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
            
//            System.out.print("New pixel bits: ");
//           
//            x =new Color (image.getRGB(0,0));
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x.getBlue()));
//            System.out.print(" ");
//            x1 =new Color (image.getRGB(1,0));
//            System.out.print(ToBinary(x1.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x1.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x1.getBlue()));
//            System.out.print(" ");
//            x2 =new Color (image.getRGB(2,0));
//            System.out.print(ToBinary(x2.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x2.getGreen()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x2.getBlue()));
//            System.out.print(" ");
//            x3 =new Color (image.getRGB(3,0));
//            System.out.print(ToBinary(x3.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x3.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x3.getBlue()));
//            System.out.print(" ");
//            x4 =new Color (image.getRGB(4,0));
//            System.out.print(ToBinary(x4.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x4.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x4.getBlue()));
//            System.out.print(" ");
//            x5 =new Color (image.getRGB(5,0));
//            System.out.print(ToBinary(x5.getRed()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x5.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x5.getBlue()));
//            System.out.print(" ");
//            x6 =new Color (image.getRGB(6,0));
//            System.out.print(ToBinary(x6.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x6.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x6.getBlue()));
//            System.out.print(" ");
//            x7 =new Color (image.getRGB(7,0));
//            System.out.print(ToBinary(x7.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x7.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x7.getBlue()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            x8 =new Color (image.getRGB(8,0));
//            System.out.print(ToBinary(x8.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x8.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x8.getBlue()));
//            System.out.print(" ");
//            x9 =new Color (image.getRGB(9,0));
//            System.out.print(ToBinary(x9.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x9.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x9.getBlue()));
//            System.out.print(" ");
//            x10=new Color (image.getRGB(10,0));
//            System.out.print(ToBinary(x10.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x10.getGreen()));
//            System.out.print(" ");
//            System.out.println("\t \t");
//            System.out.print(ToBinary(x10.getBlue()));
//            System.out.print(" ");
//            x11=new Color (image.getRGB(11,0));
//            System.out.print(ToBinary(x11.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x11.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x11.getBlue()));
//            System.out.print(" ");
//            x12=new Color (image.getRGB(12,0));
//            System.out.print(ToBinary(x12.getRed()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x12.getGreen()));
//            System.out.print(" ");
//            System.out.print(ToBinary(x12.getBlue()));
//            System.out.print(" ");
//            x13=new Color (image.getRGB(13,0));
//            System.out.print(ToBinary(x13.getRed()));
//            System.out.print(" ");
//            
//        System.out.println("Successful! New cover image created");
      
        return image;
    }   
}