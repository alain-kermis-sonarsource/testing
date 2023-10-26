package org.example;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main {
  private static final Logger logger = Logger.getLogger("Logger");

  public static void main(String[] args) {
    logger.info("Hello world!");
  }

  private void high() {
    try {
      Cipher des = Cipher.getInstance("DES"); // Noncompliant
    } catch(NoSuchAlgorithmException | NoSuchPaddingException e) {
      // ...
    }
  }

  private void medium(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Optional<Cookie> cookieOpt = Arrays.stream(request.getCookies())
      .filter(c -> c.getName().equals("jsessionid"))
      .findFirst();

    if (cookieOpt.isEmpty()) {
      String cookie = request.getParameter("cookie");
      Cookie cookieObj = new Cookie("jsessionid", cookie);
      response.addCookie(cookieObj);
    }

    response.sendRedirect("/welcome.jsp");
  }

  private void low(HttpServletRequest request) {
    String data = request.getParameter("data");
    if(data != null){
      logger.log(Level.INFO, "Data: {0} ", data);
    }
  }

}
