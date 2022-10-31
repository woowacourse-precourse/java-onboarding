package onboarding.problem02.entity;

import onboarding.problem02.util.exception.WithoutPermitLetterException;

public class Decoder {

  private String password;

  private Decoder(String password) {
    this.password = password;
  }

  public static Decoder form(String password) {
    if (password.length() < 1 || password.length() > 1000) {
      throw new StringIndexOutOfBoundsException();
    }
    char[] chars = password.toCharArray();

    for (char aChar : chars) {
      if (!Character.isLowerCase(aChar)) {
        throw new WithoutPermitLetterException();
      }
    }

    return new Decoder(password);
  }
}
