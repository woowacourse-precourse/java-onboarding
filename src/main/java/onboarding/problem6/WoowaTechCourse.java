package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class WoowaTechCourse {
  private final List<Crew> crews = new ArrayList<>();

  public void addCrewFromForms(List<List<String>> forms) {
    forms.stream().forEach(crew -> crews.add(new Crew(crew.get(0), crew.get(1))));
  }

  public List<String> getCrewEmailByNickname(List<String> nicknames) {
    return crews.stream()
            .filter(crew -> nicknames.contains(crew.getNickname()))
            .map(crew -> crew.getEmail())
            .sorted()
            .collect(Collectors.toList());
  }

  public List<Crew> getCrews() {
    return crews;
  }
}
