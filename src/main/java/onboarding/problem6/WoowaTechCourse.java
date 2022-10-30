package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class WoowaTechCourse {
  private final List<Crew> crews = new ArrayList<>();

  public void addCrewFromForms(List<List<String>> forms) {
    forms.stream().forEach(form -> crews.add(Crew.fromForm(form)));
  }

  public List<String> getCrewEmailByNickname(List<String> nicknames) {
    return crews.stream()
            .filter(crew -> nicknames.contains(crew.getNickname()))
            .map(crew -> crew.getEmail())
            .sorted()
            .collect(Collectors.toList());
  }

  public List<String> getCrewsNickname() {
    return crews.stream().map(crew -> crew.getNickname()).collect(Collectors.toList());
  }
}
