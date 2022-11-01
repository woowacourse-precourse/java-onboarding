package onboarding.problem06.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Crews {

  private List<Crew> crewList;
  private Set<Crew> result;

  public Crews(List<List<String>> forms) {
    crewList = new ArrayList<>();
    for (List<String> form : forms) {
      crewList.add(Crew.of(form));
    }
    result = new HashSet<>();
  }

  public static Crews from(List<List<String>> forms) {
    return new Crews(forms);
  }

  public List<String> run() {
    for (int i = 0; i < crewList.size() - 1; i++) {
      for (int j = i + 1; j < crewList.size(); j++) {
        if (compareCrew(crewList.get(i), crewList.get(j))) {
          result.add(crewList.get(i));
          result.add(crewList.get(j));
        }
      }
    }
    List<Crew> sortedResult = result.stream().sorted(Comparator.comparing(Crew::currentEmailAddress))
        .collect(Collectors.toList());

    return sortedResult.stream().map(email -> email.currentEmailAddress())
        .collect(Collectors.toList());
  }

  private boolean compareCrew(Crew preCrew, Crew postCrew) {
    if (preCrew.compareCrewName(postCrew)) {
      return true;
    }
    return false;
  }
}
