import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class GenKey {

    String message;

    public GenKey() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        message = "Genkey constructor message";
        System.out.println(message);
    }

    public void genAES() throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecretKey key = keygen.generateKey();

        char[] password = "pass123".toCharArray();

        KeyStore ks = KeyStore.getInstance("JKS");
        
        java.io.FileInputStream fis = null;
        try {
            fis = new java.io.FileInputStream("keyStoreName");
            ks.load(fis, password);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }        
    }
} 