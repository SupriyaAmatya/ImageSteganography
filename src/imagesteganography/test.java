package imagesteganography;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
import static imagesteganography.MethodsUsed.ToBinary;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

public class test {
//    public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
//        Key k = keyGeneration("hello12");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE,k);
//        byte [] encrypted = cipher.doFinal("This is a test string.".getBytes());
//        String messageCipher = new BASE64Encoder().encode(encrypted);
//        System.out.println(messageCipher);
//    }
//    
    public static Key keyGeneration(String key) throws UnsupportedEncodingException{
        while(key.length()!=16){
            key = key +"a";
        }
        Key k = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        return k;
    }
    
//        public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, BadPaddingException{
//        String key = DecryptionPanel.key;
//        Key k = keyGeneration("hello12");
//        System.out.println("Given String: vyoeY0tNi5amaMLoPoU5OMrn7xCV3vQjyZMGsCRzWOw=");
//        System.out.println("Key: hello12");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, k);
//        byte[] decodedValue = new BASE64Decoder().decodeBuffer("vyoeY0tNi5amaMLoPoU5OMrn7xCV3vQjyZMGsCRzWOw=");
//        byte[] original = cipher.doFinal(decodedValue);
//        String message = new String(original);
//        System.out.println("Decrypted String: "+message);
//    }
    
    
    
    
//    public static void main (String [] args) throws IOException{
//        String messageCipher = "test";
//        
//        BufferedImage image = ImageIO.read(new File("image.jpg"));
//        int width =image.getWidth();
//        int height =image.getHeight();
//         
//            int count = 0;
//            char [] msgBit = new char[messageCipher.length()*8];
//            for(int i=0; i< messageCipher.length(); i++){
//                String charBinary = ToBinary(messageCipher.charAt(i));
//                for(int j=0; j<8; j++){
//                    msgBit[count++] = charBinary.charAt(j);
//                }
//            }
//            
////            System.out.println(Arrays.toString(msgBit));
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
//            
//            count = 0;
//            int red, green, blue;
//            Color c;
//            int flag = 0;
//            
//            for(int i=0; i<height; i++){
//                for(int j=0; j<width; j++){
//                    c = new Color(image.getRGB(j,i));
//                    red = Integer.parseInt(ToBinary(c.getRed()).substring(0,7)+msgBit[count++],2);
//                    if(count>=msgBit.length)
//                            { flag = 1;
////                            la:
////                                {
//                                green = c.getGreen();
//                                blue = c.getBlue();
//                                c = new Color(red,green,blue);
//                                image.setRGB(j,i,c.getRGB());
////                                }
//                            break;
//                            }
//                    green = Integer.parseInt(ToBinary(c.getGreen()).substring(0,7)+msgBit[count++],2);
//                    if(count>=msgBit.length)
//                            { flag = 1;
////                            la:
////                                {
//                                blue = c.getBlue();
//                                c = new Color(red,green,blue);
//                                image.setRGB(j,i,c.getRGB());
////                                }
//                                break;
//                            }
//                    blue = Integer.parseInt(ToBinary(c.getBlue()).substring(0,7)+msgBit[count++],2);
//                    c = new Color(red,green,blue);
//                    image.setRGB(j,i,c.getRGB());
//                    if(count>=msgBit.length)
//                            { flag = 1;
//                              break;
//                            }
//                }
//                if(flag==1){break;}
//            }
//
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
//            System.out.println();
//            
//            System.out.println("New Image created and saved successfully");
//            
//            File res = new File("result.png");
//            
//            ImageIO.write(image, "png", res);
//    }
    
    
    
    
    
    public static char lsb(int col)
    {
        String colBinary = ToBinary(col);
        return colBinary.charAt(7);
    }

    public static void main(String [] args) throws Exception, ArrayIndexOutOfBoundsException{
        BufferedImage image = ImageIO.read(new File("image.jpg"));
        int count = 0;
        char [] messageBits = new char [32];
        for(int i=0;i<image.getHeight();i++){
            for(int j=0;j<image.getWidth();j++){
                Color c = new Color(image.getRGB(j,i));
                messageBits[count++] = lsb(c.getRed());
                if(count==32) break;
                messageBits[count++] = lsb(c.getGreen());
                if(count==32) break;
                messageBits[count++] = lsb(c.getBlue());
                if(count==32) break;
            }
            if(count==32) break;
        }

        System.out.print("First 32 LSBs: "+Arrays.toString(messageBits));
        count = 0;
//        StringBuilder length = new StringBuilder("");
        StringBuilder letterBinary;
//        for(int i=0; i<4; i++){
//            letterBinary = new StringBuilder("");
//            for(int j=0; j<8; j++){
//                letterBinary.append(messageBits[count++]);
//            }
//            if((char) Integer.parseInt(letterBinary.toString(),2)=='/'){
//                msgLen = (Integer.parseInt(length.toString()))/2;
//                break;
//            }
//            length.append((char) Integer.parseInt(letterBinary.toString(),2));   
//        }

        StringBuilder msg = new StringBuilder("");
        int i;
        for(i=0 ; i<4 ; i++){
            letterBinary = new StringBuilder("");
            for(int j=0; j<8; j++){
                letterBinary.append(messageBits[count++]);
            }
            msg.append((char) Integer.parseInt(letterBinary.toString(),2));
        }
        
        String messageCipher = msg.toString();
        System.out.println();
        System.out.println("Extracted String: "+messageCipher);
    }
}
