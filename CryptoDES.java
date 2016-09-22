package DES;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class CryptoDES {

    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    private static Cipher encrypter;

    public static void main(String args[]) throws UnsupportedEncodingException{

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        try{

            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();

            SecureRandom secureRandom = new SecureRandom();
            byte[] bytes = new byte[8];
            secureRandom.nextBytes(bytes);

            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "DES");

            encryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);

            encrypter = Cipher.getInstance("DES");
            encrypter.init(Cipher.ENCRYPT_MODE, secretKey);

            decryptCipher = Cipher.getInstance("DES");
            decryptCipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            byte[] encryptedData = encrypt(string, true);
            byte[] encryptData = encrypt("ABCDEFG", false);
            System.out.println("Encrypted " + Arrays.toString(encryptedData) + " " + encryptedData.length);
            System.out.println("Encrypted " + Arrays.toString(encryptData) + " " + encryptData.length);
            decrypt(encryptedData);

        }
        catch (java.security.InvalidKeyException e){

            e.printStackTrace();
        }

        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e){

            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e){
            e.printStackTrace();
        }
        catch (BadPaddingException e){
            e.printStackTrace();
        }

    }

    private static byte[] encrypt(String data, boolean flag) throws BadPaddingException, IllegalBlockSizeException,
            UnsupportedEncodingException {

        byte[] byteData = data.getBytes();
        return encryptCipher.doFinal(byteData);

    }

    private static void decrypt(byte[] data) throws BadPaddingException, IllegalBlockSizeException {

        System.out.println("Decrypted: " + new String(decryptCipher.doFinal(data)));
    }
}
