package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    Map<String, Set<Integer>> substringMap = new HashMap<>();
    makeSubstringMap(forms, substringMap);
    return getAnswerSet(forms, substringMap);
  }

  private static ArrayList<String> getAnswerSet(List<List<String>> forms,
      Map<String, Set<Integer>> substringMap) {
    Set<String> result = new TreeSet<>();
    for (Entry<String, Set<Integer>> entries : substringMap.entrySet()) {
      Set<Integer> formIndexes = entries.getValue();
      if (formIndexes.size() > 1) {
        addDuplicatedFormIndexes(forms, result, formIndexes);
      }
    }
    return new ArrayList<>(result);
  }

  private static void addDuplicatedFormIndexes(List<List<String>> forms, Set<String> result,
      Set<Integer> formIndexes) {
    for (Integer index : formIndexes) {
      result.add(forms.get(index).get(0));
    }
  }

  private static void makeSubstringMap(List<List<String>> forms,
      Map<String, Set<Integer>> substringMap) {
    for (int formIndex = 0; formIndex < forms.size(); formIndex++) {
      String nickName = forms.get(formIndex).get(1);
      for (int i = 0; i < nickName.length() - 1; i++) {
        String substring = nickName.substring(i, i + 2);
        Set<Integer> indexes = substringMap.getOrDefault(substring, new HashSet<>());
        indexes.add(formIndex);
        substringMap.put(substring, indexes);
      }
    }
  }
}
