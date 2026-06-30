package claves;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author ByXanum
 */

public class Criptor_RSA {  // === Cifrado/descifrado 3DES ECB Base64 ===
    
    private final PublicKey PUBLIC_KEY;
    private final PrivateKey PRIVATE_KEY;
    private final Cipher CIPHER;
    
    public Criptor_RSA() throws Exception {                                     //Generar par de llaves RSA (2048 bits)
        KeyPairGenerator y_keyGen = KeyPairGenerator.getInstance("RSA");
        y_keyGen.initialize(2048);
        KeyPair y_keyPair = y_keyGen.generateKeyPair();
        this.PUBLIC_KEY = y_keyPair.getPublic();
        this.PRIVATE_KEY = y_keyPair.getPrivate();
        this.CIPHER = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        byte[] y_pubKeyBytes = this.PUBLIC_KEY.getEncoded();
        String y_pubKeyBase64 = Base64.getEncoder().encodeToString(y_pubKeyBytes);
        StringBuilder y_pubpem = new StringBuilder();
        y_pubpem.append("-----BEGIN PUBLIC KEY-----\n");
        for (int i = 0; i < y_pubKeyBase64.length(); i += 64) {
            int y_end = Math.min(i + 64, y_pubKeyBase64.length());
            y_pubpem.append(y_pubKeyBase64, i, y_end).append("\n");
        }
        y_pubpem.append("-----END PUBLIC KEY-----");
        System.out.println(y_pubpem.toString());
        byte[] y_privKeyBytes = this.PRIVATE_KEY.getEncoded();
        String y_privKeyBase64 = Base64.getEncoder().encodeToString(y_privKeyBytes);
        StringBuilder y_privpem = new StringBuilder();
        y_privpem.append("-----BEGIN PRIVATE KEY-----\n");
        for (int i = 0; i < y_privKeyBase64.length(); i += 64) {
            int y_end = Math.min(i + 64, y_privKeyBase64.length());
            y_privpem.append(y_privKeyBase64, i, y_end).append("\n");
        }
        y_privpem.append("-----END PRIVATE KEY-----");
        System.out.println(y_privpem.toString());
    }
    
    public String Cifra(String _msj) throws Exception {                  //Cifrar con la llave pública
        this.CIPHER.init(Cipher.ENCRYPT_MODE, this.PUBLIC_KEY);
        byte[] y_encryptedBytes = this.CIPHER.doFinal(_msj.getBytes("UTF-8"));
        String y_encryptedBase64 = Base64.getEncoder().encodeToString(y_encryptedBytes);
        return y_encryptedBase64;
    }
    
    public String Descifar(String _crip) throws Exception {                //Descifrar con la llave privada
        this.CIPHER.init(Cipher.DECRYPT_MODE, this.PRIVATE_KEY);
        byte[] y_decryptedBytes = this.CIPHER.doFinal(Base64.getDecoder().decode(_crip));
        String y_decryptedText = new String(y_decryptedBytes, "UTF-8");
        return y_decryptedText;
    }    

}
