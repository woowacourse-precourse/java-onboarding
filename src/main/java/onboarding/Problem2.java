package onboarding;

import onboarding.problem2.Decryption;

public class Problem2 {
  public static String solution(String cryptogram) {
    Decryption decryption = new Decryption();
    decryption.decryptCryptogram(cryptogram);
    return decryption.getMessage();
  }
}
