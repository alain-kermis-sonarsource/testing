package org.example;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    try {
      Cipher des = Cipher.getInstance("DES"); // Noncompliant
    } catch(NoSuchAlgorithmException | NoSuchPaddingException e) {
      // ...
    }
  }
}
