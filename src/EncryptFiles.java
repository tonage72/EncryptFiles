import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptFiles {

    static String menuSelection;
    static Scanner scannerObj = new Scanner(System.in);

    public static void main(String args[]) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        getMenuSelection();
    }

    static void getMenuSelection() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        System.out.print("\033[H\033[2J");
        System.out.println("1-Generate Key");
        System.out.println("2-Encrypt message");
        System.out.println("3-Decrypt message");

        Integer mMenuChoice = scannerObj.nextInt();

        switch (mMenuChoice) {
            case 1:
                new GenKey();
            break;
            case 2:
                new EncryptMessage();
            break;
            case 3:
                new DecryptMessage();
            break;
            default:
                getMenuSelection();
        }
    }
}
