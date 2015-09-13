package ca.simba.resumeapp.util;

import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;



public class Pass {

    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };

    public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        Log.e("Encrypt", "Stored in SP no encode: " + pbeCipher.doFinal(property.getBytes("UTF-8")));
        Log.e("Encrypt", "Stored in SP: " + base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8"))));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        String yo;
        try {
            yo = new String(Base64.encode(bytes, Base64.DEFAULT),"UTF-8");
            Log.e("Encrypt", "utf encode" + yo);
        } catch (Exception e) {
            yo = new String(Base64.encode(bytes, Base64.DEFAULT));
            Log.e("Auth",e.getMessage());
        }
        return yo;
    }

    public static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        Log.e("Encrypt", "Take encrypted and base 64decode: " + base64Decode(property));
        Log.e("Encrypt", "Full decryot " + Base64.encodeToString(new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8").getBytes("UTF-8"),Base64.DEFAULT));
        return Base64.encodeToString(new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8").getBytes("UTF-8"),Base64.DEFAULT);
        //return Base64.encodeToString(new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8").getBytes(), Base64.DEFAULT);
    }

    public static String decryptPass(String password) {
        byte[] bytePass;
        String pass;
        try {
            pass = decrypt(password);
        } catch (GeneralSecurityException e) {
            pass = password;
        } catch (IOException e) {
            pass = password;
        }
        try {
            bytePass = pass.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bytePass = pass.getBytes();
        }
        return Base64.encodeToString(bytePass,Base64.DEFAULT);
    }

    private static byte[] base64Decode(String property) throws IOException {
        // NB: This class is internal, and you probably should use another impl
        byte[] yo = property.getBytes("UTF-8");
        return Base64.decode(yo,Base64.DEFAULT);
    }
}
