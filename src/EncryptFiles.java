import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptFiles {

    static String menuSelection;
    static Scanner scannerObj = new Scanner(System.in);

    public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, CertificateException, IOException {

        getMenuSelection();
    }

    static void getMenuSelection() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, CertificateException, IOException {
        
        System.out.println("1-Generate Key");
        System.out.println("2-Encrypt message");
        System.out.println("3-Decrypt message");

        Integer mMenuChoice = scannerObj.nextInt();

        switch (mMenuChoice) {
            case 1:
                GenKey genKeyObj = new GenKey();
                genKeyObj.genAES();
            break;
            case 2:
                EncryptMessage encryptMessageObj = new EncryptMessage();
                encryptMessageObj.doEncryption();
            break;
            case 3:
                DecryptMessage decryptMessageObj = new DecryptMessage();
                decryptMessageObj.doDecryption();
            break;
            default:
                getMenuSelection();
        }
    }
}