package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
  public static List<String> solution(List<List<String>> forms) {
    Validator.validate(forms);
    Set<String> emailHashSet = selectEmailFromDuplicatedUserNickname(forms);

    return emailHashSet.stream().sorted().collect(Collectors.toList());
  }

  private static Set<String> selectEmailFromDuplicatedUserNickname(List<List<String>> forms) {
    List<Crew> crewArrayList = new ArrayList<>();
    Set<String> emailHashSet = new HashSet<>();
    for (List<String> form : forms) {
      for (Crew crew : crewArrayList) {
        if (isContinuousStringByTwo(getName(form), crew.name)) {
          emailHashSet.add(getEmail(form));
          emailHashSet.add(crew.email);
        }
      }
      crewArrayList.add(new Crew(getName(form), getEmail(form)));
    }
    return emailHashSet;
  }

  private static String getEmail(List<String> form) {
    return form.get(0);
  }

  private static String getName(List<String> form) {
    return form.get(1);
  }

  private static boolean isContinuousStringByTwo(String base, String target) {

    int baseLength = base.length();
    int targetLength = target.length();
    for (int i = 0; i < baseLength - 1; i++) {
      for (int j = 0; j < targetLength - 1; j++) {
        if (isOverlappedSection(base, target, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isOverlappedSection(String base, String target, int i, int j) {
    return base.charAt(i) == target.charAt(j) && (base.charAt(i + 1) == target.charAt(j + 1));
  }
}
