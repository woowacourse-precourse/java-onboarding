package onboarding;

import onboarding.problem2.Decryption;

public class Problem2 {
  public static String solution(String cryptogram) {
    Decryption decryption = new Decryption();
    cryptogram.chars()
            .mapToObj(code -> (char) code)
            .forEach(code -> decryption.decrypt(code));
    return decryption.getMessage();
  }
}
