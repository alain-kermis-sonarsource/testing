package org.example;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    try {
      Cipher des = Cipher.getInstance("DES"); // Noncompliant
      Cipher des2 = Cipher.getInstance("DES"); // Noncompliant
      Cipher des3 = Cipher.getInstance("DES"); // Noncompliant


      SecureRandom sr = new SecureRandom();
      sr.setSeed(123456L); // Noncompliant
      sr.setSeed(123456L); // Noncompliant
      sr.setSeed(123456L); // Noncompliant
      sr.setSeed(123456L); // Noncompliant
      int v = Math.toIntExact(sr.nextLong());

      sr = new SecureRandom("abcdefghijklmnop".getBytes("us-ascii")); // Noncompliant
      sr = new SecureRandom("abcdefghijklmnop".getBytes("us-ascii")); // Noncompliant
      v = Math.toIntExact(sr.nextLong());

    } catch(NoSuchAlgorithmException | NoSuchPaddingException e) {
      // ...
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
