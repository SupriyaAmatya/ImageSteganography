package imagesteganography;

import javax.swing.*;
import java.awt.*;

public class ImageSteganography{
    public static void main(String [] args){
        try {
            MainDialog dialog = new MainDialog();
            dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}