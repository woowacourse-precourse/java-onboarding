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
