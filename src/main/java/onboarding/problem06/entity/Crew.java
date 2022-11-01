package onboarding.problem06.entity;

import java.util.List;

public class Crew {

  private Email email;
  private NickName nickName;

  private Crew(String crewEmail, String crewNickName) {
    email.from(crewEmail);
    nickName.from(crewNickName);
  }

  public static Crew of(List<String> crewForm) {
    return new Crew(crewForm.get(0), crewForm.get(1));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Crew)) {
      return false;
    }

    Crew crew = (Crew) o;

    if (nickName != null ? !nickName.equals(crew.nickName) : crew.nickName != null) {
      return false;
    }
    return email != null ? email.equals(crew.email) : crew.email == null;
  }

  @Override
  public int hashCode() {
    int result = nickName != null ? nickName.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
