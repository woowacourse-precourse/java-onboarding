package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    Map<String, List<Integer>> nicknameParseMap = new HashMap<>();
    parseNickname(forms, nicknameParseMap);
    Set<String> answer = getAnswer(forms, nicknameParseMap);
    return new ArrayList<>(answer);
  }

  private static void parseNickname(List<List<String>> forms,
      Map<String, List<Integer>> nicknameParseMap) {
    for (int crewIndex = 0; crewIndex < forms.size(); crewIndex++) {
      List<String> form = forms.get(crewIndex);
      String nickname = form.get(1);
      for (int i = 1; i < nickname.length(); i++) {
        String substring = nickname.substring(i - 1, i + 1);
        if (nicknameParseMap.containsKey(substring)) {
          nicknameParseMap.get(substring).add(crewIndex);
        } else {
          nicknameParseMap.put(substring, new ArrayList<>(List.of(crewIndex)));
        }
      }
    }
  }

  private static Set<String> getAnswer(List<List<String>> forms,
      Map<String, List<Integer>> nicknameParseMap) {
    Set<String> answer = new TreeSet<>();
    for (List<Integer> crewList : nicknameParseMap.values()) {
      if (crewList.size() >= 2) {
        for (Integer crewIndex : crewList) {
          String email = forms.get(crewIndex).get(0);
          answer.add(email);
        }
      }
    }
    return answer;
  }
}
