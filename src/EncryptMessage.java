import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EncryptMessage {
    
    static byte[] text;
    static Scanner scannerObj = new Scanner(System.in);
    
    EncryptMessage() throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        
            System.out.println("What should be encrypted?");
            text = scannerObj.nextLine().getBytes("UTF8");
            
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(256);
            SecretKey key = keygen.generateKey();

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String s = new String(text);
            System.out.println("Preencryption: " + s);
            byte[] textEncrypted = cipher.doFinal(text);
            s = new String(textEncrypted);
            System.out.println("Encrypted: " + s);
    
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] reversed = cipher.doFinal(textEncrypted);
            s = new String(reversed);
            System.out.println("Reversed: " + s);
    }
}
