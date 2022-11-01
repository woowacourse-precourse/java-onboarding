package onboarding.problem06.entity;

import onboarding.problem06.infra.exception.NickNameLengthException;
import onboarding.problem06.infra.exception.NickNameNotKoreanException;

public class NickName {

  private String name;

  private NickName(String name) {
    if (name.length() < 1 || name.length() > 20) {
      throw new NickNameLengthException();
    }
    if (!name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
      throw new NickNameNotKoreanException();
    }
    this.name = name;
  }

  public static NickName from(String name) {
    return new NickName(name);
  }

  public String currentName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NickName)) {
      return false;
    }

    NickName nickName = (NickName) o;

    return name != null ? name.equals(nickName.name) : nickName.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
