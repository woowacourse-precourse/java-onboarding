package onboarding.problem06.entity;

import java.util.ArrayList;
import java.util.List;

public class Crews {

  private List<Crew> crewList;

  public Crews(List<List<String>> forms) {
    crewList = new ArrayList<>();
    for (List<String> form : forms) {
      crewList.add(Crew.of(form));
    }
  }

  public static Crews from(List<List<String>> forms) {
    return new Crews(forms);
  }

}
