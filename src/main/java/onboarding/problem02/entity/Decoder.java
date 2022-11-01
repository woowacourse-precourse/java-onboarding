package onboarding.problem02.entity;

import onboarding.problem02.infra.util.Decryptor;
import onboarding.problem02.infra.util.exception.WithoutPermitLetterException;

public class Decoder {

  private String password;

  private Decoder(String password) {
    // Check Bounds of String
    checkPasswordBounds(password);
    // Check LowerCase for each Char
    checkLowerCase(password);
    this.password = password;
  }

  public static Decoder form(String password) {
    return new Decoder(password);
  }

  public String decryption() {
    return Decryptor.processing(password);
  }

  private void checkPasswordBounds(String password) {
    if (password.length() < 1 || password.length() > 1000) {
      throw new StringIndexOutOfBoundsException();
    }
  }

  private void checkLowerCase(String password) {
    char[] chars = password.toCharArray();
    for (char aChar : chars) {
      if (!Character.isLowerCase(aChar)) {
        throw new WithoutPermitLetterException();
      }
    }
  }
}
