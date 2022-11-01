package onboarding.problem06.entity;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem06.infra.util.GenerateReduplicateList;

public class Crew {

  private Email email;
  private NickName nickName;

  private List<String> matchNameList;

  private Crew(String crewEmail, String crewNickName) {
    this.email = Email.from(crewEmail);
    this.nickName = NickName.from(crewNickName);
    matchNameList = new ArrayList<>();
    matchNameList = GenerateReduplicateList.generate(nickName.currentName());
  }

  public static Crew of(List<String> crewForm) {
    return new Crew(crewForm.get(0), crewForm.get(1));
  }

  public String currentEmailAddress() {
    return email.currentEmail();
  }

  public List<String> currentCrewMatchNameList() {
    return matchNameList;
  }

  public boolean compareCrewName(Crew crew) {
    for (String nameList : matchNameList) {
      if (crew.nickName.currentName().contains(nameList)) {
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
