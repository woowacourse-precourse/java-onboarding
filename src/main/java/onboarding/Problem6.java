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

  private static final Map<String, Set<Integer>> substringMap = new HashMap<>();
  private static final Set<String> answerSet = new TreeSet<>();


  public static List<String> solution(List<List<String>> forms) {
    makeSubstringMap(forms);
    getAnswerSet(forms);
    return new ArrayList<>(answerSet);
  }

  private static void getAnswerSet(List<List<String>> forms) {
    for (Entry<String, Set<Integer>> entries : substringMap.entrySet()) {
      Set<Integer> formIndexes = entries.getValue();
      if (formIndexes.size() > 1) {
        for (Integer index : formIndexes) {
          answerSet.add(forms.get(index).get(0));
        }
      }
    }
  }

  private static void makeSubstringMap(List<List<String>> forms) {
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
