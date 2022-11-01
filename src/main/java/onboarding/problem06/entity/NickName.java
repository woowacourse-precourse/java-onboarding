package onboarding.problem06.entity;

import onboarding.problem06.infra.exception.NickNameException;

public class NickName {

  private String name;

  private NickName(String name) {
    if (name.length() < 1 || name.length() > 20) {
      throw new NickNameException();
    }
    this.name = name;
  }

  public static NickName from(String name) {
    return new NickName(name);
  }
}
