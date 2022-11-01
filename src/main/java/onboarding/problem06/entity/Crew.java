package onboarding.problem06.entity;

public class Crew {

  private NickName nickName;
  private Email email;

  private Crew(NickName nickName, Email email) {
    this.nickName = nickName;
    this.email = email;
  }

  public static Crew of(NickName nickName, Email email) {
    return new Crew(nickName, email);
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
