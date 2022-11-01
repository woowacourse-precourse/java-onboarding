package onboarding.problem06.entity;

import onboarding.problem06.infra.exception.EmailFormatException;
import onboarding.problem06.infra.exception.EmailLengthException;

public class Email {

  private String email;

  private Email(String email) {
    if (email.length() < 11 || email.length() >= 20) {
      throw new EmailLengthException();
    }
    if (!email.contains("email.com")) {
      throw new EmailFormatException();
    }
    this.email = email;
  }

  public static Email from(String email) {
    return new Email(email);
  }
}
