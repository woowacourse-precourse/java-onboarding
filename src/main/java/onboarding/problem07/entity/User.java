package onboarding.problem07.entity;

import onboarding.problem07.entity.wrapper.Name;

public class User {

  private Name userName;

  private User(String name) {
    userName = Name.from(name);
  }

  public static User from(String name) {
    return new User(name);
  }

  public Name currentUser() {
    return userName;
  }

}
