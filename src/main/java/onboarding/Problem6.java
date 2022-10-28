package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
  public static List<String> solution(List<List<String>> forms) {
    List<String> nicknames = forms.stream().map(item -> item.get(1)).collect(Collectors.toList());
    Map<String, Set<String>> keywordStore = getKeywordStore(nicknames);
    return List.of("");
  }

  private static Map<String, Set<String>> getKeywordStore(List<String> nicknames) {
    Map<String, Set<String>> keywordStore = new HashMap<>();
    for (String name : nicknames) {
      for (int i = 0; i < name.length() - 1; i++) {
        String s = "" + name.charAt(i) + name.charAt(i + 1);
        if (keywordStore.containsKey(s)) {
          keywordStore.get(s).add(name);
          continue;
        }
        Set<String> nicknameStore = new HashSet<>();
        nicknameStore.add(name);
        keywordStore.put(s, nicknameStore);
      }
    }
    return keywordStore;
  }
}
