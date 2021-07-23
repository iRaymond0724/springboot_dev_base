package com.dumbo.springboot.controller;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TestAES2 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String encryptionKeyString =  "thisisa128bitkey";
        String originalMessage = "This is a secret message";

        byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
        // 加密
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedMessageBytes = cipher.doFinal(originalMessage.getBytes());

        // 解

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessageBytes);
        if(originalMessage.equals(new String(decryptedMessageBytes))) {
            System.out.println("OK");
        } else {
            System.out.println("Not OK");
        }
//        assertThat(originalMessage).isEqualTo(new String(decryptedMessageBytes));
    }

        /*
            String encryptionKeyString =  "20210518";
        String encryptedMessage = "OPHtmgk45PslFKR8j4UvextAnEkdbtbbmiJKesqCmzrVlkFigPRgOo24rzVh6rIdt0TI1HCOcxA4OTPjFkEJPIs3MyrageIww0Hy/iCoVqo=";

        byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedMessageBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        System.out.println(new String(decryptedMessageBytes));
    * */
}
