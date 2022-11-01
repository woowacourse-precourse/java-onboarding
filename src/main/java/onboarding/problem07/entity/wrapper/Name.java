package onboarding.problem07.entity.wrapper;

import onboarding.problem07.infra.exception.NameLengthException;
import onboarding.problem07.infra.exception.NameNotSmallLetterCaseException;

public class Name {

  private String name;

  private Name(String name) {
    if (name.length() < 1 || name.length() > 30) {
      throw new NameLengthException();
    }
    if (checkNameUpperCase(name)) {
      throw new NameNotSmallLetterCaseException();
    }
    this.name = name;
  }

  public static Name from(String name) {
    return new Name(name);
  }

  private boolean checkNameUpperCase(String name) {
    char[] chars = name.toCharArray();
    for (char aChar : chars) {
      if (Character.isUpperCase(aChar)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }

    Name name1 = (Name) o;

    return name != null ? name.equals(name1.name) : name1.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
