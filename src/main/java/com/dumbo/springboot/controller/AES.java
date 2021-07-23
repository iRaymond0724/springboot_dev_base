package com.dumbo.springboot.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
/**
 * Using:
 *   String decryptedStr = AES.decryptFromBase64("token...", "20210518") ;
 *
 */
public class AES {
    private static String AESMODE = "AES/ECB/PKCS5Padding";
    private static SecretKeySpec secretKey;

    public static void main(String[] args) {

//        String encryptedMessage = "OPHtmgk45PslFKR8j4UvextAnEkdbtbbmiJKesqCmzrVlkFigPRgOo24rzVh6rIdt0TI1HCOcxA4OTPjFkEJPIs3MyrageIww0Hy/iCoVqo=";
//        String pwd = "20210518";
//        setKey(pwd);
//        System.out.println(decryptFromBase64(encryptedMessage, pwd));

        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        JSONObject obj_1 = new JSONObject();
        obj_1.put("started", "20210609");
        obj_1.put("expired","20201024");
        obj_1.put("user","Raymond");

        JSONObject obj_3 = new JSONObject();
        obj_3.put("started", "20210709");
        obj_3.put("expired","20211024");
        obj_3.put("user","Tina");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(obj_1);
        jsonArray.put(obj_3);

        JSONObject obj_2 = new JSONObject();
        obj_2.put("share_list", jsonArray);

        System.out.println(obj_2.toString());
        System.out.println(obj_2.get("share_list"));
        JSONArray jsonArray2 = obj_2.getJSONArray("share_list");
        for(int i = 0;i<jsonArray2.length();i++) {
            System.out.println(jsonArray2.get(i));
        }
    }
    
    public static void setKey(String myKey) {
        byte[] key;
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String decryptFromBase64(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance(AESMODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
           
}