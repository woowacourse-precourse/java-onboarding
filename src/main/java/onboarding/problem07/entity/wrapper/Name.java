package onboarding.problem07.entity.wrapper;

import onboarding.problem07.infra.exception.NameLengthException;

public class Name {

  private String name;

  private Name(String name) {
    if (name.length() < 1 || name.length() > 30) {
      throw new NameLengthException();
    }
    this.name = name;
  }

  public static Name from(String name) {
    return new Name(name);
  }
}
