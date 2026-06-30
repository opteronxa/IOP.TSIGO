package claves;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author xanum
 */
public class Criptor_AES128 {  // === Cifrado/descifrado 3DES ECB Base64 ===
    
    private final SecretKey SECRETKEY;
    private final Cipher CIPHER;
    private final String AESKEY;
    
    
    public Criptor_AES128() throws Exception {
        KeyGenerator y_keyGen = KeyGenerator.getInstance("AES");
        y_keyGen.init(128);                                                     // puedes usar 128 o 192 también
        this.SECRETKEY = y_keyGen.generateKey();
        this.CIPHER = Cipher.getInstance("AES/ECB/PKCS5Padding");
        this.CIPHER.init(Cipher.ENCRYPT_MODE, this.SECRETKEY);
        this.AESKEY = Base64.getEncoder().encodeToString(this.SECRETKEY.getEncoded());
    }
    
    public String getAESKEY() {
        return this.AESKEY;
    }
    
    public String encriota(String _msj) throws Exception {
        byte[] y_encryptedBytes = this.CIPHER.doFinal(_msj.getBytes("UTF-8"));
        String y_encryptedBase64 = Base64.getEncoder().encodeToString(y_encryptedBytes);
        return y_encryptedBase64;
    }   
    
    public String desencripta(String _cryp) throws Exception {
        this.CIPHER.init(Cipher.DECRYPT_MODE, this.SECRETKEY);
        byte[] y_decryptedBytes = this.CIPHER.doFinal(Base64.getDecoder().decode(_cryp));
        String y_decryptedJson = new String(y_decryptedBytes, "UTF-8");
        return y_decryptedJson;
    }
    
}